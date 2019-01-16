package com.trantan.mvpexample.signup;

import com.trantan.mvpexample.model.Account;

public interface SignUpContract {
    interface View{
        void signUpSuccess();
        void signUpFailure(String err);
    }
    interface Presenter{
        void handleSignUp(Account account);
    }
}
