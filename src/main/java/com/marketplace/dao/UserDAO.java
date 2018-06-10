package com.marketplace.dao;

import com.marketplace.domain.User;

public interface UserDAO {

    User get(String login, String password) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}
