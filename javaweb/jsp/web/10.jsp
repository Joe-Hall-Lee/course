<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    User user = new User();
    user.setUsername("zhangsan");

    // 存储到 request 域当中。
    request.setAttribute("pingjingnuli", user);

    // 向 request 域当中存储数据。
    request.setAttribute("abc.def", "hello jsp el!!!");
%>

<%-- 使用 EL 表达式取出，并且输出到浏览器 --%>
<%-- 从域中取 user --%>
${pingjingnuli}<br>

<%-- 取 user 的 username --%>
<%----%>
${pingjingnuli.username}<br>

<%-- 取 user 的 username，注意 [] 当中的需要添加双引号--%>
<%-- [] 里面的没有加双引号的话，会将其看做变量。如果带双引号 "username"，则去找 user 对象的 username 属性。 --%>
${pingjingnuli["username"]}<br>

<%-- 将数据取出并输出到浏览器 --%>
${requestScope.abc.def}
之前是空白的。
${requestScope["abc.def"]}