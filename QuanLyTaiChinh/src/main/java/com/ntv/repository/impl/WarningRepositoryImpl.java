/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Rule;
import com.ntv.pojo.User;
import com.ntv.repository.UserRepository;
import com.ntv.repository.WarningRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Repository
@Transactional

public class WarningRepositoryImpl implements WarningRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addWarning(Rule warning) {
        Session s = this.sessionFactory.getObject().getCurrentSession();

        try {

            s.save(warning);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
            s.clear();
        }
        return false;
    }

    @Override
    public List<Rule> getWarnings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("from Rule as w where w.userId=:user");
        query.setParameter("user", u);
        return query.getResultList();
    }

    @Override
    public boolean deleteWarning(String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("delete from Rule where userId=:user AND content=:content");
        query.setParameter("user", u);
        query.setParameter("content", content);

        int row = query.executeUpdate();
        if (row != 0) {
            return true;
        }

        return false;
    }

    @Override
    public int countWarning() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("SELECT count(*) FROM Rule where userId=:userId");
        query.setParameter("userId", u);
        return Math.toIntExact((long) query.getSingleResult());
    }

    @Override
    public List<String> getWarning() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query query = s.createQuery("select content from Rule as w where w.userId=:user");
        query.setParameter("user", u);
        return query.getResultList();
    }

}
