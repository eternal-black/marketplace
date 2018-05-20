package com.marketplace.dao;

import com.marketplace.entity.Account;
import java.sql.SQLException;

public interface AccountDAO {

    Account get(String login, String password) throws SQLException;
    void add(Account account) throws SQLException;
    void update(Account account) throws SQLException;
    void delete(Account account) throws SQLException;

}
