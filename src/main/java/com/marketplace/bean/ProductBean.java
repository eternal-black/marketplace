package com.marketplace.bean;

import com.marketplace.entity.Product;
import com.marketplace.entity.User;
import com.marketplace.util.DBUtil;
import com.marketplace.util.SearchCriteria;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {

    @Getter @Setter private User currentUser = DBUtil.getUser("lil", "123");
    @Getter @Setter private Product product = DBUtil.getProduct(1);
    @Getter @Setter private SearchCriteria searchCriteria = new SearchCriteria();
    @Getter @Setter private List<Product> productsOfCurrentUser = DBUtil.getProductsByUser(this.currentUser);
    @Getter @Setter private List<Product> products = DBUtil.getProducts(searchCriteria);

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
}
