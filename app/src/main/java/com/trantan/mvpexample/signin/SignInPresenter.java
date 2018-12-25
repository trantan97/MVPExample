package com.trantan.mvpexample.signin;

import android.content.Context;
import android.content.SharedPreferences;

import com.trantan.mvpexample.model.Account;

public class SignInPresenter implements SignInContract.Presenter {
    private static final int SUCCESS = 1;
    private static final int NOT_EXIST = -1;
    private static final int WRONG_PASS = 0;
    private static final String ACCOUNT_SHARED_PREFERENCES = "account";
    private static final String ACCOUNT_NOT_EXIST = "account dose not exist";
    private SignInContract.View mView;
    private Context mContext;

    public SignInPresenter(Context context) {
        mContext = context;
    }

    public void setView(SignInContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignIn(Account account) {
        switch (check(account)) {
            case SUCCESS:
                mView.signInSuccess();
                break;
            case NOT_EXIST:
                mView.signInFailure("Tài khoản không tồn tại");
                break;
            case WRONG_PASS:
                mView.signInFailure("Sai mật khẩu");
                break;
            default:
        }
    }

    private int check(Account account) {
        SharedPreferences sharedPreferences
                = mContext.getSharedPreferences(ACCOUNT_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String password = sharedPreferences.getString(account.getUsername(), ACCOUNT_NOT_EXIST);
        if (password.equals(ACCOUNT_NOT_EXIST)) return NOT_EXIST;
        if (account.getPassword().equals(password)) return SUCCESS;
        else return WRONG_PASS;
    }
}
