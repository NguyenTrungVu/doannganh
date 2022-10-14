/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Groupexpense;

/**
 *
 * @author inmac
 */
public interface GroupExpenseRepository {
    boolean addIncomeGroup(Groupexpense expenseGroup);
    boolean addIncomeGroupFromTemp(int userId, int groupId, java.sql.Date time, double money, String purpose);
}
