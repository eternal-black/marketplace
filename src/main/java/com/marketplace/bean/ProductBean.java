package com.marketplace.bean;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.service.ProductService;
import com.marketplace.service.impl.ProductServiceImpl;
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

    @Getter @Setter
    private ProductService productService = new ProductServiceImpl();

    @Getter @Setter private User currentUser = DBUtil.getUser("lil", "123");

    @Getter @Setter private Product product = productService.getProduct(1);
    @Getter @Setter private SearchCriteria searchCriteria = new SearchCriteria();
    @Getter @Setter private List<Product> productsOfCurrentUser = productService.getProductsByUser(this.currentUser);
    @Getter @Setter private List<Product> products = productService.getProducts(searchCriteria);
    @Getter @Setter private List<Product> deals = productService.getDeals(currentUser);

    public List<String> getCategories(){
        return productService.getProductCategories();
    }

    public String getProductsByUser(User user) {
        try {
            products = productService.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String removeFromOrder(){
        try {
            productService.addProductToOrder(product, currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String searchProductsByCriteria(){
        try {
            products = productService.getProducts(searchCriteria);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProductToOrder(){
        try {
            productService.addProductToOrder(product, currentUser);
            // this.orderBean.setOrders(DBUtil.getOrders(currentUser));
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String addProduct(){
        try {
            productService.addProduct(product, this.currentUser);
            this.productsOfCurrentUser = productService.getProductsByUser(this.currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateProduct(){
        try {
            productService.updateProduct(product);
            this.productsOfCurrentUser = productService.getProductsByUser(this.currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteProduct(){
        try {
            productService.deleteProduct(product);
            this.productsOfCurrentUser = productService.getProductsByUser(this.currentUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
