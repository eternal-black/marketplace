package com.marketplace.entity;

import java.io.Serializable;

public class Wallet implements Serializable {

    private int id;
    private User user;
    private String value;
    private String currency;

    public Wallet() {
    }

    public Wallet(User user, String value, String currency) {
        this.user = user;
        this.value = value;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", user=" + user +
                ", value='" + value + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
