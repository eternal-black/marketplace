package com.marketplace.bean;

import com.marketplace.domain.Order;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    @Getter @Setter private User currentUser = new User();

    @Getter @Setter private Product product;
    @Getter @Setter private Order order;

}