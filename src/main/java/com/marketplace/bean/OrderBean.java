package com.marketplace.bean;

import com.marketplace.entity.Order;
import com.marketplace.entity.User;
import com.marketplace.entity.enums.OrderStatus;
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

    // @Getter @Setter private User currentUser = DBUtil.getUser("mel", "123");
    @Getter @Setter private User currentUser = DBUtil.getUser("lil", "123");

    @Getter @Setter private List<Order> orders = DBUtil.getOrders(currentUser);
    @Getter @Setter private Order order = DBUtil.getOrder(1);

    public String updateOrder(){
        try {
            DBUtil.updateOrder(order);
            this.orders = DBUtil.getOrders(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String closeOrder(){
        try {
            DBUtil.closeOrder(order);
            this.orders = DBUtil.getOrders(currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteOrder(){
        try {
            DBUtil.deleteOrder(order);
            this.orders = DBUtil.getOrders(currentUser);
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
            DBUtil.add(currentUser, order);

            orders = DBUtil.getOrders(currentUser);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }
}
