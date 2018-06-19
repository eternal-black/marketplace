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

    @Getter @Setter private List<Product> userProducts;
    @Getter @Setter private List<Product> searchResults;

    @PostConstruct
    void init() {
        productService = new ProductServiceImpl();
        searchCriteria = new SearchCriteria();

        try {
            userProducts = productService.getProductsByUser(sessionBean.getCurrentUser());
            searchResults = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String searchProductsByCriteria(){
        try {
            searchResults = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProductToOrder(){
        try {
            productService.addToOrder(product, sessionBean.getCurrentUser());
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProduct(){
        try {
            productService.add(product, sessionBean.getCurrentUser());
            userProducts = productService.getProductsByUser(sessionBean.getCurrentUser());
            searchResults = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateProduct(){
        try {
            productService.update(product);
            userProducts = productService.getProductsByUser(sessionBean.getCurrentUser());
            searchResults = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteProduct(){
        try {
            productService.delete(product);
            userProducts = productService.getProductsByUser(sessionBean.getCurrentUser());
            searchResults = productService.getProducts(searchCriteria);
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
        try {
            return productService.getCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
