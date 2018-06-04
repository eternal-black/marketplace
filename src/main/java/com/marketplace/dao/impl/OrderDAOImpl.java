package com.marketplace.dao.impl;

import com.marketplace.dao.OrderDAO;
import com.marketplace.entity.Order;
import com.marketplace.entity.User;
import com.marketplace.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public List<Order> getOrders(User user) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Order> orders = null;

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", user.getId()));
            user = (User) criteria.list().get(0);

            orders = user.getOrders();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return orders;
    }

    public void add(User user, Order order) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            user = (User) session.get(User.class, user.getId());
            order.setUser(user);
            user.getOrders().add(order);

            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void updateOrder(User user, Order order) throws Exception {}

    public void deleteOrder(User user, Order order) throws Exception {}
}
