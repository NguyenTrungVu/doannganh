/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Category;
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
    public List<Object[]> incomeStatsForDay(int month, int year, Category type) {
        return this.statsRepository.incomeStatsForDay(month, year, type);
    }

    @Override
    public BigDecimal totalIncomeMonth(int month) {
        return this.statsRepository.totalIncomeMonth(month);
    }

    @Override
    public int countUserIncomeGroup(Groups groupId, int type) {
        return this.statsRepository.countUserIncomeGroup(groupId, type);
    }

    @Override
    public BigDecimal totalMoneyGroup(Groups groupId) {
        return this.statsRepository.totalMoneyGroup(groupId);
    }

    @Override
    public int coutMember(Groups groupId) {
        return this.statsRepository.coutMember(groupId);
    }

    @Override
    public BigDecimal totalMoneyUserIncomeGroup(Groups groupId) {
        return this.statsRepository.totalMoneyUserIncomeGroup(groupId);
    }

    @Override
    public List<ReturnMoney> moneyUserPay(Groups groupId) {
        return this.statsRepository.moneyUserPay(groupId);
    }

    @Override
    public List<PaidMoney> moneyUserPaid(Groups groupId) {
        return this.statsRepository.moneyUserPaid(groupId);
    }

    @Override
    public List<Object[]> exStats(int month) {
        return this.statsRepository.exStats(month);
    }

    @Override
    public BigDecimal currentMoney() {
        return this.statsRepository.currentMoney();
    }

    @Override
    public BigDecimal totalExpenseMonth(int month) {
        return this.statsRepository.totalExpenseMonth(month);
    }

}
