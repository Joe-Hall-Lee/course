package com.bjpowernode.javaweb.bean;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/*
 * 普通的 java 类。
 * */
public class User2 {

    private String usercode;
    private String username;
    private String password;

    public User2(String usercode, String username, String password) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
    }

    public User2() {
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
