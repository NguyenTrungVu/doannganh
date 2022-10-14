/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.User;
import com.ntv.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
       try{
           session.save(user);
           return true;
       }catch(HibernateException ex){
           System.err.println(ex.getMessage());
       }
        
        return false;
    }

    @Override
    public User getUsers(String name) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if(!name.isEmpty()){
            Predicate p = b.equal(root.get("username").as(String.class), name.trim());
            q = q.where(p);
        }
        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getUser(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if(username.isEmpty()){
            Predicate p = b.equal(root.get("username").as(String.class), username.trim());
            q = q.where(p);
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from User as u where u.id=:id");
        query.setParameter("id", id);
        return (User) query.getResultList().get(0);
    }

    @Override
    public boolean upDateActiveUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("UPDATE User set active=0 where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate() > 0)
            return true;
        
        return false;
    }

    @Override
    public boolean unlockUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("UPDATE User set active=1 where id=:id");
        query.setParameter("id", id);
        if(query.executeUpdate() > 0)
            return true;
        
        return false;
    }

    @Override
    public List<User> getAllUser() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<String> getUserName(String name) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("select count(*) from User as u where u.username =: name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    

}
