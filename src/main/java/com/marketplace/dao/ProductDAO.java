package com.marketplace.dao;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.util.SearchCriteria;

import java.util.List;

public interface ProductDAO {

    Product getProduct(int id) throws Exception;
    void addProduct(Product product, User user) throws Exception;
    void addProductToOrder(Product product, User user) throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(Product product) throws Exception;

    List<Product> getProducts(SearchCriteria criteria) throws Exception;
    List<Product> getProductsByUser(User user) throws Exception;
    List<String> getProductCategories() throws Exception;
}
