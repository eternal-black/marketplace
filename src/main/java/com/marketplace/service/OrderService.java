package com.marketplace.service;

import com.marketplace.domain.Order;
import com.marketplace.domain.User;

import java.util.List;

public interface OrderService {

    public void updateOrder(Order order);
    public void closeOrder(Order order);
    public void deleteOrder(Order order);
    public Order getOrder(int id);
    public List<Order> getOrders(User user);
    public void add(User user, Order order);
}
