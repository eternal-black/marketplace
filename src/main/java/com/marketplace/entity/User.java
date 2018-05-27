package com.marketplace.entity;

import com.marketplace.entity.enums.Role;
import com.marketplace.entity.enums.UserStatus;

import java.io.Serializable;

public class User implements Serializable{

    private Integer id;
    private Integer rating;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String photo;
    private Role role;
    private Integer cash;
    private UserStatus status;

    public User() {
    }

    public User(int id, int rating, String login, String password, String firstName,
                String lastName, String photo) {
        this.id = id;
        this.rating = rating;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", rating=" + rating +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Integer getRating() {
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

    public Integer getCash() {
        return cash;
    }
    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public UserStatus getStatus() {
        return status;
    }
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
