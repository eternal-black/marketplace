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
}
