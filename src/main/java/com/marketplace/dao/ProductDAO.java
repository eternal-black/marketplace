package com.marketplace.dao;

import com.marketplace.entity.Product;

import java.sql.SQLException;

public interface ProductDAO {

    Product getProduct(int id) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(Product product) throws SQLException;
}
