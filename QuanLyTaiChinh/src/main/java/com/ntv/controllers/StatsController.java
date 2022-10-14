/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;


import com.ntv.pojo.Inexpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author inmac
 */
@Controller
public class StatsController {
//    @Autowired
//    private ExStatsService exStatsService;
//    
//    @GetMapping("/stats")
//    public String stats(Model model,
//            @RequestParam(value = "item", required = false) Inexpense item ,
//            @RequestParam(value = "year", defaultValue = "2022") int year ,
//            @RequestParam(value = "month", defaultValue = "0") int month ) {
//        model.addAttribute("exStats", this.exStatsService.exStats());
//        model.addAttribute("expenseStats", this.exStatsService.expenseStats(item, month,  year));
//        return "expense-stats";
//    }
}
