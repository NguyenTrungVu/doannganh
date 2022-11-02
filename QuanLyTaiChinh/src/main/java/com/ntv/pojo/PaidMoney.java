/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.pojo;

import java.math.BigDecimal;

/**
 *
 * @author inmac
 */
public class PaidMoney {
     private String username;
    private BigDecimal money;

    public PaidMoney() {
    }

    public PaidMoney(String username, BigDecimal money) {
        this.username = username;
        this.money = money;
    }
    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
