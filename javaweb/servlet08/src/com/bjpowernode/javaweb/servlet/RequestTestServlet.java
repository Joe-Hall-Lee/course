package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/*
username=zhangsan&userpwd=123&interest=s&interest=d
Map<String, String[]>
key              value
---------------------------
"username"       {"zhangsan"}
"userpwd"        {"123"}
"interest"       {"s", "d"}

总结一下；request 接口中四个非常重要的方法。
Map<String, String[]> parameterMap = request.getParameterMap();
Enumeratno<String> names = request.getParameterNames();
String[] values = request.getParameterValues("name");
String value = request.getParameter("name");
*/

public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // org.apache.catalina.connector.RequestFacade@3bd4922b
        out.print(request);

        // 获取客户端的 IP 地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户的 IP 地址：" + remoteAddr);
        */

        // 这个方法使用比较多。（动态获取应用的根路径。）
        String contextPath = request.getContextPath();
        System.out.println("应用的根路径：" + contextPath);

        // 获取请求方式
        String method = request.getMethod();
        System.out.println(method); // GET

        // 获取请求的 URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI); // /aaa/testRequest

        // 获取 servlet 路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这是 POST 请求。
        String username = request.getParameter("username");
        // 输出这个用户提交的用户名
        System.out.println(username);
    }
    */

    /*
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 面向接口编程：HttpservletRequest 接口。
        // 获取前端提交的数据
        // 前端会提交什么数据呢？
        // username=zhangsan&userpwd=123&interest=s&interest=d
        // 以上的数据会被小猫咪封装到 request 对象中。

        // 获取参数 Map 集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 遍历 Map 集合（获取 Map 集合中所有的 key，遍历）
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            // System.out.println(key);
            // 通过 key 获取 value
            String[] values = parameterMap.get(key);
                *//*
                username=[Ljava.lang.String;@4065e17c
                userpwd=[Ljava.lang.String;@5677714
                interest=[Ljava.lang.String;@230c405e
                 *//*
            // System.out.println(key + "=" + values);

            // 遍历一维数组
            System.out.print(key + "=");

            for (String value : values) {
                System.out.print(value + ",");
            }
            // 换行
            System.out.println();
        }

        // 直接通过 getParameterNames() 这个方法，可以直接获取这个 Map 集合的所有 key
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name);
        }

        // 直接通过 name 获取 value 这个一维数组。
        String[] usernames = request.getParameterValues("username");
        String[] userpwds = request.getParameterValues("userpwd");
        String[] interests = request.getParameterValues("interest");

        // 遍历一维数组
        for (String username : usernames) {
            System.out.println(usernames);
        }

        for (String userpwd : userpwds) {
            System.out.println(userpwd);
        }

        for (String interest : interests) {
            System.out.println(interest);
        }

        // 通过 name 获取 value 这个一维数组的第一个元素
        // 这个方法使用最多，因为这个一维数组中一般只有一个元素。
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        // String interest = request.getPareameter("interest");

        // 既然是 checkbox，调用方法：request.getParameterValues("interest")
        String[] interests2 = request.getParameterValues("interest");

        // 获取的都是一维数组当中的第一个元素。
        System.out.println(username);
        System.out.println(userpwd);
        // System.out.println(interest);

        for (String interest : interests2) {
            System.out.println(interest);
        }
    }
    */
}
