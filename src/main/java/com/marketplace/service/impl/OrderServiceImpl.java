package com.marketplace.service.impl;

import com.marketplace.dao.OrderDAO;
import com.marketplace.dao.impl.OrderDAOImpl;
import com.marketplace.entity.Order;
import com.marketplace.entity.User;
import com.marketplace.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    public void updateOrder(Order order) {
        try {
            orderDAO.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeOrder(Order order) {
        try {
            orderDAO.closeOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order) {
        try {
            orderDAO.deleteOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order getOrder(int id) {
        try {
            return orderDAO.getOrder(id);
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
