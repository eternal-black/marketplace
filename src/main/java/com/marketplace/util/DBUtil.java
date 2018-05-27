package com.marketplace.util;

import com.marketplace.dao.UserDAO;
import com.marketplace.dao.impl.UserDAOImpl;
import com.marketplace.entity.User;

import java.sql.SQLException;

public class DBUtil {

    private static UserDAO userDAO = new UserDAOImpl();

    public static User getUser(String login, String password) throws SQLException {
        return userDAO.getByLoginPassword(login, password);
    }

    public static void addUser(User user) throws Exception {
        try {
            userDAO.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(User user) throws Exception {
        try {
            userDAO.delete(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateUser(User user) throws Exception {
        userDAO.update(user);
    }
}
