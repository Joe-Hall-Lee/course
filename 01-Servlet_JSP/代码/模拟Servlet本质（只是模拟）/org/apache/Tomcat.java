package org.apache;

import javax.servlet.Servlet;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

// 充当 Tomcat 服务器的开发者
public class Tomcat {
    public static void main(String[] args) throws Exception {
        System.out.println("Tomcat 服务器启动成功，开始接收用户的访问。");

        // 简单地使用 Scanner 来模拟一下用户的请求
        // 用户访问服务器是通过浏览器上的“请求路径”
        // 也就是说用户请求路径不同，后台执行的 Servlet 不同。

        /*
         * /userList UserListServlet
         * /login    UserLoginServlet
         * /bank     BankServlet
         * ...
         * */
        System.out.println("请输入您的访问路径：");
        Scanner s = new Scanner(System.in);

        // 用户的请求路径
        String key = s.nextLine(); // Tomcat 服务器已经获取到了用户的请求路径了。

        // Tomcat 服务器应该通过用户的请求路径找对应的 xxxServlet
        // 请求路径和 xxxServlet 之间的关系应该由谁指定呢？
        // 对于 Tomcat 服务器来说需要解析配置文件
        FileReader reader = new FileReader("web.properties");
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();

        // 通过 key 获取 value
        String className = pro.getProperty(key);
        // 通过反射机制创建对象
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance(); // obj 的类型对于 Tomcat 服务器开发人员来说不知道。

        // 但是 Tomcat 服务器的开发者知道，你写的 xxxServlet 一定实现了 Servlet 接口
        Servlet servlet = (Servlet) obj;
        servlet.service();
    }
}