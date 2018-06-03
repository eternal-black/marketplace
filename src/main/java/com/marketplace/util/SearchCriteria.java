package com.marketplace.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SearchCriteria {

    @Getter @Setter private String name;
    @Getter @Setter private String category;
    @Getter @Setter private int costFrom;
    @Getter @Setter private int costTo;
    @Getter @Setter private int discountFrom;
    @Getter @Setter private int ratingFrom;

    public SearchCriteria() {}
}
