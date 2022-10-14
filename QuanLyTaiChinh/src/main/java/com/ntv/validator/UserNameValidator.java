/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.validator;

import com.ntv.pojo.User;
import com.ntv.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author inmac
 */
@Component
public class UserNameValidator implements Validator{

    @Autowired
    private UserService userService;
    
    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

   
    
//    public int userameCheck(String name){
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Query query = session.createQuery("select count(*) from User as u where u.username =: name");
//        query.setParameter("name", name);
//        return Integer.parseInt(query.getResultList().toString()); 
//    }
    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
        List<String> list = this.userService.getUserName(u.getUsername());
        if(!list.isEmpty()){
            errors.rejectValue("username", "user.username.simErr");
        }
         
    }
    
}
