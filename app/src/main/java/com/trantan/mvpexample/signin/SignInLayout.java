package com.trantan.mvpexample.signin;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trantan.mvpexample.R;
import com.trantan.mvpexample.model.Account;

public class SignInLayout implements View.OnClickListener, SignInContract.View {
    private EditText mTextUserName;
    private EditText mTextPassword;
    private TextView mTextCreatAccount;
    private Button mButtonSingIn;
    private View mLayoutSignIn;
    private SignInPresenter mSignInPresenter;

    public SignInLayout(View view) {
        mLayoutSignIn = view;
        setUpUi();
        setUpEvents();
        initPresenter();
    }

    private void initPresenter() {
        mSignInPresenter = new SignInPresenter(mLayoutSignIn.getContext());
        mSignInPresenter.setView(this);
    }

    private void setUpEvents() {
        mButtonSingIn.setOnClickListener(this);
        mTextCreatAccount.setOnClickListener(this);
    }

    private void setUpUi() {
        mTextUserName = mLayoutSignIn.findViewById(R.id.edit_username);
        mTextPassword = mLayoutSignIn.findViewById(R.id.edit_password);
        mButtonSingIn = mLayoutSignIn.findViewById(R.id.button_sign_in);
        mTextCreatAccount = mLayoutSignIn.findViewById(R.id.text_create_account);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_create_account:
                mLayoutSignIn.setVisibility(View.GONE);
                break;
            case R.id.button_sign_in:
                signIn();
                break;
            default:
        }
    }

    private void signIn() {
        String username = mTextUserName.getText().toString();
        String pass = mTextPassword.getText().toString();
        Account account = new Account(username,pass);
        mSignInPresenter.handleSignIn(account);
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(mLayoutSignIn.getContext()
                , "Đăng nhập thành công"
                , Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(mLayoutSignIn.getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
