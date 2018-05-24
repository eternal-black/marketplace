package com.marketplace.entity;

public class Product {

    private int id;
    private String name;
    private Double price;
    private int count;
    private Category category;
    private User seller;
    private String describe;
    private int discount;
    private String manufacturer;
    private boolean exist;

    public Product() {
    }

    public Product(int id, String name, Double price, int count, Category category, User seller,
                   String describe, int discount, String manufacturer, boolean exist) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
        this.seller = seller;
        this.describe = describe;
        this.discount = discount;
        this.manufacturer = manufacturer;
        this.exist = exist;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
