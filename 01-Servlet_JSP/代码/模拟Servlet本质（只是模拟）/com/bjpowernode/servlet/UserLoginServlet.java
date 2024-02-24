package com.bjpowernode.servlet;

import javax.servlet.Servlet;

// 充当的角色发生了改变：webapp 开发者
// 只要是我们 webapp 开发者写的 xxxServlet 都要实现 Servlet 接口

public class UserLoginServlet implements Servlet {
    public void service() {
        System.out.println("UserLoginServlet's service...");
    }
}