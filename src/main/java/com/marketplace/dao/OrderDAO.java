package com.marketplace.dao;

import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;

import java.util.List;

public interface OrderDAO {

    List<Order> getOrders(User user) throws Exception;
    List<Order> getOrders(Product product) throws Exception;

    Order get(int id) throws Exception;
    void update(Order order) throws Exception;
    void delete(Order order) throws Exception;
    void close(Order order) throws Exception;
}
