package com.marketplace.service;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.util.SearchCriteria;

import java.util.List;

public interface ProductService {

    Product getProduct(int id);
    void addProductToOrder(Product product, User user);
    void addProduct(Product product, User user);
    void updateProduct(Product product);
    void deleteProduct(Product product);

    List<Product> getProductsByUser(User user);
    List<String> getProductCategories();
    List<Product> getProducts(SearchCriteria criteria);
}
