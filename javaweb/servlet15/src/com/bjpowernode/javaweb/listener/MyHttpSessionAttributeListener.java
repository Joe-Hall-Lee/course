package com.bjpowernode.javaweb.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    // 向 session 域当中存储数据的时候，以下方法被 WEB 服务器调用。
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session data add");
    }

    // 将 session 域当中存储的数据删除的时候，以下方法被 WEB 服务器调用。
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session data remove");
    }

    // session 域当中的某个数据被替换的时候，以下方法被 WEB 服务器调用。
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session data replace");
    }
}
