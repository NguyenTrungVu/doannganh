/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Inexpense;
import com.ntv.repository.InexpenseRepository;
import com.ntv.repository.UserRepository;
import com.ntv.service.InexpenseService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class InexpenseServiceImpl implements InexpenseService {

    @Autowired
    private InexpenseRepository inexpenseRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
   
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Inexpense> getExpense(Map<String, String> params, int page, int size) {
        return this.inexpenseRepository.getExpense(params, page, size);
    }

    @Override
    public boolean deleteExpenseBill(int id) {
        return this.inexpenseRepository.deleteExpenseBill(id);
    }

    @Override
    public Inexpense getExpenseById(int expenseId) {
        return this.inexpenseRepository.getExpenseById(expenseId);
    }

    @Override
    public boolean addExpense(Inexpense e) {
        long cost = e.getPrice();
        e.setPrice(cost);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        e.setUserId(this.userRepository.getUsers(authentication.getName()).getId());
        e.setCreatedDate(new Date());
        String type = e.getType();
        e.setType(type);

        return this.inexpenseRepository.addExpense(e);
    }

    @Override
    public long countExpense() {
        return this.inexpenseRepository.countExpense();
    }

}
