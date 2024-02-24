package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {

    // 无参数构造方法
    public AServlet() {
        System.out.println("AServlet 无参数构造方法执行了");
    }

    // 程序员手动提供 Servlet 类的有参数的构造方法，会怎么样？
    // public AServlet(String s) {

    // }

    // init 被翻译为初始化
    // init 方法只执行一次
    // 在 AServlet 对象第一次被创建之后执行。
    // init 方法通常是完成初始化操作的。
    // init 方法在执行的时候 AServlet 对象已经被创建出来了。
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet init method execute!");

    }

    // service 方法：是处理用户请求的核心方法。
    // 只要用户发送一次请求，service 方法必然会执行一次。
    // 发送 100 次请求，service 方法则执行 100 次。
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execute!");
    }

    // destroy 方法也只执行一次。
    // Tomcat 服务器在销毁 AServlet 对象之前会调用一次 destroy 方法
    // destroy 方法在执行的时候，AServlet 对象的内存还没有被销毁，即将被销毁。
    // destroy 方法中可以编写销毁前的准备。
    // 比如说，服务器关闭的时候，AServlet 对象开启了一些资源，这些资源可能是流，可能是数据库连接
    // 那么，关闭服务器的时候，要关闭这些流，关闭这些数据库连接，那么这些关闭资源的代码就可以写到 destroy 方法当中。
    @Override
    public void destroy() {
        System.out.println("AServlet's destroy method execute!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}