package com.bjpowernode.javaweb.servlet;

import com.bjpowernode.javaweb.bean.User1;
import com.bjpowernode.javaweb.bean.User2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session/bind")
public class HttpSessionBindingListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 session 对象
        HttpSession session = request.getSession();
        // 准备两个对象，User1 User2
        User1 user1 = new User1("111", "zhangsan", "123");
        User2 user2 = new User2("111", "zhangsan", "123");

        // 将 user1 存储到 session 域
        session.setAttribute("user1", user1);

        // 将 user2 存储到 session 域
        session.setAttribute("user2", user2);
    }
}
