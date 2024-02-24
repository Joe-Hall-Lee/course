<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="jakarta.servlet.http.HttpServletRequest" %>

<%--
    // JSP 有九大内置对象
    // pageContext, request, session, application, response, out, config, page, exception
    // 其中四个域对象，其中最小的域是 pageContext
    // pageContext 翻译为：页面上下文。通过 pageContext 可以获取？

--%>

<%-- 从以下代码来看，pageContext.getRequest() 方法是没用的。这是获取 request 对象，而 JSP 中自带了内置对象 request，直接用 request 内置对象就行了。 --%>
<%=pageContext.getRequest()%>
<br>
<%=request%>

<%--
在 EL 表达式当中没有 request 这个隐式对象。
requestScope 这个只代表“请求范围”。不等同于 request 对象。
在 EL 表达式当中有一个隐式的对象：pageContext
EL 表达式的 pageContext 和 JSP 中的九大内置对象 pageContext 是同一个对象。
--%>
<%-- <%=pageContext.getRequest()%> --%>

<%=((HttpServletRequest) pageContext.getRequest()).getContextPath()%>
这段 java 代码对应的 EL 表达式：
使用 EL 表达式来获取应用的根路径：
${pageContext.request.contextPath}
