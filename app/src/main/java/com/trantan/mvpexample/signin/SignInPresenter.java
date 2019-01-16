package com.trantan.mvpexample.signin;

import com.trantan.mvpexample.model.Account;
import com.trantan.mvpexample.model.repository.AccountRepository;

public class SignInPresenter implements SignInContract.Presenter {

    private SignInContract.View mView;
    private AccountRepository mAccountRepository;

    public SignInPresenter(AccountRepository accountRepository) {
        mAccountRepository = accountRepository;
    }

    public void setView(SignInContract.View view) {
        mView = view;
    }

    @Override
    public void handleSignIn(Account account) {
        int resCode = mAccountRepository.getAccount(account);
        switch (resCode) {
            case AccountRepository.SUCCESS:
                mView.signInSuccess();
                break;
            case AccountRepository.NOT_EXIST:
                mView.signInFailure("Tài khoản không tồn tại");
                break;
            case AccountRepository.FAILURE:
                mView.signInFailure("Sai mật khẩu");
                break;
            default:
        }
    }

}
