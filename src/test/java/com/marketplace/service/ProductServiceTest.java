package com.marketplace.service;

import com.marketplace.domain.Product;
import com.marketplace.domain.User;
import com.marketplace.domain.enums.ProductStatus;
import com.marketplace.service.impl.ProductServiceImpl;
import com.marketplace.service.impl.UserServiceImpl;
import com.marketplace.util.SearchCriteria;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductServiceTest {

    ProductService productService = new ProductServiceImpl();
    UserService userService = new UserServiceImpl();

    @Test
    public void getProduct() throws Exception {
        String name = "osx1";
        Product product = productService.getProduct(1);
        Assert.assertEquals(product.getName(), name);
    }

    @Test
    public void updateProduct() throws Exception {
        String name = "c4";
        Product product = productService.getProduct(2);
        product.setName(name);
        Assert.assertEquals(product.getName(), name);
    }

    @Test
    public void deleteProduct() throws Exception {
        Product product = productService.getProduct(3);
        productService.deleteProduct(product);

        product = null;
        try {
            product = productService.getProduct(3);
        } catch (Exception e) {}
        Assert.assertNull(product);
    }

    @Test
    public void addProduct() throws Exception {
        Product product = new Product();
        product.setName("tnt");
        product.setRating(0);
        product.setCost(0);
        product.setCount(1);
        product.setDescription("exlposive");
        product.setOrders(null);
        product.setStatus(ProductStatus.ACTIVE);

        User user = userService.get("mel", "123");
        productService.addProduct(product, user);

        product = productService.getProduct(4);
        Assert.assertEquals(product.getName(), "tnt");
    }

    @Test
    public void getProducts() throws Exception {
        SearchCriteria searchCriteria = new SearchCriteria();
        List<Product> products = productService.getProducts(searchCriteria);
        Assert.assertEquals(products.size(), 2);
    }

    @Test
    public void getProductsByUser() throws Exception {
        User user = userService.get("lil", "123");
        List<Product> products = productService.getProductsByUser(user);
        Assert.assertEquals(products.size(), 3);
    }

    @Test
    public void getProductCategories() throws Exception {
        List<String> categories = productService.getProductCategories();
        Assert.assertEquals(categories.size(), 2);
    }
}