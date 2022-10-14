/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.User;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author inmac
 */
public interface UserService extends UserDetailsService {
    List<User> getUser(String username);
    boolean addUser(User user);
    User getUsers(String name);
    User getUserById(int id);
    boolean upDateActiveUser(int id);
    boolean unlockUser(int id);
    List<User> getAllUser();
    List<String> getUserName(String name);
}
