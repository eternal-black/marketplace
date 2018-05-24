package com.marketplace.dao.mock;

import com.marketplace.bean.UserBean;
import com.marketplace.dao.UserDAO;
import com.marketplace.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class UserDAOMockImpl implements UserDAO{


    public User get(String login, String password) throws SQLException {
        User user = new User();
        user.setLogin("log");
        user.setPassword("pass");
        user.setFirstName("fn");
        user.setLastName("ln");
        return user;
    }


    public void add(User user) throws SQLException {

        userSet.put(1, user);
        System.out.println("adding user");

    }

    public User getAddingUser(){
        System.out.println("getAddingUser");
        User user = new User();
        user.setLogin(userSet.get(1).getLogin());
        user.setPassword(userSet.get(1).getPassword());
        return user;
    }

    public Map<Integer, User> userSet = new HashMap<Integer, User>();





    public void update(User account) throws SQLException {

    }

    public void delete(User account) throws SQLException {

    }
}