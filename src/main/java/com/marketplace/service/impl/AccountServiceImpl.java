package com.marketplace.service.impl;

import com.marketplace.domain.Account;
import com.marketplace.mapper.AccountMapper;
import com.marketplace.service.AccountService;
import com.marketplace.util.SessionFactoryConfiger;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {

    private SqlSession sqlSession = SessionFactoryConfiger.getSqlSessionFactory().openSession();
    private AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

    public Account getAccount(String login, String password) {
        return accountMapper.getAccount(login, password);
    }

    public void addAccount(Account account) {
        accountMapper.addAccount(account.getLogin(), account.getPassword(), account.getName());
        sqlSession.commit();
    }

    public void updateAccount(Account account) {
        accountMapper.updateAccount(account.getLogin(), account.getPassword(), account.getName(), account.getId());
        sqlSession.commit();
    }

    public void deleteAccount(Account account) {
        accountMapper.deleteAccount(account.getId());
        sqlSession.commit();
    }

}
