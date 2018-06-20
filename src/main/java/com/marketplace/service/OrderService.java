package com.marketplace.service;

import com.marketplace.domain.Order;
import com.marketplace.domain.User;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(User user) throws Exception;

    Order get(int id) throws Exception;
    void add(User user, Order order) throws Exception;
    void update(Order order) throws Exception;
    void close(Order order) throws Exception;
    void delete(Order order) throws Exception;
}