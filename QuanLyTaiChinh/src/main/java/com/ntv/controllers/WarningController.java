/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.User;
import com.ntv.service.WarningService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author inmac
 */
@Controller
public class WarningController {

    @Autowired
    private WarningService warningService;

    @GetMapping("/warning")
    public String warning(Model model, HttpSession session) {
        model.addAttribute("warnings", this.warningService.getWarnings());
        return "warning";
    }
}
