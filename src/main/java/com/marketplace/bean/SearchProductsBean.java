package com.marketplace.bean;

import com.marketplace.entity.Product;
import com.marketplace.util.DBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "searchProductsBean")
@SessionScoped
public class SearchProductsBean {

    private String name;
    private int costFrom;
    private int costTo;
    private int discountFrom;
    private int ratingFrom;

    private List<Product> products = DBUtil.getProducts();

    public List<String> getCategories(){
        return Arrays.asList("Music","Drugs","Guns","Whores");
    }

    public String searchByCategory(){
        try {
            products = DBUtil.getProducts();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addToOrder(){
        try {
            DBUtil.addProductToOrder(products.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String searchProductsByCriteria(){
        try {
            products = DBUtil.getProducts();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
