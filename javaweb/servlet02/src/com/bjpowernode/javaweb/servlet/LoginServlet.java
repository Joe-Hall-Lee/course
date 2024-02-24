package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet {


    // 思考一个问题：
    // 有没有一种可能，需要我在 LoginServlet 类中重写 init 方法
    // 当然有可能，于是乎就重写了 init 方法
    // public void init(ServletConfig config) throws ServletException {
    //    System.out.println("重写我自己的规则……");
    // }

    // 父类将原始的 init 方法 final 了，我子类没有办法重写这个 init 方法了。
    // 如果这个时候我还是希望能够重写 init 方法，该怎么办呢？
    @Override
    public void init(){
        System.out.println("LoginServlet's init() method execute!");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("正在处理用户登录请求，请稍后……");

        // 想在 LoginServlet 子类中使用 ServletConfig 对象怎么办？
        ServletConfig config = this.getServletConfig();
        System.out.println("service 方法中是否可以获取到 ServletConfig 对象？" + config);
    }
}
