package com.marketplace.bean;

import com.marketplace.entity.Product;
import com.marketplace.entity.User;
import com.marketplace.util.DBUtil;
import com.marketplace.util.SearchCriteria;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {

    private User currentUser = DBUtil.getUser("lil", "123");

    private Product product = DBUtil.getProduct(1);
    private SearchCriteria searchCriteria = new SearchCriteria();

    private List<Product> productsOfCurrentUser = DBUtil.getProductsByUser(this.currentUser);
    private List<Product> products = DBUtil.getProducts(searchCriteria);

    public List<String> getCategories(){
        return DBUtil.getProductCategories();
    }

    public String getProductsByUser(User user) {
        try {
            products = DBUtil.getProductsByUser(user);
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

    public String addProductToOrder(){
        try {
            DBUtil.addProductToOrder(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProduct(){
        try {
            DBUtil.addProduct(product, this.currentUser);
            this.productsOfCurrentUser = DBUtil.getProductsByUser(this.currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateProduct(){
        try {
            DBUtil.updateProduct(product);
            this.productsOfCurrentUser = DBUtil.getProductsByUser(this.currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteProduct(){
        try {
            DBUtil.deleteProduct(product);
            this.productsOfCurrentUser = DBUtil.getProductsByUser(this.currentUser);
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<Product> getProductsOfCurrentUser() {
        return productsOfCurrentUser;
    }

    public void setProductsOfCurrentUser(List<Product> productsOfCurrentUser) {
        this.productsOfCurrentUser = productsOfCurrentUser;
    }
}
