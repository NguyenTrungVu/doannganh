/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Groups;
import com.ntv.pojo.User;
import com.ntv.repository.GroupRepository;
import com.ntv.repository.UserRepository;
import com.ntv.service.GroupService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class GroupServiceImpl implements GroupService{
    
    @Autowired
    private GroupRepository groupRepository;
     @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addGroup(Groups group) {
        String name = group.getGroupname();
        group.setGroupname(name);
        String purpose = group.getPurpose();
        group.setPurpose(purpose);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        group.setUserid(u.getId());
        return this.groupRepository.addGroup(group);
    }

    @Override
    public List<Groups> getGroups() {
        return this.groupRepository.getGroups();
    }

    @Override
    public List<Groups> getGroupByUserId(User user) {
        return this.groupRepository.getGroupByUserId(user);
    }

    @Override
    public Groups getGroupById(int groupId) {
        return this.groupRepository.getGroupById(groupId);
    }
    
}
