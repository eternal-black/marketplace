package com.marketplace.service.impl;

import com.marketplace.dao.OrderDAO;
import com.marketplace.dao.impl.OrderDAOImpl;
import com.marketplace.domain.Order;
import com.marketplace.domain.User;
import com.marketplace.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    public void update(Order order) {
        try {
            orderDAO.update(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(Order order) {
        try {
            orderDAO.close(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Order order) {
        try {
            orderDAO.delete(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order get(int id) {
        try {
            return orderDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getOrders(User user) {
        try {
            return orderDAO.getOrders(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(User user, Order order) {
        try {
            orderDAO.add(user, order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
