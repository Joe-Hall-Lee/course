package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;


public class AServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 获取系统当前时间
        Date nowTime = new Date();

        // 向 request 域中绑定数据。
        request.setAttribute("sysTime", nowTime);

        // 从 request 域当中取出绑定的数据。
        // Object obj = request.getAttribute("sysTime");

        // 输出到浏览器
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("request 域当中获取的系统当前时间 = " + obj);
        */

        // 通过 AServlet 能不能跳转到 BServlet
        // 让 AServlet 和 BServlet 放到一次请求当中。
        // 可以的。使用 Servlet 当中请求转发机制。

        // 这样做可以吗？
        // 在 AServlet 当中 new 一个 BServlet 对象，然后调用 BServlet 对象的 doGet 方法，把 request 对象传过去。
        // 这个代码虽然可以实现功能，但是 Servlet 对象不能自己由程序员来 new，自己 new 的 Servlet 对象生命周期不受 Tomcat 服务器的管理。
        /*
        BServlet bServlet = new BServlet();
        bServlet.doGet(request, response);
        */
        // 使用 Servlet当中的转发机制。
        // 执行了 AServlet 之后，跳转到 BServlet。（这个资源跳转可以使用转发机制来完成。）
        // 怎么转发？代码怎么写？
        // 第一步：获取请求转发器对象
        // 相当于把“/b”这个路径包装到请求转发器中，实际上是把下一个跳转的资源的路径告知给 Tomcat 服务器了。
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/b");

        // 第二步：调用请求转发器 RequestDispatcher 的 forward 方法，进行转发。
        // 转发的时候：这两个参数很重要，request 和 response 都是要传递给下一个资源的。
        // dispatcher.forward(request, response);

        // 一行代码搞定转发。
        // request.getRequestDispatcher("/b").forward(request, response);

        // 转发到一个 Servlet，也可以转发到一个 HTML，只要是 WEB容器当中的合法资源即可。
        request.getRequestDispatcher("/test.html").forward(request, response);
    }
}