package com.marketplace.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Address {

    @Getter @Setter private Integer id;
    @Getter @Setter private String country;
    @Getter @Setter private String city;
    @Getter @Setter private String street;
    @Getter @Setter private String home;
    @Getter @Setter private String apartment;

    public Address() {}
}
