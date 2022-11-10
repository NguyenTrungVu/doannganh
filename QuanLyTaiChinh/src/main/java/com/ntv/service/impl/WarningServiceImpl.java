/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service.impl;

import com.ntv.pojo.Rule;
import com.ntv.repository.WarningRepository;
import com.ntv.service.WarningService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author inmac
 */
@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningRepository warningRepository;

    @Override
    public boolean addWarning(Rule warning) {
        return this.warningRepository.addWarning(warning);
    }

    @Override
    public List<Rule> getWarnings() {
        return this.warningRepository.getWarnings();
    }

    @Override
    public boolean deleteWarning(String content) {
        return this.warningRepository.deleteWarning(content);
    }

    @Override
    public int countWarning() {
        return this.warningRepository.countWarning();
    }

    @Override
    public List<String> getWarning() {
        return this.warningRepository.getWarning();
    }

}
