package com.marketplace.dao.impl;

import com.marketplace.dao.SearchProductsDAO;
import com.marketplace.entity.Product;
import com.marketplace.entity.enums.ProductStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductsDAOMockImpl implements SearchProductsDAO {
    public List<Product> getProducts() throws SQLException {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Heroine", "Live fast", 100, 0, 999, 100, ProductStatus.active));
        products.add(new Product(1, "Heroine", "Live fast", 100, 0, 999, 100, ProductStatus.active));
        products.add(new Product(1, "Heroine", "Live fast", 100, 0, 999, 100, ProductStatus.active));
        products.add(new Product(1, "Heroine", "Live fast", 100, 0, 999, 100, ProductStatus.active));

        return products;
    }
}
