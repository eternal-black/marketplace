package com.marketplace.dao;

import com.marketplace.entity.User;
import com.marketplace.util.DBUtil;

import org.junit.Assert;
import org.junit.Test;

public class UserDAOTest {

    @Test
    public void getAccount() throws Exception {
        String login = "log";
        String password = "pass";
        User user = DBUtil.getUser(login, password);
        Assert.assertEquals(user.getLogin(), login);
        Assert.assertEquals(user.getPassword(), password);
    }
}
