/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Groupexpense;

/**
 *
 * @author inmac
 */
public interface GroupExpenseService {
    boolean addIncomeGroup(Groupexpense expenseGroup);
    boolean addIncomeGroupFromTemp(int userId, int groupId, long money, String purpose, int type);
}
