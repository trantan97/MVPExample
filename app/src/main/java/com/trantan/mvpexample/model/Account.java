package com.trantan.mvpexample.model;

public class Account {
    private String mUsername;
    private String mPassword;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public Account(String username, String password) {

        mUsername = username;
        mPassword = password;
    }
}
