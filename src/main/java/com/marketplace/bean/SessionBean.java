package com.marketplace.bean;

import com.marketplace.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private User user = new User();


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
