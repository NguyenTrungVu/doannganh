/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.formatters;

import com.ntv.pojo.Category;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author inmac
 */
public class CategoryFormatter implements Formatter<Category> {

    @Override
    public String print(Category t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Category e = new Category();
        e.setId(Integer.parseInt(id));
        return e;
    }

}
