package com.marketplace.dao;

import com.marketplace.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    User getByLoginPassword(String login, String password) throws SQLException;
    void add(User user) throws SQLException;
    void update(User account) throws SQLException;
    void delete(User user) throws SQLException;
    List<User> getUsers() throws SQLException;
}
