package com.marketplace.entity;

public class User {

    private int id;
    private int rating;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String photo;
    private Role userRole;
    private Contact userContact;

    public User() {
    }

    public User(int rating, String login, String password, String firstName, String lastName, String photo, Role userRole, Contact userContact) {
        this.rating = rating;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.userRole = userRole;
        this.userContact = userContact;
    }

    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public Contact getUserContact() {
        return userContact;
    }

    public void setUserContact(Contact userContact) {
        this.userContact = userContact;
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
                ", userRole=" + userRole +
                ", userContact=" + userContact +
                '}';
    }
}
