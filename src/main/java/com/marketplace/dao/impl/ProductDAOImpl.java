package com.marketplace.dao.impl;

import com.marketplace.dao.ProductDAO;
import com.marketplace.entity.Product;
import com.marketplace.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO {

    public Product getProduct(int id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = new Product();
        try {
            Criteria criteria = session.createCriteria(Product.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", id));
            product = (Product) criteria.list().get(0);
        } catch (Exception e){
            e.printStackTrace();
        }
        session.close();
        return product;
    }

    public void addProduct(Product product) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void updateProduct(Product product) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void deleteProduct(Product product) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }
}
