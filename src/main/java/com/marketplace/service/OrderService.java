package com.marketplace.service;

import com.marketplace.domain.Order;
import com.marketplace.domain.User;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(User user);

    Order get(int id);
    void add(User user, Order order);
    void update(Order order);
    void close(Order order);
    void delete(Order order);
}
