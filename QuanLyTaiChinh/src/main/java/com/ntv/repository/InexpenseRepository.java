/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;


import com.ntv.pojo.Inexpense;
import java.util.List;
import java.util.Map;

/**
 *
 * @author inmac
 */
public interface InexpenseRepository {
    List<Inexpense> getExpense(Map<String, String> params, int page, int size);
    boolean deleteExpenseBill(int id);
    Inexpense getExpenseById(int expenseId);
    boolean addExpense(Inexpense e);
    long countExpense();
    
}
