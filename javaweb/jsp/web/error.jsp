<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 在错误页面可以启用 JSP 九大内置对象之：exception --%>
<%-- exception 内置对象就是刚刚发生的异常对象。 --%>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<h1>网络繁忙，稍后再试！</h1>

<%-- 打印异常堆栈信息，输出到后台控制台。exception 是九大内置对象之一。 --%>
<%
    exception.printStackTrace();
%>
</body>
</html>
