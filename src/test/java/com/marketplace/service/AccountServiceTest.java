package com.marketplace.service;

import com.marketplace.domain.Account;
import com.marketplace.service.impl.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class AccountServiceTest  {

    private AccountService accountService = new AccountServiceImpl();

    @Test
    public void getAccount() {
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
        String login = "smith";
        String password = "password";
        String name = "agent smith";

        Account account = new Account(login, password, name);
        accountService.addAccount(account);

        account = accountService.getAccount(login, password);
        Assert.assertEquals(account.getLogin(), login);
        Assert.assertEquals(account.getPassword(), password);
        Assert.assertEquals(account.getName(), name);
    }

    @Test
    public void updateAccount() {

    }

    @Test
    public void deleteAccount() {

    }
}
