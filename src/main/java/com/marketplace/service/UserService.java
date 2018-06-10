package com.marketplace.service;

import com.marketplace.entity.User;

public interface UserService {

    User get(String login, String password) throws Exception;
    void add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user) throws Exception;
}