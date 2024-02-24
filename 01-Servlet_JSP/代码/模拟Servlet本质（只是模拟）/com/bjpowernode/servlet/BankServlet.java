package com.bjpowernode.servlet;

import javax.servlet.Servlet;

public class BankServlet implements Servlet {
    public void service() {
        System.out.println("BankServlet's service...");
    }
}