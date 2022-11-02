/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Groupexpense;
import com.ntv.repository.GroupExpenseRepository;
import com.ntv.repository.GroupRepository;
import com.ntv.repository.UserRepository;
import java.util.Date;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Repository
@Transactional
public class GroupExpenseRepositoryImpl implements GroupExpenseRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public boolean addIncomeGroup(Groupexpense expenseGroup) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(expenseGroup);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            session.clear();
        }

        return false;
    }

    @Override
    public boolean addIncomeGroupFromTemp(int userId, int groupId, long money, String purpose, int type) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try{
            Groupexpense exGroup = new Groupexpense();
            exGroup.setUserId(this.userRepository.getUsers(authentication.getName()).getId());
            exGroup.setGroupId(this.groupRepository.getGroupById(groupId).getId());
            exGroup.setCreatedDate(new Date());
            exGroup.setPurpose(purpose);
            exGroup.setPrice(money);
            exGroup.setType(type);
            
            session.save(exGroup);
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
        }
        
        return false;
    }

}
