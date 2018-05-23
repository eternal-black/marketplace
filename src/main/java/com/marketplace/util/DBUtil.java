package com.marketplace.util;

import com.marketplace.dao.UserDAO;
import com.marketplace.dao.mock.UserDAOMockImpl;
import com.marketplace.entity.User;

import java.sql.SQLException;

public class DBUtil {

    private static UserDAO userDAO = new UserDAOMockImpl();

    public static User getUser(String login, String password) throws Exception {
        try {
            return userDAO.get(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(User user) throws Exception {
        try {
            userDAO.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getAddingUser(){
        try {
            return userDAO.getAddingUser();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
