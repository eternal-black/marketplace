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

    public List<Product> getProductsByUser(User user) throws Exception {
        return productDAO.getProductsByUser(user);
    }

    public List<String> getCategories() throws Exception {
        return productDAO.getCategories();
    }

    public List<Product> getProducts(SearchCriteria criteria) throws Exception {
        return productDAO.getProducts(criteria);
    }

    public void addToOrder(Product product, User user) throws Exception {
        productDAO.addToOrder(product, user);
    }

    public void add(Product product, User user) throws Exception {
        productDAO.add(product, user);
    }

    public void update(Product product) throws Exception {
        productDAO.update(product);
    }

    public void delete(Product product) throws Exception {
        productDAO.delete(product);
    }

    public Product get(int id) throws Exception {
        return productDAO.get(id);
    }
}
