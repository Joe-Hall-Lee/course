<%@ page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("username", "zhangsan");
%>

<br>

<%-- 取出数据并且输出到浏览器 --%>
<%=request.getAttribute("username")%>
采用 EL 表达式：${username}
<br>

<%=request.getAttribute("usernam")%>

<%-- EL 表达式主要任务是做页面展示，要求最终页面展示上是友好的。 --%>
<%-- 所以 EL 表达式对 null 进行了处理，如果是 null，则在浏览器上显示空白。 --%>
采用 EL 表达式：${usernam}

<hr>
<%-- EL 表达式表面上是这种写法，实际上运行的时候，还是要翻译生成 java 代码的。 --%>
${usernma} 这个 EL 表达式等同于这一段 java 代码：<%=request.getAttribute("usernam") == null ? "" : request.getAttribute("usernam")%>