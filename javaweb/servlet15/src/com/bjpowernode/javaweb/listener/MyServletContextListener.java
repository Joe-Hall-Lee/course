package com.bjpowernode.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    /*
     * 监听器中的方法不需要程序员手动调用，是发生某个特殊事件之后被服务器调用。
     * @param sce
     * */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 现在这个特殊的时刻写代码，你写就是了。它会被服务器自动调用。
        // 这个方法是在 ServletContext 对象被创建的时候调用。
        System.out.println("ServletContext 对象创建了");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 现在这个特殊的时刻写代码，你写就是了。它会被服务器自动调用。
        // 这个方法是在 ServletContext 对象被销毁时候调用。
        System.out.println("ServletContext 对象被销毁了");
    }
}
