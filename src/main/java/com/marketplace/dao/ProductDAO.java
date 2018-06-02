package com.marketplace.dao;

import com.marketplace.entity.Product;
import com.marketplace.util.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {

    Product getProduct(int id) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(Product product) throws SQLException;
    List<Product> getProducts(SearchCriteria criteria) throws SQLException;
    List<String> getProductCategories() throws SQLException;
}
