package com.marketplace.service.impl;

import com.marketplace.dao.OrderDAO;
import com.marketplace.dao.impl.OrderDAOImpl;
import com.marketplace.domain.Order;
import com.marketplace.domain.User;
import com.marketplace.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    public void update(Order order) throws Exception {
        orderDAO.update(order);
    }

    public void close(Order order) throws Exception {
        orderDAO.close(order);
    }

    public void delete(Order order) throws Exception {
        orderDAO.delete(order);
    }

    public Order get(int id) throws Exception {
        return orderDAO.get(id);
    }

    public List<Order> getOrders(User user) throws Exception {
        return orderDAO.getOrders(user);
    }
}
