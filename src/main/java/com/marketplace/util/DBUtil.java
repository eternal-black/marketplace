package com.marketplace.util;

import com.marketplace.dao.*;
import com.marketplace.dao.impl.*;
import com.marketplace.entity.*;
import com.marketplace.entity.enums.OrderStatus;
import com.marketplace.entity.enums.ProductStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtil {

    private static UserDAO userDAO = new UserDAOImpl();
    private static AddressDAO addressDAO = new AddressDAOImpl();
    private static ProductDAO productDAO = new ProductDAOImpl();
    private static OrderDAO orderDAO = new OrderDAOImpl();

    public static List<Product> getDeals(User user) {
        user = new User();
        user.setFirstName("Punto");
        user.setLastName("Switcher");

        Order order = new Order();
        order.setBuyingDate(new Date());
        order.setDeliveryDate(new Date());
        order.setStatus(OrderStatus.ACTIVE);
        order.setUser(user);

        List<Order> orders = new ArrayList<Order>();
        orders.add(order);
        orders.add(order);

        Product product = new Product();
        product.setName("Heroine");
        product.setDescription("hell yea!");
        product.setCount(6);
        product.setRating(6);
        product.setDiscount(6);
        product.setStatus(ProductStatus.ACTIVE);
        product.setUser(user);
        product.setOrders(orders);

        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product);

        return products;
    }

    public static List<Order> getOrders(User user) {
        try {
            user = new User();
            user.setFirstName("Punto");
            user.setLastName("Switcher");

            Product product = new Product();
            product.setName("Heroine");
            product.setDescription("hell yea!");
            product.setCount(6);
            product.setRating(6);
            product.setDiscount(6);
            product.setStatus(ProductStatus.ACTIVE);
            product.setUser(user);

            Order order = new Order();
            order.setProduct(product);
            order.setBuyingDate(new Date());
            order.setDeliveryDate(new Date());
            order.setStatus(OrderStatus.ACTIVE);

            List <Order> orders = new ArrayList<Order>();
            orders.add(order);
            orders.add(order);
            orders.add(order);
            orders.add(order);
            return orders;

//            return orderDAO.getOrders(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void add(User user, Order order) {
        try {
            orderDAO.add(user, order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateOrder(User user, Order order) {}

    public static void deleteOrder(User user, Order order) {}

    public static List<Product> getProductsByUser(User user) {
        try {
            return productDAO.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User getUser(String login, String password) {
        try {
            return userDAO.getByLoginPassword(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(User user) throws Exception {
        userDAO.add(user);
    }

    public static void delete(User user) throws Exception {
        userDAO.delete(user);
    }

    public static void updateUser(User user) throws Exception {
        userDAO.update(user);
    }

    public static List<String> getProductCategories() {
        try {
            return productDAO.getProductCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> getProducts(SearchCriteria criteria) {
        try {
            return productDAO.getProducts(criteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addProductToOrder(Product product) {
    }

    public static void addProduct(Product product, User user) {
        try {
            productDAO.addProduct(product, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
        try {
            productDAO.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(Product product) {
        try {
            productDAO.deleteProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Product getProduct(int id) {
        try {
            return productDAO.getProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAddress(Address address){
        try {
            addressDAO.addAddress(address);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Address getAddressById(int id) throws Exception {
        try {
            return addressDAO.getAddress(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
