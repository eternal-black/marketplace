package com.marketplace.service;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.util.SearchCriteria;

import java.util.List;

public interface ProductService {

    public List<Product> getDeals(User user);

    public List<Product> getProductsByUser(User user);

    public List<String> getProductCategories();

    public List<Product> getProducts(SearchCriteria criteria);

    public void addProductToOrder(Product product, User user);

    public void addProduct(Product product, User user);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public Product getProduct(int id);
}
