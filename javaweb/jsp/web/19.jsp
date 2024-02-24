<%@ page import="com.bjpowernode.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- var 用来指定循环中的变量 --%>
<%-- begin 开始 --%>
<%-- end 结束 --%>
<%-- step 步长 --%>
<c:forEach var="i" begin="1" end="10" step="1">
    <%-- 所以这里才会使用 EL 表达式 将其取出，一定是从某个域当中取出的。 --%>
    ${i}<br>
</c:forEach>

<%
    // 创建 List 集合
    List<Student> stuList = new ArrayList();

    // 创建 Student 对象
    Student s1 = new Student("110", "经常");
    Student s2 = new Student("123", "救护车");
    Student s3 = new Student("123", "消防车");

    // 添加到 List 集合中
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);

    // 将 list 集合存储到 request 域当中
    request.setAttribute("stuList", stuList);

%>

<hr>
<%-- var="s" 这个 s 代表的是集合中的每个 Student 对象 --%>
<%-- varStatus="这个属性表示 var 的状态对象，这里是一个 Java 对象，这个 java 对象代表了 var 的状态" --%>
<%-- varStatus="这个名字是随意的" --%>
<%-- varStatus 这个状态对象有 count 属性。可以直接使用。 --%>
<c:forEach items="${stuList}" var="s" varStatus="stuStatus">
    <%-- varStatus 的 count 值从 1 开始，以 1 递增，主要是用于编号/序号。 --%>
    编号：${stuStatus.count}, id: ${s.id}, name: ${s.name} <br>
</c:forEach>

