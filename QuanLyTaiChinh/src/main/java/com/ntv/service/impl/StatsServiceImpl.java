/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Groups;
import com.ntv.pojo.PaidMoney;
import com.ntv.pojo.ReturnMoney;
import com.ntv.repository.StatsRepository;
import com.ntv.service.StatsService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> incomeStatsForDay(Date fromDate, Date toDate, int type) {
        return this.statsRepository.incomeStatsForDay(fromDate, toDate, type);
    }

    @Override
    public BigDecimal totalIncomeMonth(int month, int type) {
return this.statsRepository.totalIncomeMonth(month, type);    }

    @Override
    public int countUserIncomeGroup(Groups groupId, int type) {
return this.statsRepository.countUserIncomeGroup(groupId, type);    }

    @Override
    public BigDecimal totalMoneyGroup(Groups groupId) {
return this.statsRepository.totalMoneyGroup(groupId);    }

    @Override
    public int coutMember(Groups groupId) {
return this.statsRepository.coutMember(groupId);    }

    @Override
    public BigDecimal totalMoneyUserIncomeGroup(Groups groupId) {
return this.statsRepository.totalMoneyUserIncomeGroup(groupId) ;   }

    @Override
    public List<ReturnMoney> moneyUserPay(Groups groupId) {
return this.statsRepository.moneyUserPay(groupId);    }

    @Override
    public List<PaidMoney> moneyUserPaid(Groups groupId) {
return this.statsRepository.moneyUserPaid(groupId);    }

}
