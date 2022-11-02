/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Groups;
import com.ntv.pojo.User;
import com.ntv.repository.GroupRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author inmac
 */
@Transactional
@Repository
public class GroupRepositoryImpl  implements GroupRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addGroup(Groups group) {
           Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try{
            
            session.save(group);
            
            return true;
        }catch(Exception ex){
            ex.getMessage();
            session.clear();
            session.save(group);
            session.flush();
        }
        return false;
    }

    @Override
    public List<Groups> getGroups() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

//        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Groups> q = b.createQuery(Groups.class);
        Root root = q.from(Groups.class);
        q.select(root);
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Groups> getGroupByUserId(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Group as g where g.userId=:user");
        query.setParameter("user", user);
        return query.getResultList();
    }

    @Override
    public Groups getGroupById(int groupId) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Group as g where g.id=:groupId");
        query.setParameter("groupId",groupId );
        
        return (Groups) query.getResultList().get(0);
    }
    
}
