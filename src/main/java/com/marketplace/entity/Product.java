package com.marketplace.entity;

import com.marketplace.entity.enums.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class Product {

    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private int cost;
    @Getter @Setter private int discount;
    @Getter @Setter private int count;
    @Getter @Setter private int rating;
    @Getter @Setter private ProductStatus status;
    @Getter @Setter private User user;
    @Getter @Setter private List<Order> orders;

    public Product() {}
}
