package com.marketplace.dao;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.util.SearchCriteria;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts(SearchCriteria criteria) throws Exception;
    List<Product> getProductsByUser(User user) throws Exception;

    Product get(int id) throws Exception;
    void add(Product product, User user) throws Exception;
    void update(Product product) throws Exception;
    void delete(Product product) throws Exception;

    void addToOrder(Product product, User user) throws Exception;
    List<String> getCategories() throws Exception;
}
