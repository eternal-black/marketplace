package com.marketplace.domain;

import com.marketplace.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Order {

    @Getter @Setter private int id;
    @Getter @Setter private Date buyingDate;
    @Getter @Setter private Date deliveryDate;
    @Getter @Setter private OrderStatus status;
    @Getter @Setter private User user;
    @Getter @Setter private Product product;

    public Order() {}

    public Order(Date buyingDate, OrderStatus status, User user, Product product) {
        this.buyingDate = buyingDate;
        this.status = status;
        this.user = user;
        this.product = product;
    }
}
