package com.marketplace.util;

import com.marketplace.dao.AccountDAO;
import com.marketplace.dao.impl.AccountDAOImpl;
import com.marketplace.entity.Account;

import java.sql.SQLException;

public class DBUtil {

    public static AccountDAO accountDAO = new AccountDAOImpl();

    public static Account getAccount(String login, String password) throws Exception {
        try {
            Account account = accountDAO.get(login, password);
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateAccount(Account account) throws Exception {
        try {
            accountDAO.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addAccount(Account user) throws Exception {
        try {
            accountDAO.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAccount(Account user) throws Exception {
        try {
            accountDAO.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
