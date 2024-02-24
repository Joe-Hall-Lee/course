package com.bjpowernode.javaweb.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListner implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session 被创建了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session 被销毁了");
    }
}
