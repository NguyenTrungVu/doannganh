/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Belong;
import com.ntv.pojo.Groups;
import com.ntv.repository.BelongRepository;
import com.ntv.service.BelongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class BelongServiceImpl implements BelongService {

    @Autowired
    private BelongRepository belongRepository;

    @Override
    public boolean addBelongTo(Belong belongTo) {
        return this.belongRepository.addBelongTo(belongTo);
    }

    @Override
    public List<Belong> getBelongToByUserId() {
        return this.belongRepository.getBelongToByUserId();
    }

    @Override
    public List<Belong> getUserInGroup(Groups groupId) {
        return this.belongRepository.getUserInGroup(groupId);
    }

    @Override
    public List<Belong> loadGroups() {
        return this.belongRepository.loadGroups();
    }

}
