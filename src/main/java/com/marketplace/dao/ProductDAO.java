package com.marketplace.dao;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.util.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    Product getProduct(int id) throws SQLException;
    void addProduct(Product product, User user) throws SQLException;
    void addProductToOrder(Product product, User user) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(Product product) throws SQLException;

    List<Product> getProducts(SearchCriteria criteria) throws SQLException;
    List<Product> getProductsByUser(User user) throws Exception;
    List<String> getProductCategories() throws SQLException;
}
