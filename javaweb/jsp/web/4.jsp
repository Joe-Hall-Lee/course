<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String name = "jack";
    // 输出 name 到浏览器
    System.out.println("name = " + name);

    // 可以直接在这个符号中使用 out 对象吗？
    out.write("name = " + name);

    int i = 100;
    out.write("i = " + i);

    out.write("zhangsan");
    out.write("lisi");
    out.write("wangwu");
%>

<br>

zhangsan
lisi
wangwu

<br>

<%=100 + 200%>

<%-- <%=100 + 200;%> --%>

<%--
<%!
    out.write("name2 = " + name);
%>
--%>

<br>
<%-- 输出的是一个固定的，纯字符串。这样输出没有意义。 --%>
<%= "hello world" %>
<br>

<%-- 直接这样写就行了。 --%>
hello world

<%
    int a = 100;
    int b = 200;
    int c = a + b;
%>

<%=c%>

<%
    String username = "jack";
%>

<%="登录成功，欢迎" + username%> <%-- out.print(); --%>
