/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Category;
import com.ntv.repository.CategoryRepository;
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
@Transactional
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        return q.getResultList();
    }

    @Override
    public Category getCateById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("from Category as u where u.id=:id");
        query.setParameter("id", id);
        return (Category) query.getResultList().get(0);
    }

}
