/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;


import com.ntv.pojo.Inexpense;
import com.ntv.service.InexpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author inmac
 */
@Controller
public class InexpenseController {
     @Autowired
    private InexpenseService inexpenseService;

    @GetMapping("/inexpense")
    public String register(Model model){
        model.addAttribute("inexpense",new Inexpense());
        return "add-inexpense";
    }
    
    @PostMapping("/inexpense")
    public String register(Model model, @ModelAttribute(value = "inexpense") Inexpense e ,BindingResult r) {
        if(r.hasErrors()){
            return "add-expense";
        }
        if(this.inexpenseService.addExpense(e) == true){
            model.addAttribute("errMsg", "Them hoa don chi phi thanh cong!!");
            return "redirect:/home";

        }
        return "add-inexpense";
   }
  
}
