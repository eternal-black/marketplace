package com.marketplace.bean;

import com.marketplace.entity.Product;
import com.marketplace.util.DBUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean {

    private Product product = DBUtil.getProduct(1);

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
            DBUtil.addProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String updateProduct(){
        try {
            DBUtil.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public String deleteProduct(){
        try {
            DBUtil.deleteProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
