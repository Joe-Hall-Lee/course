package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    // 通过无参数构造方法创建对象。
    // public HelloServlet() {}

    // 没有提供 init 方法，那么必然执行父类 HttpServlet 的 init 方法。
    // HttpServlet 类中没有 init 方法，会继续执行 GenericServlet 类中的 init 方法。

    // 没有提供 Service 方法，那么必然执行父类 HttpServlet 的 service 方法。

    /*
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>hello servlet</h1>");
    }
    */

    // 当前端发送的请求是 get 请求的时候，我这里重写 doGet 方法。
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>doGet</h1>");
    }

    // 当前端发送的请求是 post 请求的时候，我这里重写 doPost 方法。
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>doPost</h1>");
    }
}
