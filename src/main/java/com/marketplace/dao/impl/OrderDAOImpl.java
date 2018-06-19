package com.marketplace.dao.impl;

import com.marketplace.dao.OrderDAO;
import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.domain.enums.OrderStatus;
import com.marketplace.util.SessionFactoryBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public void update(Order order) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void close(Order order) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        order.setStatus(OrderStatus.INACTIVE);
        try {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void delete(Order order) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public Order get(int id) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        Order order = null;
        try {
            Criteria criteria = session.createCriteria(Order.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", id));
            order = (Order) criteria.list().get(0);
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return order;
    }

    public List<Order> getOrders(Product product) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        List<Order> orders = null;

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", product.getId()));
            product = (Product) criteria.list().get(0);

            orders = product.getOrders();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return orders;
    }

    public List<Order> getOrders(User user) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
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
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
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

    public void update(User user, Order order) throws Exception {}
}
