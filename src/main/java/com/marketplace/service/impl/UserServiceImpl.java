package com.marketplace.service.impl;

import com.marketplace.dao.UserDAO;
import com.marketplace.dao.impl.UserDAOImpl;
import com.marketplace.domain.User;
import com.marketplace.service.UserService;
import com.marketplace.util.CommonUtil;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();


    public User get(String login, String password) throws Exception {
        return userDAO.get(login, password);
    }

    public void add(User user) throws Exception {
        user.setPhoto(CommonUtil.generateImageNumber());
        userDAO.add(user);
    }

    public void update(User user) throws Exception {
        userDAO.update(user);
    }

    public void delete(User user) throws Exception {
        userDAO.delete(user);
    }
}