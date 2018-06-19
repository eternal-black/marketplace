package com.marketplace.bean;

import com.marketplace.domain.Product;
import com.marketplace.service.ProductService;
import com.marketplace.service.impl.ProductServiceImpl;
import com.marketplace.util.SearchCriteria;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {

    @ManagedProperty(value = "#{sessionBean}")
    @Getter @Setter private SessionBean sessionBean;

    @Getter @Setter private ProductService productService;
    @Getter @Setter private SearchCriteria searchCriteria;

    @Getter @Setter private Product product;

    @Getter @Setter private List<Product> productsOfCurrentUser;
    @Getter @Setter private List<Product> productsOfSearch;
    @Getter @Setter private List<Product> deals;

    @PostConstruct
    void init() {
        productService = new ProductServiceImpl();
        searchCriteria = new SearchCriteria();

        productsOfCurrentUser = productService.getProductsByUser(sessionBean.getCurrentUser());
        productsOfSearch = productService.getProducts(searchCriteria);
        deals = productService.getDeals(sessionBean.getCurrentUser());
    }

    public String searchProductsByCriteria(){
        try {
            productsOfSearch = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProductToOrder(){
        try {
            productService.addProductToOrder(product, sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProduct(){
        try {
            productService.addProduct(product, sessionBean.getCurrentUser());
            productsOfCurrentUser = productService.getProductsByUser(sessionBean.getCurrentUser());
            productsOfSearch = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateProduct(){
        try {
            productService.updateProduct(product);
            productsOfCurrentUser = productService.getProductsByUser(sessionBean.getCurrentUser());
            productsOfSearch = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteProduct(){
        try {
            productService.deleteProduct(product);
            productsOfCurrentUser = productService.getProductsByUser(sessionBean.getCurrentUser());
            productsOfSearch = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String removeFromOrder(){
        return null;
    }

    public List<String> getCategories(){
        return productService.getProductCategories();
    }
}
