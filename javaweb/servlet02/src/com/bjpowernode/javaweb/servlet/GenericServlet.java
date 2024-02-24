package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/*
 * 编写一个标准通用的 Servlet，起名：GenericServlet
 * 以后所有的 Servlet 类都不要直接实现 Servlet 接口了。
 * 以后所有的 Servlet 类都要继承 GenericServlet 类。
 * GenericServlet 就是一个适配器。
 * */
public abstract class GenericServlet implements Servlet {

    // 成员变量
    private ServletConfig config;

    /*
     * init 方法中的 ServletConfig 对象是小猫咪创建好的。
     * 这个 ServletConfig 对象目前在 init 方法的参数上，属于局部变量。
     * 那么 ServletConfig 对象以后肯定要在 service 方法中使用，怎么才能保证 ServiceConfig 对象在 service 方法中能够使用呢？
     * */
    @Override
    public final void init(ServletConfig config) throws ServletException {
        // System.out.println("servletConfig 对象，小猫咪创建好的：" + config);
        this.config = config;
        // 调用 init() 方法
        this.init();
    }

    /*
     * 这个 init 方法是供子类重写的。
     * */
    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /*
     * 抽象方法，这个方法最常用。所以要求子类必须实现 service 方法。
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     * */
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}