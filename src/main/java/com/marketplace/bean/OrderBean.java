package com.marketplace.bean;

import com.marketplace.domain.Order;
import com.marketplace.domain.enums.OrderStatus;
import com.marketplace.service.OrderService;
import com.marketplace.service.impl.OrderServiceImpl;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "orderBean")
@RequestScoped
public class OrderBean {

    @ManagedProperty(value = "#{sessionBean}")
    @Getter @Setter private SessionBean sessionBean;

    @Getter @Setter private OrderService orderService;

    @Getter @Setter private List<Order> userOrders;

    @PostConstruct
    void init() {
        orderService = new OrderServiceImpl();
        try {
            userOrders = orderService.getOrders(sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String updateOrder(){
        try {
            orderService.update(sessionBean.getOrder());
            userOrders = orderService.getOrders(sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String closeOrder(){
        try {
            orderService.close(sessionBean.getOrder());
            userOrders = orderService.getOrders(sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteOrder(){
        try {
            orderService.delete(sessionBean.getOrder());
            userOrders = orderService.getOrders(sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addOrder(){
        try {
            Order order = new Order();
            order.setStatus(OrderStatus.ACTIVE);
            order.setDeliveryDate(new Date());
            order.setBuyingDate(new Date());

            orderService.add(sessionBean.getCurrentUser(), order);
            userOrders = orderService.getOrders(sessionBean.getCurrentUser());
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
