<%@page contentType="text/html;charset=UTF-8" %>
<%-- 访问 jsp 的时候不生成 session 对象。 --%>
<%@page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>欢迎使用 OA 系统</title>
</head>
<body>
<%-- 前端发送请求路径的时候，如果请求路径是绝对路径，要以“/”开始，加项目名。 --%>
<%-- 以下这样写代码，oa 项目名写死了。这种设计显然是不好的。 --%>
<%-- <a href="/oa/list.jsp">查看部门列表</a> --%>

<%-- 注意空格的问题。 --%>
<%-- <a href="<%=request.getContextPath()%>/list.jsp">查看部门列表</a> --%>

<%-- 执行一个 Servlet，查询数据库，收集数据。 --%>
<%-- <a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a> --%>
<%-- <hr> --%>
<%-- 调用哪个对象的哪个方法，可以动态地获取一个应用的根路径。 --%>
<%-- <%=request.getContextPath()%> --%> <%-- out.print(request.getContextPath()); --%>

<h1>LOGIN PAGE</h1>
<hr>
<%-- 前端页面发送请求的时候，请求路径以“/”开始，带项目名。 --%>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="checkbox" name="f" value="1">十天内免登录<br>
    <input type="submit" value="login">
</form>
</body>
</html>