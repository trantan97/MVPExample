package com.trantan.mvpexample.signin;

import com.trantan.mvpexample.model.Account;

public interface SignInContract {
    interface View {
        void signInSuccess();

        void signInFailure(String error);
    }

    interface Presenter {
        void handleSignIn(Account account);
    }
}
