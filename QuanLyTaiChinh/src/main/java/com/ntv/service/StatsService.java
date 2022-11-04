/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Category;
import com.ntv.pojo.Groups;
import com.ntv.pojo.PaidMoney;
import com.ntv.pojo.ReturnMoney;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface StatsService {
     List<Object[]> exStats(int month);
    List<Object[]> incomeStatsForDay( int month, int year, Category type);
      BigDecimal currentMoney ();
    BigDecimal totalIncomeMonth(int month,  Category type);
   
    int countUserIncomeGroup(Groups groupId, int type);
    BigDecimal totalMoneyGroup(Groups groupId);
    int coutMember(Groups groupId);
    BigDecimal totalMoneyUserIncomeGroup( Groups groupId);
    List<ReturnMoney> moneyUserPay(Groups groupId);
    List<PaidMoney> moneyUserPaid(Groups groupId);
}
