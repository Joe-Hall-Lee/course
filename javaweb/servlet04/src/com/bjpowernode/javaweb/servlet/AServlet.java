package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
 * ServletContext
 * 1. ServletContext 是什么？
 *  ServletContext 是接口，是 Servlet 规范中的一员。
 * 2. ServletContext 是谁实现的？
 *  Tomcat 服务器（WEB 服务器）实现了 ServletContent 接口。
 *  public class org.apache.catalina.core.ApplicationContextFacade implements ServletContext {}
 * 3. ServletContext 对象是谁创建的？在什么时候创建的？
 *  ServletContext 对象在 WEB 服务器启动的时候创建。
 *  ServletContext 对象是 WEB 服务器创建的。
 *  对于一个 webapp 来说，ServletContext 对象只有一个。
 *  ServletContext 对象在服务器关闭的时候销毁。
 * 4. ServletContext 怎么理解？
 *  context 是什么意思？
 *      Servlet 对象的环境对象。（Servlet 对象的上下文对象。）
 *  ServletContent 对象其实对应的就是整个 web.xml 文件。
 *  50 个学生，每个学生都是一个 Servlet，这 50 个学生都在同一个教室当中。那么这个教室就相当于 ServletContext 对象、
 *  放在 ServletContent 对象当中的数据，所有 Servlet 一定是共享的。
 *  比如：一个教室中的空调是所有学生共享的，一个教室中的语文老师是所有学生共享的。
 *  Tomcat 是一个容器，一个容器当中可以放多个 webapp，一个 webapp 对应一个 ServletContext 对象。
 * */
public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取 ServletContext 对象
        ServletContext application = this.getServletContext();
        out.print("ServletContext 对象是：" + application + "<br>");

        // 获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name + "=" + value + "<br>");
        }

        // 获取 context path（获取应用上下文的根）
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br>");

        // 获取文件的绝对路径
        // String realPath = application.getRealPath("/index.html"); // 可以
        // String realPath = application.getRealPath("index.html"); // 不加“/”也可以
        // out.print(realPath + "<br>");

        // F:\CS\Back-end\course\01-Servlet\代码\javaweb\out\artifacts\servlet04_war_exploded\common\common.html
        String realPath = application.getRealPath("/common/common.html");
        out.print(realPath + "<br>");

        // 准备数据
        User user = new User("jack", "123");
        // 向 ServletContext 应用域中存储数据
        application.setAttribute("userObj", user);
        // 取出来
        // Object userObj = application.getAttribute("userObj");
        // 输出到浏览器
        // out.print(userObj + "<br>");
    }
}
