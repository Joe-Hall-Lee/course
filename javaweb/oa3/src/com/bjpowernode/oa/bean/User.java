package com.bjpowernode.oa.bean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 用户登录了
        // User 类型的对象向 session 中存放了。
        // 获取 ServletContext 对象
        ServletContext application = event.getSession().getServletContext();
        // 获取在线人数。
        Object onlinecount = application.getAttribute("onlinecount");
        if (onlinecount == null) {
            application.setAttribute("onlinecount", 1);
        } else {
            int count = (Integer) onlinecount;

            count++;
            application.setAttribute("onlinecount", count);
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 用户退出了
        // User 类型的对象向 session 中删除了。
        ServletContext application = event.getSession().getServletContext();
        Integer onlinecount = (Integer) application.getAttribute("onlinecount");
        onlinecount--;
        application.setAttribute("onlinecount", onlinecount);
    }

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
