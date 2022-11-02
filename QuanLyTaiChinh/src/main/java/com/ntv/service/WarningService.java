/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.service;

import com.ntv.pojo.Rule;
import java.util.List;

/**
 *
 * @author inmac
 */
public interface WarningService {
    boolean addWarning(Rule warning);
    List<Rule> getWarnings();
    boolean deleteWarning(String content);
    int countWarning();
}
