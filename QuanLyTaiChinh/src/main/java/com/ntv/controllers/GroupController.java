/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.controllers;

import com.ntv.pojo.Belong;

import com.ntv.pojo.Groupexpensetemp;
import com.ntv.pojo.Groups;
import com.ntv.pojo.User;
import com.ntv.repository.UserRepository;
import com.ntv.service.BelongService;
import com.ntv.service.GroupExpsenseTepmService;
import com.ntv.service.GroupService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author inmac
 */
@Controller
@ControllerAdvice
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BelongService belongService;
    @Autowired
    private GroupExpsenseTepmService groupExpsenseTepmService;

    @GetMapping("/create-group")
    public String createGroup(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
        model.addAttribute("group", new Groups());
//        model.addAttribute("groups", this.groupService.getGroups());

        return "create-group";
    }

    @PostMapping("/create-group")
    public String createGroup(Model model, HttpSession session, @ModelAttribute(value = "group") @Valid Groups group, BindingResult result) {
        User currentUser = (User) session.getAttribute("currentUser");

        if (!result.hasErrors()) {
            group.setUser(currentUser);
            if (this.groupService.addGroup(group) == true) {
                return "redirect:/";
            }
        }

//        group.setUserId(currentUser);
//        if (this.groupService.addGroup(group) == true) {
//            return "redirect:/";
//        }
        return "create-group";
    }

    @GetMapping("/my-groups")
    public String myGroups(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
        model.addAttribute("groups", this.groupService.getGroupByUserId(currentUser));

        model.addAttribute("users", this.userRepository.getAllUser());
        model.addAttribute("group", this.groupService.getGroupById(2347));

        return "myGroups";
    }

    @GetMapping("/add-member")
    public String addMember(Model model, @RequestParam(required = false) Map<String, String> params, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
        model.addAttribute("users", this.userRepository.getAllUser());
        model.addAttribute("belongTo", new Belong());
        int groupId = Integer.parseInt(params.get("groupId"));
        model.addAttribute("group", this.groupService.getGroupById(groupId));
        return "addMember";
    }

    @PostMapping("/add-member")
    public String addMember(Model model, @ModelAttribute(value = "belong") Belong belong, HttpSession session) {

        String err = "";
        int groupId = belong.getGroupId();
        try {
            this.belongService.addBelongTo(belong);
            return "redirect:/my-groups";
        } catch (Exception ex) {
            err = ex.getMessage();
            model.addAttribute("err", err);
        }

        return "myGroups";
    }

    @GetMapping("/member-of")
    public String memberOf(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
        model.addAttribute("groups", this.belongService.getBelongToByUserId());
        return "memberOf";
    }

    @GetMapping("/add-income-group")
    public String addIncomeGroup(Model model, @RequestParam Map<String, String> params, HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
//        IncomeGroupTemp test = new IncomeGroupTemp();
//            test.setUserId(10);
//            test.setGroupId(10);
//            test.setMoney(30000.0);
//            this.incomeGroupTempService.addIncomeGroupTemp(test);

        int groupId = Integer.parseInt(params.get("groupId"));

        model.addAttribute("group", this.groupService.getGroupById(groupId));

        model.addAttribute("groupExpenseTemp", new Groupexpensetemp());
        return "addIncomeGroup";
    }

    @PostMapping("/add-income-group")
    public String addIncomeGroup(@ModelAttribute(value = "incomeGroupTemp") @Valid Groupexpensetemp groupexpensetemp, BindingResult result, Model model, HttpSession session, @RequestParam(value = "groupId") int groupId) {
        if (!result.hasErrors()) {
            User currentUser = (User) session.getAttribute("currentUser");
            groupexpensetemp.setUserId(currentUser.getId());
            this.groupExpsenseTepmService.addExpenseGroupTemp(groupexpensetemp);
            return "redirect:/member-of";
        }
        if (result.hasErrors()) {
            return "redirect:/add-income-group/?groupId=" + groupId;
        }
//        try{
//            User currentUser = (User) session.getAttribute("currentUser");
//            incomeGroupTemp.setUserId(currentUser.getId());
//            this.incomeGroupTempService.addIncomeGroupTemp(incomeGroupTemp);
//            return "redirect:/member-of";
//        }catch(Exception ex){
//            err = ex.getMessage();
//            model.addAttribute("err", err);
//        }
        return "memberOf";
    }

    @GetMapping("/accept-income")
    public String acceptIncome(Model model, @RequestParam Map<String, String> params, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/require-login";
        }
        int groupId = Integer.parseInt(params.get("groupId"));
        model.addAttribute("groupid", groupId);
        model.addAttribute("incomes", this.groupExpsenseTepmService.getExpenseTemp(groupId));
        return "acceptIncome";
    }

    @GetMapping("/chat-group")
    public String chatGroup(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("belong", this.belongService.loadGroups());
        model.addAttribute("groups", this.groupService.getGroupByUserId(currentUser));
        return "chatGroup";
    }
}
