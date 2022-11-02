/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Groupexpense;
import com.ntv.repository.GroupExpenseRepository;
import com.ntv.service.GroupExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class GroupExpenseServiceImpl implements GroupExpenseService{
    
    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @Override
    public boolean addIncomeGroup(Groupexpense expenseGroup) {
        return this.groupExpenseRepository.addIncomeGroup(expenseGroup);
    }

    @Override
    public boolean addIncomeGroupFromTemp(int userId, int groupId, long money, String purpose, int type) {
        return this.groupExpenseRepository.addIncomeGroupFromTemp(userId, groupId, money, purpose, type);
    }

}
