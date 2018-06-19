package com.marketplace.service;

import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.domain.enums.OrderStatus;
import com.marketplace.service.impl.OrderServiceImpl;
import com.marketplace.service.impl.ProductServiceImpl;
import com.marketplace.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Test
    public void getOrders() throws Exception {
        User user = userService.get("lil", "123");
        List<Order> orders = orderService.getOrders(user);
        Assert.assertEquals(orders.size(), 2);
    }

    @Test
    public void get() throws Exception {
        String name = "mel";
        Order order = orderService.get(1);
        Assert.assertEquals(order.getUser().getLogin(), name);
    }

    @Test
    public void add() throws Exception {
        Product product = productService.get(1);

        Order order = new Order();
        order.setProduct(product);
        order.setDeliveryDate(new Date());
        order.setBuyingDate(new Date());
        order.setStatus(OrderStatus.ACTIVE);

        User user = userService.get("mel", "123");
        orderService.add(user, order);

        List<Order> orders = orderService.getOrders(user);
        Assert.assertEquals(orders.size(), 2);
    }

    @Test
    public void update() throws Exception {
        Order order = orderService.get(17);
        order.setStatus(OrderStatus.INACTIVE);
        orderService.update(order);
        Assert.assertEquals(order.getStatus(), OrderStatus.INACTIVE);
    }

    @Test
    public void close() throws Exception {
        Order order = orderService.get(1);
        orderService.close(order);
        Assert.assertEquals(order.getStatus(), OrderStatus.INACTIVE);
    }

    @Test
    public void delete() throws Exception {
        Order order = orderService.get(21);
        orderService.delete(order);

        order = null;
        try {
            order = orderService.get(21);
        } catch (Exception e) {}
        Assert.assertNull(order);
    }
}