package com.trantan.mvpexample.model.repository;

import com.trantan.mvpexample.model.Account;

public interface AccountDataSource {
    int getAccount(Account account);
    int saveAccount(Account account);
}
