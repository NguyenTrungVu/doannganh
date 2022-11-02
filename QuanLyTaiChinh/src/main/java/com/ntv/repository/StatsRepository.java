/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Groups;
import com.ntv.pojo.PaidMoney;
import com.ntv.pojo.ReturnMoney;
import com.ntv.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface StatsRepository {
    List<Object[]> incomeStatsForDay( Date fromDate, Date toDate, int type);
    
    BigDecimal totalIncomeMonth(int month,  int type);
   
    int countUserIncomeGroup(Groups groupId, int type);
    BigDecimal totalMoneyGroup(Groups groupId);
    int coutMember(Groups groupId);
    BigDecimal totalMoneyUserIncomeGroup( Groups groupId);
    List<ReturnMoney> moneyUserPay(Groups groupId);
    List<PaidMoney> moneyUserPaid(Groups groupId);
}
