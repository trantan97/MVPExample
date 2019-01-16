package com.trantan.mvpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.trantan.mvpexample.signin.SignInLayout;
import com.trantan.mvpexample.signup.SignUpLayout;

public class MainActivity extends AppCompatActivity {
    private SignInLayout mSignInLayout;
    private SignUpLayout mSignUpLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        View signInView = findViewById(R.id.layout_sign_in);
        View signUpView = findViewById(R.id.layout_sign_up);

        mSignInLayout = new SignInLayout(signInView);
        mSignUpLayout = new SignUpLayout(signUpView);

        mSignUpLayout.setLayoutSignIn(signInView);
        mSignInLayout.setLayoutSignUp(signUpView);
    }
}
