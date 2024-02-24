<%@ page contentType="text/html;charset=UTF-8" %>

<%-- 引入核心标签库 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 核心标签库中的 if 标签 --%>
<%-- test 属性是必需的。test 属性支持 EL 表达式。test 属性值只能是 boolean 类型。 --%>
<c:if test="${empty param.username}">
    <h1>用户名不能为空。</h1>
</c:if>

<%-- 没有 else 标签的话，可以搞两个 if 出来。 --%>
<%-- if 标签还有 var 属性，不是必需的。 --%>
<%-- if 标签还有 scope 属性，用来指定 var 的存储域，也不是必需的。 --%>
<%-- scope 有四个值可选：pageContext 域）、request（request 域）、session（session 域）、application（application 域） --%>
<%-- 将 var 中的 v 存储到 request 域。 --%>
<c:if test="${empty param.username}" var="v" scope="request">
    <h1>欢迎你${param.username}。</h1>
</c:if>

<hr>

<%-- 通过 EL 表达式将域当中的--%>
<%-- v 变量中存储的是 test 属性的值。 --%>
${v}