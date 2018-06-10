package com.marketplace.util;

import com.marketplace.dao.*;
import com.marketplace.dao.impl.*;
import com.marketplace.entity.*;

import java.sql.SQLException;
import java.util.List;

public class DBUtil {

    private static UserDAO userDAO = new UserDAOImpl();
    private static AddressDAO addressDAO = new AddressDAOImpl();
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
