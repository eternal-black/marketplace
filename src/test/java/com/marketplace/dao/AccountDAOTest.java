package com.marketplace.dao;

import com.marketplace.entity.Account;
import com.marketplace.util.DBUtil;
import org.junit.Test;

public class AccountDAOTest {

    @Test
    public void getAccount() throws Exception {
        String login = "rel";
        String password = "pass";
        Account account = DBUtil.getAccount(login, password);
    }
}
