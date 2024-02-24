package com.bjpowernode.javaweb.servlet.ConfigTestServlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
 * ServletConfig
 * 1. ServletConfig 是什么？
 *  jakarta.servlet.ServletConfig
 *  显然 ServletConfig 是 Servlet 规范中的一员。
 *  ServletConfig 是一个接口。（jakarta.servlet.Servlet 是一个接口。）
 * 2. 谁去实现了这个接口呢？WEB 服务器实现了
 *  public org.apache.catalina.core.StandardWrapperFacade implements ServletConfig {}
 *  结论：Tomcat 服务器实现了 ServletConfig 接口。
 *  思考：如果把 TomCat 服务器换成 jetty 服务器，输出 ServletCOnfig 对象的时候，还是这个结果吗？
 *  不一定一样，包名、类名可能和 Tomcat 不一样，但是他们都实现了 ServletConfig 这个规范
 * 3. 一个 Servlet 对象中有一个 ServletConfig 对象。（Servlet 和 ServletConfig 对象一对一。）
 *  100 个 Servlet，就应该有 100 个 ServletConfig 对象。
 * 4. ServletConfig 对象是谁创建的？在什么时候创建的？
 *  Tomcat 服务器（WEB 服务器）创建了 ServletConfig 对象。
 *  在创建 Servlet 对象的时候，同时创建 ServletConfig 对象。
 * 5. ServletConfig 接口到底是干啥的？有什么用呢？
 *  Config 是哪个单词的缩写？
 *  Configuration
 *  ServletConfig 对象被翻译为：Servlet 对象的配置信息对象。
 *  一个 Servlet 对象就有一个配置信息对象。
 *  两个 Servlet 对象就有两个配置信息对象。
 *
 *
 * 6. ServletConfig 对象中到底包装了什么信息？
 *  <servlet>
        <servlet-name>configTest2</servlet-name>
            <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet.ConfigTestServlet</servlet-class>
    </servlet>
 *  ServletConfig 对象中包装的信息是：
 *  web.xml 文件中 <servlet></servlet> 标签的配置信息。
 *
 *  Tomcat 小猫咪解析 web.xml 文件，将 web.xml 文件中 <servlet></servlet> 标签中的配置信息自动包装到 ServletConfig 对象中。
 * 7. ServletConfig 接口中有哪些方法？
    <servlet>
        <servlet-name>configTest</servlet-name>
        <servlet-class>com.bjpowernode.javaweb.servlet.ConfigTestServlet.ConfigTestServlet</servlet-class>
        <!-- 这里是可以配置一个 Servlet 对象的初始化信息的。-->
        <init-param>
            <param-name>driver</param-name>
            <param-value>com.mysql.cj.jdbc.Driver</param-value>
        </init-param>
        <init-param>
            <param-name>url</param-name>
            <param-value>jdbc:mysql://localhost:3306/bjpowernode</param-value>
        </init-param>
        <init-param>
            <param-name>user</param-name>
            <param-value>root</param-value>
        </init-param>
        <init-param>
            <param-name>password</param-name>
            <param-value>123456</param-value>
        </init-param>
    </servlet>
    以上 <servlet></servlet> 标签中的 <init-param></init-param> 是初始化参数。这个初始化参数信息会自动被小猫咪封装到 ServletConfig 对象当中。
 * 8. ServletConfig 接口中有 4 个方法：
 *  第 1 个方法：
 *      public String getInitParameter(String name);
 *  第 2 个方法：
 *      public Enumeration<String> getInitParameterNames();
 *  第 3 个方法：
 *      public ServletContext getServletContext();
 *  第 4 个方法：
 *      public String getServletName();
 *
 *  以上的 4 个方法，在自己编写的 Servlet 类当中也可以使用 this 去调用。（这个 Servlet 继承了 GenericServlet）
 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // 获取 ServletConfig 对象
        ServletConfig config = this.getServletConfig();
        // 输出该对象
        // org.apache.catalina.core.StandardWrapperFacade@5327a66d
        out.print("ServletConfig 对象是：" + config.toString());
        out.print("<br>");

        // 获取 <servlet-name><servlet-name>
        String servletname = config.getServletName();
        out.print("<servlet-name>" + servletname + "</servlet-name>");
        out.print("<br>");

        // 通过 ServletConfig 对象的两个方法，可以获取到 web.xml 文件中的初始化参数配置信息。
        // java.util.Enumeration<java.lang.String> getInitParameterNames() 获取所有的初始化参数的 name

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        // 遍历集合
        while (initParameterNames.hasMoreElements()) { // 是否有更多元素
            String parameterName = initParameterNames.nextElement(); // 取元素
            String parameterVal = config.getInitParameter(parameterName); // 通过 name 获取 value
            out.print(parameterName + "=" + parameterVal);
            out.print("<br>");
        }
        // java.lang.String getInitParameter(java.lang.String name) // 通过初始化参数的 name 获取 value
        /*
            String driver =config.getInitParameter("driver");
            out.print(driver);
        */

        // 实际上获取一个 Servlet 对象的初始化参数，可以不用获取 ServletConfig 对象，直接通过 this 也可以。
        Enumeration<String> names = this.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            // 打印到后台
            System.out.println(name + "=" + value);
        }

        // 怎么获取 ServletContext 对象？
        // 第一种方式：通过 ServletConfig 对象获取 ServletConfig 对象。
        ServletContext application = config.getServletContext();
        // 输出
        out.print("<br>" + application); // org.apache.catalina.core.ApplicationContextFacade@22e3fae6
        // 第二种方式，通过 this 也可以获取 ServletContext 对象。
        ServletContext application2 = this.getServletContext();
        out.print("<br>" + application2); // org.apache.catalina.core.ApplicationContextFacade@22e3fae6
    }
}