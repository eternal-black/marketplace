package com.marketplace.dao;

import com.marketplace.entity.Order;
import com.marketplace.entity.User;

import java.util.List;

public interface OrderDAO {

    List<Order> getOrders(User user) throws Exception;
    void add(User user, Order order) throws Exception;
    void updateOrder(User user, Order order) throws Exception;
    void deleteOrder(User user, Order order) throws Exception;
}
