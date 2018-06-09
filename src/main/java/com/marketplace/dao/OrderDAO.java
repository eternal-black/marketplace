package com.marketplace.dao;

import com.marketplace.entity.Order;
import com.marketplace.entity.Product;
import com.marketplace.entity.User;

import java.util.List;

public interface OrderDAO {

    Order getOrder(int id) throws Exception;
    List<Order> getOrders(User user) throws Exception;
    List<Order> getOrders(Product product) throws Exception;
    void add(User user, Order order) throws Exception;
    void updateOrder(Order order) throws Exception;
    void deleteOrder(Order order) throws Exception;
    void closeOrder(Order order) throws Exception;
}
