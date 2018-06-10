package com.marketplace.dao;

import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;

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
