package com.marketplace.service.impl;

import com.marketplace.dao.ProductDAO;
import com.marketplace.dao.impl.ProductDAOImpl;
import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.service.ProductService;
import com.marketplace.util.SearchCriteria;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    public ProductServiceImpl() {
    }

    public List<Product> getDeals(User user) {
        try {
            return productDAO.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByUser(User user) {
        try {
            return productDAO.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getProductCategories() {
        try {
            return productDAO.getProductCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProducts(SearchCriteria criteria) {
        try {
            return productDAO.getProducts(criteria);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProductToOrder(Product product, User user) {
        try {
            productDAO.addProductToOrder(product, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product, User user) {
        try {
            productDAO.addProduct(product, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            productDAO.updateProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Product product) {
        try {
            productDAO.deleteProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product getProduct(int id) {
        try {
            return productDAO.getProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
