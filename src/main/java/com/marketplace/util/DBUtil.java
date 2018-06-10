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

    // TODO: remove after adding of services layer
    public static User getUser(String login, String password) {
        try {
            return userDAO.get(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> getDeals(User user) {
        try {
            return productDAO.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateOrder(Order order) {
        try {
            orderDAO.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeOrder(Order order) {
        try {
            orderDAO.closeOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrder(Order order) {
        try {
            orderDAO.deleteOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Order getOrder(int id) {
        try {
            return orderDAO.getOrder(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Order> getOrders(User user) {
        try {
            return orderDAO.getOrders(user);
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static List<Product> getProductsByUser(User user) {
        try {
            return productDAO.getProductsByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public static void addProductToOrder(Product product, User user) {
        try {
            productDAO.addProductToOrder(product, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
