package com.marketplace.service;

import com.marketplace.domain.User;
import com.marketplace.domain.enums.Role;
import com.marketplace.domain.enums.UserStatus;
import com.marketplace.service.impl.UserServiceImpl;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void get() throws Exception {
        String login = "rel";
        String password = "123";

        User user = userService.get(login, password);

        Assert.assertEquals(user.getLogin(), login);
        Assert.assertEquals(user.getPassword(), password);
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setLogin("sara");
        user.setPassword("123");
        user.setFirstName("Sara");
        user.setLastName("Connor");
        user.setCash(500);
        user.setRating(5000);
        user.setRole(Role.USER);
        user.setStatus(UserStatus.ACTIVE);

        userService.add(user);

        user = userService.get("sara", "123");

        Assert.assertEquals(user.getLogin(), "sara");
        Assert.assertEquals(user.getPassword(), "123");

        user = userService.get("sara", "123");
        userService.delete(user);
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setLogin("sara");
        user.setPassword("123");
        user.setFirstName("Sara");
        user.setLastName("Connor");
        user.setCash(500);
        user.setRating(5000);
        user.setRole(Role.USER);
        user.setStatus(UserStatus.ACTIVE);
        userService.add(user);

        user = userService.get("sara", "123");
        user.setLogin("john");
        user.setPassword("696");
        userService.update(user);

        user = userService.get("john", "696");

        Assert.assertEquals(user.getLogin(), "john");
        Assert.assertEquals(user.getPassword(), "696");

        user = null;
        try {
            user = userService.get("sara", "123");
        } catch (Exception e) {}

        Assert.assertNull(user);

        user = userService.get("john", "696");
        userService.delete(user);
    }

    @Test
    public void delete() throws Exception {
        User user = new User();
        user.setLogin("john");
        user.setPassword("696");
        user.setFirstName("John");
        user.setLastName("Connor");
        user.setCash(500);
        user.setRating(5000);
        user.setRole(Role.USER);
        user.setStatus(UserStatus.ACTIVE);
        userService.add(user);

        user = userService.get("john", "696");
        userService.delete(user);

        user = null;
        try {
            user = userService.get("john", "696");
        } catch (Exception e) {}
        Assert.assertNull(user);
    }
}
