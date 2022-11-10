/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.Rule;
import com.ntv.pojo.User;
import com.ntv.service.CategoryService;
import com.ntv.service.InexpenseService;
import com.ntv.service.StatsService;
import com.ntv.service.WarningService;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author inmac
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private InexpenseService inexpenseService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StatsService statsService;
    @Autowired
    private WarningService warningService;

    @ModelAttribute
    public void commonAtt(Model model, HttpSession session) {
        model.addAttribute("category", this.categoryService.getCategories());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));

    }

    @RequestMapping(value = "/home")
    public String home(Model model, @RequestParam Map<String, String> params, HttpSession session) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        int size = Integer.parseInt(params.getOrDefault("size", "5"));
        model.addAttribute("expenses", this.inexpenseService.getExpense(params, page, size));
        model.addAttribute("expenseCounter", this.inexpenseService.countExpense());
        model.addAttribute("currentMoney", this.statsService.currentMoney());

        User currentUser = (User) session.getAttribute("currentUser");
        try {
            model.addAttribute("countWarning", this.warningService.countWarning());

        } catch (Exception ex) {
            model.addAttribute("countWarning", 0);
        }
        if (currentUser != null) {
            Date d = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.applyPattern("MM");
            String format = simpleDateFormat.format(d);
           
            BigDecimal totalIncome = this.statsService.totalIncomeMonth(Integer.parseInt(format));
//            double totalIncome2 = totalIncome.doubleValue();

            BigDecimal totalSpending = this.statsService.totalExpenseMonth(Integer.parseInt(format));
//            double totalSpending2 = totalSpending.doubleValue();
//            System.out.println(totalIncome2);
//            System.out.println(totalSpending2);
           if(totalIncome.compareTo(totalSpending) < 0){
               String str = format;
               String str2 = String.format("Tong thu cua ban trong thang %s thap so voi muc chi tieu", str);
               
               Rule  warning = new Rule();
               warning.setContent(str2);
               warning.setUserId(currentUser);
               this.warningService.addWarning(warning);
           }
           else{
                String str = format;
               String str2 = String.format("Tong thu cua ban trong thang %s thap so voi muc chi tieu", str);
               this.warningService.deleteWarning(str2);
           }
            BigDecimal cr = BigDecimal.valueOf(5000000);
            double cr2 = cr.doubleValue();
            BigDecimal cr1 = this.statsService.currentMoney();
            double cr3 = cr1.doubleValue();
            
            if (cr3 < cr2) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                String str1 = currencyFormat.format(cr);

                String str = String.format("So tien hien tai cua ban con duoi %s ", str1);

                Rule warning = new Rule();

                warning.setContent(str);
                warning.setUserId(currentUser);
                this.warningService.addWarning(warning);

            } else {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                String str1 = currencyFormat.format(cr);
                String str = String.format("So tien hien tai cua ban con duoi %s ", str1);
                this.warningService.deleteWarning(str);

            }

        }

        return "home";
    }
}
