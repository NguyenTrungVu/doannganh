/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;


import com.ntv.pojo.Category;
import com.ntv.pojo.Inexpense;
import com.ntv.service.StatsService;

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
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(value = "type", required = false) Category type ,
            @RequestParam(value = "year", defaultValue = "2022") int year ,
            @RequestParam(value = "month", defaultValue = "0") int month,
            @RequestParam(value = "Year", defaultValue = "2022") int Year
            ) {
        model.addAttribute("exStats", this.statsService.exStats(Year));
        model.addAttribute("timeStats", this.statsService.incomeStatsForDay(month, year, type));
        
        return "inexpense-stats";
    }
}
