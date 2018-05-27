package com.marketplace.dao.impl;

import com.marketplace.dao.AddressDAO;
import com.marketplace.entity.Address;
import com.marketplace.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {

    public void addAddress(Address address) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Address getAddress(int id) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Address address = null;
        try {
            Criteria criteria = session.createCriteria(Address.class);
            criteria.setMaxResults(1);
            criteria.add(Restrictions.eq("id", id));
            address = (Address) criteria.list().get(0);
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return address;
    }

    public List<String> getCountry() throws SQLException {
        return null;
    }

    public List<String> getCity(String country) throws SQLException {
        return null;
    }

    public List<String> getStreet(String city) throws SQLException {
        return null;
    }

    public List<String> getHome(String street) throws SQLException {
        return null;
    }
}
