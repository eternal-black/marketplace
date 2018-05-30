package com.marketplace.util;

public class SearchCriteria {
    private String name;
    private String category;
    private int costFrom;
    private int costTo;
    private int discountFrom;
    private int ratingFrom;

    public SearchCriteria() {
    }

    public SearchCriteria(String name, String category, int costFrom, int costTo, int discountFrom, int ratingFrom) {
        this.name = name;
        this.category = category;
        this.costFrom = costFrom;
        this.costTo = costTo;
        this.discountFrom = discountFrom;
        this.ratingFrom = ratingFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCostFrom() {
        return costFrom;
    }

    public void setCostFrom(int costFrom) {
        this.costFrom = costFrom;
    }

    public int getCostTo() {
        return costTo;
    }

    public void setCostTo(int costTo) {
        this.costTo = costTo;
    }

    public int getDiscountFrom() {
        return discountFrom;
    }

    public void setDiscountFrom(int discountFrom) {
        this.discountFrom = discountFrom;
    }

    public int getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(int ratingFrom) {
        this.ratingFrom = ratingFrom;
    }
}
