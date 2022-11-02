/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Groups;
import com.ntv.pojo.User;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface GroupRepository {
    boolean addGroup(Groups group);
    List<Groups> getGroups();
    List<Groups> getGroupByUserId(User user);
    Groups getGroupById(int groupId);
}
