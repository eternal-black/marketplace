package com.marketplace.dao.mock;

import com.marketplace.dao.UserDAO;
import com.marketplace.entity.User;

import java.sql.SQLException;

public class UserDAOMockImpl implements UserDAO{
    public User get(String login, String password) throws SQLException {
        User user = new User();
        user.setLogin("log");
        user.setPassword("pass");
        user.setFirstName("fn");
        user.setLastName("ln");
        return user;
    }

    public void add(User account) throws SQLException {

    }

    public void update(User account) throws SQLException {

    }

    public void delete(User account) throws SQLException {

    }
}
