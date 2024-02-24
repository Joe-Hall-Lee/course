package com.bjpowernode.servlet;

import javax.servlet.Servlet;

public class UserListServlet implements Servlet {
    public void service() {
        System.out.println("UserListServlet's service...");
    }
}