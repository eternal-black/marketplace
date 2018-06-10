package com.marketplace.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Category {

    @Getter @Setter private Integer id;
    @Getter @Setter private String name;

    public Category() {}
}
