package com.marketplace.dao;

import com.marketplace.entity.User;

import java.util.List;

public interface UserDAO {

    User getByLoginPassword(String login, String password) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
    List<User> getUsers() throws Exception;
}
