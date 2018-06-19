package com.marketplace.dao.impl;

import com.marketplace.dao.ProductDAO;
import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.domain.enums.OrderStatus;
import com.marketplace.util.SessionFactoryBuilder;
import com.marketplace.util.SearchCriteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    public Product getProduct(int id) throws SQLException {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        Product product = null;
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

    public void addProductToOrder(Product product, User user) throws SQLException {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        Order order = new Order();
        try {
            session.beginTransaction();

            user = (User) session.get(User.class, user.getId());
            order.setId(0);
            order.setStatus(OrderStatus.ACTIVE);
            order.setUser(user);
            order.setProduct(product);


            user.getOrders().add(order);
            session.update(user);

            product.getOrders().add(order);
            session.update(product);

            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void addProduct(Product product, User user) throws SQLException {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            user = (User) session.get(User.class, user.getId());
            product.setId(0);
            product.setUser(user);
            user.getProducts().add(product);

            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
    }

    public void updateProduct(Product product) throws SQLException {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
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
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
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

    public List<Product> getProductsByUser(User user) throws Exception {
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        List<Product> products = null;

        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", user.getId()));
            user = (User) criteria.list().get(0);

            products = user.getProducts();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return products;
    }

    public List<String> getProductCategories() throws SQLException {
        List<String> categories = null;
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query= session.createQuery("select name from Category");
            categories = query.getResultList();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return categories;
    }

    public List<Product> getProducts(SearchCriteria searchCriteria) throws SQLException {
        List<Product> products = null;
        Session session = SessionFactoryBuilder.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Product.class);

            if (searchCriteria.getName() != null && !"".equals(searchCriteria.getName())) {
                criteria.add(Restrictions.eq("name", searchCriteria.getName()));
            }
            if (searchCriteria.getCostFrom() != 0) {
                criteria.add(Restrictions.ge("cost", searchCriteria.getCostFrom()));
            }
            if (searchCriteria.getCostTo() != 0) {
                criteria.add(Restrictions.le("cost", searchCriteria.getCostTo()));
            }
            if (searchCriteria.getDiscountFrom() != 0) {
                criteria.add(Restrictions.ge("discount", searchCriteria.getDiscountFrom()));
            }
            if (searchCriteria.getRatingFrom() != 0) {
                criteria.add(Restrictions.ge("rating", searchCriteria.getRatingFrom()));
            }
            products = criteria.list();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.close();
        return products;
    }
}
