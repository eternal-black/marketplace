package com.marketplace.entity;

import com.marketplace.entity.enums.Role;
import com.marketplace.entity.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class User implements Serializable {

    @Getter @Setter private int id;
    @Getter @Setter private String login;
    @Getter @Setter private String password;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String photo;
    @Getter @Setter private int rating;
    @Getter @Setter private int cash;
    @Getter @Setter private Role role;
    @Getter @Setter private UserStatus status;
    @Getter @Setter private List<Product> products;
    @Getter @Setter private List<Order> orders;

    public User() {
        this.role = Role.USER;
        this.status = UserStatus.ACTIVE;
    }
}
