package com.marketplace.dao;

import com.marketplace.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface SearchProductsDAO {

    List<Product> getProducts() throws SQLException;
}
