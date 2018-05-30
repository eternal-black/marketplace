package com.marketplace.dao.impl;

import com.marketplace.dao.SearchProductsDAO;
import com.marketplace.entity.Product;
import com.marketplace.util.HibernateUtil;
import com.marketplace.util.SearchCriteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class SearchProductsDAOImpl implements SearchProductsDAO {

    public List<String> getProductCategories() throws SQLException {
        List<String> categories = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        Session session = HibernateUtil.getSessionFactory().openSession();

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
