package com.trantan.mvpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trantan.mvpexample.signin.SignInLayout;

public class MainActivity extends AppCompatActivity {
    private SignInLayout mSignInLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        mSignInLayout = new SignInLayout(findViewById(R.id.layout_sign_in));
    }
}
