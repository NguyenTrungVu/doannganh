/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Belong;
import com.ntv.pojo.Groups;
import com.ntv.pojo.User;
import com.ntv.repository.BelongRepository;
import com.ntv.repository.UserRepository;
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
public class BelongRepositoryImpl implements BelongRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addBelongTo(Belong belongTo) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {

            session.save(belongTo);

            return true;
        } catch (Exception ex) {
            ex.getMessage();
            session.clear();
            session.flush();
        }
        return false;
    }

    @Override
    public List<Belong> getBelongToByUserId() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Query query = session.createQuery("from Belong as b where b.userId=:user");
        query.setParameter("user", u.getId());

        return query.getResultList();
    }

    @Override
    public List<Belong> getUserInGroup(Groups groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Belong as b where b.groupId=:groupId");
        query.setParameter("groupId", groupId);

        return query.getResultList();
    }

    @Override
    public List<Belong> loadGroups() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Query query = session.createQuery("from Belong as b where b.userId=:userId");
        query.setParameter("userId", u.getId());

        return query.getResultList();
    }

}
