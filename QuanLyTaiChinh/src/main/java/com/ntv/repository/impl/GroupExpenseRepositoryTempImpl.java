/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Groupexpensetemp;
import com.ntv.repository.GroupExpenseRepositoryTemp;
import java.util.List;
import javax.persistence.Query;
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
public class GroupExpenseRepositoryTempImpl implements GroupExpenseRepositoryTemp {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addExpenseGroupTemp(Groupexpensetemp expensetemp) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {

            session.save(expensetemp);

            return true;
        } catch (Exception ex) {
            ex.getMessage();
            session.clear();
        }
        return false;
    }

    @Override
    public List<Groupexpensetemp> getExpenseTemp(int groupid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Groupexpensetemp as i where i.groupId=:groupid");
        query.setParameter("groupid", groupid);

        return query.getResultList();
    }

    @Override
    public boolean deleteExpenseGroupTemp(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("delete from Groupexpensetemp where id=:id");
        query.setParameter("id", id);
        if (query.executeUpdate() != 0) {
            return true;
        }
        return false;
    }

}
