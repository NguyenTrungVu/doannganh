/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.User;

import java.util.List;

/**
 *
 * @author inmac
 */
public interface UserRepository {
    List<User> getUser(String username);
    boolean addUser(User user);
    User getUsers(String name);
    User getUserById(int id);
    boolean upDateActiveUser(int id);
    boolean unlockUser(int id);
    List<User> getAllUser();
    List<String> getUserName(String name);
    
}
