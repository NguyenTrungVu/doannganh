/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Groups;
import com.ntv.pojo.Message;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface MessageService {

    public boolean addMessage(Message message);

    public List<Message> loadMessage(Groups groupId);
}
