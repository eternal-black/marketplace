package com.marketplace.service;

import com.marketplace.domain.Account;
import com.marketplace.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class AccountServiceTest  {

    private AccountService accountService = new AccountServiceImpl();

    @Test
    public void getAccount() {

        /* Get and check */
        String login = "rel";
        String password = "pass";
        String name = "rel mayer";

        Account account = accountService.getAccount(login, password);
        Assert.assertEquals(account.getLogin(), login);
        Assert.assertEquals(account.getPassword(), password);
        Assert.assertEquals(account.getName(), name);
    }

    @Test
    public void addAccount() {

        /* Add */
        String login = "smith";
        String password = "password";
        String name = "agent smith";

        Account account = new Account(login, password, name);
        accountService.addAccount(account);

        /* Get and check */
        account = accountService.getAccount(login, password);
        Assert.assertEquals(account.getLogin(), login);
        Assert.assertEquals(account.getPassword(), password);
        Assert.assertEquals(account.getName(), name);

        /* Delete */
        account = accountService.getAccount(login, password);
        accountService.deleteAccount(account);
    }

    @Test
    public void updateAccount() {

        /* Add */
        String login = "smith";
        String password = "password";
        String name = "agent smith";

        Account account = new Account(login, password, name);
        accountService.addAccount(account);

        /* Get and update */
        account = accountService.getAccount(login, password);

        String newLogin = "vincent";
        String newPassword = "123";
        String newName = "vincent lo";

        account.setLogin(newLogin);
        account.setName(newName);
        account.setPassword(newPassword);

        accountService.updateAccount(account);

        /* Get and check */
        account = accountService.getAccount(newLogin, newPassword);

        Assert.assertEquals(account.getLogin(), newLogin);
        Assert.assertEquals(account.getPassword(), newPassword);
        Assert.assertEquals(account.getName(), newName);

        /* Delete */
        accountService.deleteAccount(account);
    }

    @Test
    public void deleteAccount() {

        /* Add */
        String login = "smoth";
        String password = "password";
        String name = "agent smoth";

        Account account = new Account(login, password, name);
        accountService.addAccount(account);

        /* Get, delete and check */
        account = accountService.getAccount(login, password);

        accountService.deleteAccount(account);

        account = accountService.getAccount(login, password);
        Assert.assertNull(account);
    }
}
