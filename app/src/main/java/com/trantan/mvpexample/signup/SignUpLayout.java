package com.trantan.mvpexample.signup;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.trantan.mvpexample.R;
import com.trantan.mvpexample.model.Account;
import com.trantan.mvpexample.model.repository.AccountRepository;

public class SignUpLayout implements SignUpContract.View, View.OnClickListener {
    private EditText mTextUserName;
    private EditText mTextPassword;
    private Button mButtonSingUp;
    private TextView mTextSignIn;
    private View mLayoutSignUp;
    private View mLayoutSignIn;
    private SignUpPresenter mSignUpPresenter;

    public SignUpLayout(View layoutSignUp) {
        mLayoutSignUp = layoutSignUp;
        initUi();
        initPresenter();
    }

    public void setLayoutSignIn(View layoutSignIn) {
        mLayoutSignIn = layoutSignIn;
    }

    private void initPresenter() {
        mSignUpPresenter
                = new SignUpPresenter(AccountRepository.getIntance(mLayoutSignUp.getContext()));
        mSignUpPresenter.setView(this);
    }

    private void initUi() {
        mTextUserName = mLayoutSignUp.findViewById(R.id.edit_username);
        mTextPassword = mLayoutSignUp.findViewById(R.id.edit_password);
        mButtonSingUp = mLayoutSignUp.findViewById(R.id.button_sign_up);
        mTextSignIn = mLayoutSignUp.findViewById(R.id.text_sign_in);
        mTextSignIn.setOnClickListener(this);
        mButtonSingUp.setOnClickListener(this);
    }

    @Override
    public void signUpSuccess() {
        Toast.makeText(mLayoutSignUp.getContext()
                , "Đăng ký thành công"
                , Toast.LENGTH_SHORT).show();
        mLayoutSignUp.setVisibility(View.GONE);
        mLayoutSignIn.setVisibility(View.VISIBLE);
    }

    @Override
    public void signUpFailure(String err) {
        Toast.makeText(mLayoutSignUp.getContext()
                , err
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sign_up:
                signUp();
                break;
            case R.id.text_sign_in:
                mLayoutSignUp.setVisibility(View.GONE);
                mLayoutSignIn.setVisibility(View.VISIBLE);
                break;
            default:
        }
    }

    private void signUp() {
        String username = mTextUserName.getText().toString();
        String pass = mTextPassword.getText().toString();
        Account account = new Account(username, pass);
        mSignUpPresenter.handleSignUp(account);
    }
}
