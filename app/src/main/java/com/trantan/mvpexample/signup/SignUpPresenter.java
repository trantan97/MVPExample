package com.trantan.mvpexample.signup;

import com.trantan.mvpexample.model.Account;
import com.trantan.mvpexample.model.repository.AccountRepository;

public class SignUpPresenter implements SignUpContract.Presenter {
    private SignUpContract.View mView;
    private AccountRepository mAccountRepository;

    public SignUpPresenter(AccountRepository accountRepository) {
        mAccountRepository = accountRepository;
    }

    public void setView(SignUpContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignUp(Account account) {
        if (account.getUsername().equals("") || account.getPassword().equals("")) {
            mView.signUpFailure("Không được để trống");
            return;
        }
        int resCode = mAccountRepository.saveAccount(account);
        switch (resCode) {
            case AccountRepository.SUCCESS:
                mView.signUpSuccess();
                break;
            case AccountRepository.FAILURE:
                mView.signUpFailure("Tài khoản đã tồn tại");
                break;
            default:
        }
    }
}
