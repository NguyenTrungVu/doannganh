/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Groupexpensetemp;
import com.ntv.repository.GroupExpenseRepositoryTemp;
import com.ntv.repository.UserRepository;
import com.ntv.service.GroupExpsenseTepmService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 
 */
@Service
public class GroupExpsenseTepmServiceImpl implements GroupExpsenseTepmService{

    @Autowired
    private GroupExpenseRepositoryTemp groupExpenseRepositoryTemp;
    @Autowired
    private UserRepository  userRepository;

    @Override
    public boolean addExpenseGroupTemp(Groupexpensetemp expensetemp) {
        long cost = expensetemp.getPrice();
        expensetemp.setPrice(cost);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        expensetemp.setUserId(this.userRepository.getUsers(authentication.getName()).getId());
        expensetemp.setCreatedDate(new Date());
        int type = expensetemp.getType();
        expensetemp.setType(type);
        return this.groupExpenseRepositoryTemp.addExpenseGroupTemp(expensetemp);
    }

    @Override
    public List<Groupexpensetemp> getExpenseTemp(int groupid) {
        return this.groupExpenseRepositoryTemp.getExpenseTemp(groupid);
    }

    @Override
    public boolean deleteExpenseGroupTemp(int id) {
        return this.groupExpenseRepositoryTemp.deleteExpenseGroupTemp(id);
    }
    
   
    
}
