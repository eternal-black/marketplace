package com.marketplace.entity;

import com.marketplace.entity.enums.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public Product() {}
}
