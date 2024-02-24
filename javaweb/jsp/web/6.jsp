<%@ page contentType="text/html;charset=UTF-8" %>
<%
    // 向 request 作用域当中存储 username 为 zhangsan
    request.setAttribute("username", "zhangsan");
    request.setAttribute("obj", new Object());
%>

<%-- 将 request 域当中的数据取出来，并且还要输出到浏览器，使用 java 代码怎么办？ --%>
<%=request.getAttribute("username")%>
<br>
<%=request.getAttribute("obj")%>
<br>

<br>

<%-- 使用 EL 表达式呢？ --%>
${username}
<br>
${obj}