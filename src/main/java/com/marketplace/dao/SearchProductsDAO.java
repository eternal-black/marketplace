package com.marketplace.dao;

import com.marketplace.entity.Product;
import com.marketplace.util.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface SearchProductsDAO {

    List<Product> getProducts(SearchCriteria criteria) throws SQLException;
    List<String> getProductCategories() throws SQLException;

}
