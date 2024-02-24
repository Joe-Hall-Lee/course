package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test/session")
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request 和 session 都是服务器端的 java 对象，都在 JVM 当中。
        // request 对象代表了一次请求。（一次请求对应一个 request 对象。两次请求就会对应两个不同的 request 对象。）
        // session 对象代表了一次会话。（一次会话对应一个 session 对象。）
        // 获取 session 对象
        // 从 WEB 服务器当中获取 session 对象，如果 session 对象没有，则新建。
        HttpSession session = request.getSession();

        // 向会话域当中绑定数据。
        // session.setAttribute();
        // 从会话域当中取数据。
        // Object obj = session.getAttribute();

        // 将 session 对象响应到浏览器。
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("会话对象：" + session); // 想看看对象的内存地址。
    }
}
