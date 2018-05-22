package com.marketplace.dao;

import com.marketplace.entity.User;

import java.sql.SQLException;

public interface UserDAO {

    User get(String login, String password) throws SQLException;
    void add(User account) throws SQLException;
    void update(User account) throws SQLException;
    void delete(User account) throws SQLException;
}
