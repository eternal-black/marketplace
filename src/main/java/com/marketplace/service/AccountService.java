package com.marketplace.service;

import com.marketplace.domain.Account;

public interface AccountService {

    Account getAccount(String login, String password);
    void addAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);

}