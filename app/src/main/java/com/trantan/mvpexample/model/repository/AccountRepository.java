package com.trantan.mvpexample.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.trantan.mvpexample.model.Account;

public class AccountRepository implements AccountDataSource {
    public static final int SUCCESS = 1;
    public static final int NOT_EXIST = -1;
    public static final int FAILURE = 0;
    private static final String PREF_ACCOUNT = "account";
    private static final String ACCOUNT_NOT_EXIST = "account dose not exist";
    private static AccountRepository INSTANCE = null;
    private Context mContext;

    private AccountRepository(Context context) {
        mContext = context;
    }

    public static AccountRepository getIntance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new AccountRepository(context);
        return INSTANCE;
    }

    @Override
    public int getAccount(Account account) {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREF_ACCOUNT, Context.MODE_PRIVATE);
        String password = sharedPreferences.getString(account.getUsername(), ACCOUNT_NOT_EXIST);
        if (password.equals(ACCOUNT_NOT_EXIST)) return NOT_EXIST;
        if (account.getPassword().equals(password)) return SUCCESS;
        else return FAILURE;
    }

    @Override
    public int saveAccount(Account account) {
        int resCode = getAccount(account);
        if(resCode != NOT_EXIST) return FAILURE;

        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(PREF_ACCOUNT, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(account.getUsername(),account.getPassword());
        editor.commit();
        return SUCCESS;
    }
}
