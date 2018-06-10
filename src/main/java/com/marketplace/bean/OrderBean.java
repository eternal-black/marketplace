package com.marketplace.bean;

import com.marketplace.domain.Order;
import com.marketplace.domain.User;
import com.marketplace.domain.enums.OrderStatus;
import com.marketplace.service.OrderService;
import com.marketplace.service.impl.OrderServiceImpl;
import com.marketplace.util.DBUtil;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean {

    @Getter @Setter
    private OrderService orderService = new OrderServiceImpl();


    // @Getter @Setter private User currentUser = DBUtil.getUser("mel", "123");
    @Getter @Setter private User currentUser = DBUtil.getUser("lil", "123");

    @Getter @Setter private List<Order> orders = orderService.getOrders(currentUser);
    @Getter @Setter private Order order = orderService.getOrder(1);

    public String updateOrder(){
        try {
            orderService.updateOrder(order);
            this.orders = orderService.getOrders(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String closeOrder(){
        try {
            orderService.closeOrder(order);
            this.orders = orderService.getOrders(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteOrder(){
        try {
            orderService.deleteOrder(order);
            this.orders = orderService.getOrders(currentUser);
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
            orderService.add(currentUser, order);

            orders = orderService.getOrders(currentUser);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
