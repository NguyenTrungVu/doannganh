/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Groupexpensetemp;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface GroupExpenseRepositoryTemp {
    boolean addExpenseGroupTemp(Groupexpensetemp expensetemp);
    List<Groupexpensetemp> getExpenseTemp(int groupid);
    boolean deleteExpenseGroupTemp(int id);
}
