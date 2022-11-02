/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Inexpense;
import com.ntv.pojo.User;
import com.ntv.repository.InexpenseRepository;
import com.ntv.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class InExpenseRepositoryImpl implements InexpenseRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Inexpense> getExpense(Map<String, String> params, int page, int size) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Inexpense> e = b.createQuery(Inexpense.class);
        Root rI = e.from(Inexpense.class);
        Root rU = e.from(User.class);

        User u = this.userRepository.getUsers(authentication.getName());
        e.select(rI);
//      
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            if (u.getId() != null) {
                Predicate p = b.and(b.equal(rI.get("userId"), u.getId()), b.equal(rI.get("userId"), rU.get("id")));
                predicates.add(p);
            }

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(rI.get("purpose").as(String.class), String.format("%%%s%%", kw));
                predicates.add(p);
            }

            e.where(predicates.toArray(new Predicate[]{}));

        }

        e.orderBy(b.desc(rI.get("id")));
        Query query = session.createQuery(e);

        if (page > 0) {
////            int size = 5;
//            int size = Integer.parseInt(params.get("size"));
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);

        }

        return query.getResultList();
    }

    @Override
    public boolean deleteExpenseBill(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Inexpense p = session.get(Inexpense.class, id);
            session.delete(p);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Inexpense getExpenseById(int expenseId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        return session.get(Inexpense.class, expenseId);
    }

    @Override
    public boolean addExpense(Inexpense e) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
       
       try{
           session.save(e);
           return true;
       }catch(HibernateException ex){
           System.err.println(ex.getMessage());
       }
        
        return false;
    }

    @Override
    public long countExpense() {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        Query q = session.createQuery("SELECT COUNT(*) FROM Inexpense");
        return Long.parseLong(q.getSingleResult().toString());
    }

}
