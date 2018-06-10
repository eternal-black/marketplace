package com.marketplace.dao.impl;

import com.marketplace.dao.UserDAO;
import com.marketplace.entity.User;
import com.marketplace.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserDAOImpl implements UserDAO {

    public User get(String login, String password) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            criteria.add(Restrictions.eq("password", password));
            user = (User) criteria.list().get(0);

        } catch (Exception e){
            session.getTransaction().rollback();
            throw new Exception(e);
        }
        session.close();
        return user;
    }

    public void add(User user) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e);
        }
        session.close();
    }

    public void update(User user) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e);
        }
        session.close();
    }

    public void delete(User user) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e);
        }
        session.close();
    }
}
