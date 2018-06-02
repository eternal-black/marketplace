package com.marketplace.entity;

import com.marketplace.entity.enums.Role;
import com.marketplace.entity.enums.UserStatus;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String photo;
    private int rating;
    private int cash;
    private Role role;
    private UserStatus status;

    public User() {
        this.role = Role.USER;
        this.status = UserStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                ", rating=" + rating +
                ", cash=" + cash +
                ", role=" + role +
                ", status=" + status +
                '}';
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getRating() {
        return rating;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCash() {
        return cash;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }

    public UserStatus getStatus() {
        return status;
    }
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
