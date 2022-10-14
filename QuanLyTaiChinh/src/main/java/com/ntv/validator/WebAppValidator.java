/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.validator;

import com.ntv.pojo.User;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 *
 * @author inmac
 */
//@Component
public class WebAppValidator implements Validator{
    
    private Set<Validator> springValidators = new HashSet<>();
    @Autowired
    private javax.validation.Validator beanVaidator;   


    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);      
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> constrainviolations = this.beanVaidator.validate(o);
        for(ConstraintViolation<Object> obj: constrainviolations ){
            errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
        }
        for(Validator v: this.springValidators){
            v.validate(o, errors);
        }
    }

    /**
     * @param springValidator the springValidator to set
     */
    public void setSpringValidator(Set<Validator> springValidator) {
        this.springValidators = springValidator;
    }
    
}
