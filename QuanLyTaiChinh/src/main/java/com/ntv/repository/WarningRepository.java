/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository;

import com.ntv.pojo.Rule;
import com.ntv.pojo.User;
import java.util.List;


/**
 *
 * @author inmac
 */
public interface WarningRepository {
    boolean addWarning(Rule warning);
    List<Rule> getWarnings();
     List<String> getWarning();
    boolean deleteWarning(String content);
    int countWarning();
}
