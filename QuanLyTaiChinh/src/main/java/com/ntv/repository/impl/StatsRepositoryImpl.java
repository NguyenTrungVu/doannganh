/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntv.repository.impl;

import com.ntv.pojo.Category;
import com.ntv.pojo.Groups;
import com.ntv.pojo.Inexpense;
import com.ntv.pojo.PaidMoney;
import com.ntv.pojo.ReturnMoney;
import com.ntv.pojo.User;
import com.ntv.repository.BelongRepository;
import com.ntv.repository.CategoryRepository;
import com.ntv.repository.GroupRepository;
import com.ntv.repository.UserRepository;

import com.ntv.service.StatsService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ntv.repository.StatsRepository;

/**
 *
 * @author inmac
 */
@Repository
@Transactional

public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private BelongRepository belongRepository;
    @Autowired
    private StatsService statsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Object[]> incomeStatsForDay(int month, int year, Category type) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);

        e.where(b.equal(rE.get("type"), type),
                b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())),
                b.equal(b.function("year", Integer.class, rE.get("createdDate")), year),
                b.equal(b.function("month", Integer.class, rE.get("createdDate")), month));
        e.multiselect(rE.get("purpose"), rE.get("createdDate"), rE.get("price"));

        e = e.orderBy(b.asc(rE.get("createdDate")));
        Query query = session.createQuery(e);
        return query.getResultList();
    }

    @Override
    public BigDecimal totalIncomeMonth(int month) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);
        Category c = this.categoryRepository.getCateById(1);
        e.where(b.equal(rE.get("type"), c),
                b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")),
                b.equal(b.function("month", Integer.class, rE.get("createdDate")), month),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())));

        e.select(b.sum(rE.get("price").as(BigDecimal.class)));
        Query query = session.createQuery(e);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }

        return BigDecimal.valueOf(0.0);
    }

    @Override
    public int countUserIncomeGroup(Groups groupId, int type) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User  u = this.userRepository.getUsers(authentication.getName());
//        Group g = this.groupRepository.getGroupById(groupId);
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(distinct u.userId) From Groupexpense as u where u.groupId=:groupId and u.type :=type");
        query.setParameter("groupId", groupId);
        query.setParameter("type", type);

        return Math.toIntExact((long) query.getSingleResult());
    }

    @Override
    public BigDecimal totalMoneyGroup(Groups groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT SUM(u.money) FROM Groupexpense as u WHERE u.groupId=:groupId");
        query.setParameter("groupId", groupId);

        Double total = (Double) query.getSingleResult();
        BigDecimal total2 = BigDecimal.valueOf(total);

        if (total2 != null) {
            return total2;
        }

        return BigDecimal.valueOf(0.0);
    }

    @Override
    public int coutMember(Groups groupId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(b.userId) From Belong as b where b.groupId=:groupId");
        query.setParameter("groupId", groupId);

        return Math.toIntExact((long) query.getSingleResult());
    }

    @Override
    public BigDecimal totalMoneyUserIncomeGroup(Groups groupId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepository.getUsers(authentication.getName());
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query query = session.createQuery("SELECT SUM(u.money) FROM UserIncomeGroup as u where u.userId=:userId and u.groupId=:groupId and type:=1");
        query.setParameter("userId", u.getId());
        query.setParameter("groupId", groupId);
        try {
            Double total = (Double) query.getSingleResult();
            BigDecimal total2 = BigDecimal.valueOf(total);

            if (total2 != null) {
                return total2;
            }
        } catch (Exception ex) {
            return BigDecimal.valueOf(0.0);
        }

        return BigDecimal.valueOf(0.0);
    }

    @Override
    public List<ReturnMoney> moneyUserPay(Groups groupId) {
        BigDecimal totalMoneyIncomeGroup = this.totalMoneyGroup(groupId);
        List<ReturnMoney> mustReturns = new ArrayList<>();
        this.belongRepository.getUserInGroup(groupId).forEach(userBelong -> {
            int id = userBelong.getUserId();
            User u = this.userRepository.getUserById(id);
            mustReturns.add(new ReturnMoney(u.getUsername(), this.totalMoneyGroup(groupId).divide(BigDecimal.valueOf(this.coutMember(groupId))).subtract(this.totalMoneyUserIncomeGroup(groupId))));
        });

        return mustReturns;
    }

    @Override
    public List<PaidMoney> moneyUserPaid(Groups groupId) {
        List<PaidMoney> moneyPaids = new ArrayList<>();

        this.belongRepository.getUserInGroup(groupId).forEach(userBelong -> {
            int id = userBelong.getUserId();
            User u = this.userRepository.getUserById(id);
            moneyPaids.add(new PaidMoney(u.getUsername(),
                    this.statsService.totalMoneyGroup(groupId)));

        });

        return moneyPaids;
    }

    @Override
    public List<Object[]> exStats(int month) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);

        e.where(b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())),
                b.equal(b.function("YEAR", Integer.class, rE.get("createdDate")), month));
        e.multiselect(rI.get("id"), rI.get("name"), b.sum(rE.get("price")));
        e.groupBy(rI.get("id"));
        e = e.orderBy(b.asc(rI.get("id")));
        Query query = session.createQuery(e);
        return query.getResultList();
    }

    @Override
    public BigDecimal currentMoney() {
        BigDecimal a = this.currentIn().subtract(this.currentEx());
        return a;
    }
//

    @Override
    public BigDecimal currentIn() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);
        Category c = this.categoryRepository.getCateById(1);
        e.where(b.equal(rE.get("type"), c),
                b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())));

        e.select(b.sum(rE.get("price").as(BigDecimal.class)));
        Query query = session.createQuery(e);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }

        return BigDecimal.valueOf(0.0);
    }
//

    @Override
    public BigDecimal currentEx() {
//       
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);
        Category c = this.categoryRepository.getCateById(2);
        e.where(b.equal(rE.get("type"), c),
                b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())));

        e.select(b.sum(rE.get("price").as(BigDecimal.class)));
        Query query = session.createQuery(e);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }

        return BigDecimal.valueOf(0.0);

    }

    @Override
    public BigDecimal totalExpenseMonth(int month) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> e = b.createQuery(Object[].class);

        Root rE = e.from(Inexpense.class);
        Root rI = e.from(Category.class);
        Root rU = e.from(User.class);
        Category c = this.categoryRepository.getCateById(2);
        e.where(b.equal(rE.get("type"), c),
                b.equal(rE.get("type"), rI.get("id")),
                b.equal(rE.get("userId"), rU.get("id")), 
                b.equal(b.function("month", Integer.class, rE.get("createdDate")), month),
                b.equal(rE.get("userId"), this.userRepository.getUsers(authentication.getName())));

        e.select(b.sum(rE.get("price").as(BigDecimal.class)));
        Query query = session.createQuery(e);
        if (query.getResultList().get(0) != null) {
            return (BigDecimal) query.getResultList().get(0);
        }

        return BigDecimal.valueOf(0.0);
    }

}
