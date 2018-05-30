package com.marketplace.bean;

import com.marketplace.entity.Product;
import com.marketplace.util.DBUtil;
import com.marketplace.util.SearchCriteria;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "searchProductsBean")
@SessionScoped
public class SearchProductsBean {

    private SearchCriteria searchCriteria = new SearchCriteria();
    private List<Product> products = DBUtil.getProducts(searchCriteria);

    public List<String> getCategories(){
        return DBUtil.getProductCategories();
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

    public String removeFromOrder(){
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
            products = DBUtil.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
