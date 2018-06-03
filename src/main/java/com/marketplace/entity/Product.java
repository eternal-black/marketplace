package com.marketplace.entity;

import com.marketplace.entity.enums.ProductStatus;

public class Product {

    private int id;
    private String name;
    private String description;
    private int cost;
    private int discount;
    private int count;
    private int rating;
    private ProductStatus status;
    private User user;

    public Product() {
    }

    public Product(int id, String name, String description, int cost, int discount, int count, int rating, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
        this.count = count;
        this.rating = rating;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", discount=" + discount +
                ", count=" + count +
                ", rating=" + rating +
                ", status=" + status +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
