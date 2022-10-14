/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Groupexpensetemp;
import com.ntv.repository.GroupExpenseRepositoryTemp;
import com.ntv.service.GroupExpenseServiceTemp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class GroupExpenseServiceTempImpl implements GroupExpenseServiceTemp{
    
    @Autowired
    private GroupExpenseRepositoryTemp groupexpensetemp;

    @Override
    public boolean addExpenseGroupTemp(Groupexpensetemp expensetemp) {
        return this.groupexpensetemp.addExpenseGroupTemp(expensetemp);
    }

    @Override
    public List<Groupexpensetemp> getExpenseTemp(int groupid) {
        return this.groupexpensetemp.getExpenseTemp(groupid);
        
    }

    @Override
    public boolean deleteExpenseGroupTemp(int id) {
        return this.groupexpensetemp.deleteExpenseGroupTemp(id);
    }
    
}
