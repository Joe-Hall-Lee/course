<%@ page import="com.bjpowernode.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 引入标签库，这里引入的是 jstl 的核心标签库。 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 格式化标签库，专门负责格式化操作的。 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%-- sql 标签库 --%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

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

<%-- 需求：将 List 集合中的元素遍历。输出学生信息到浏览器。 --%>
<%-- 使用 java 代码--%>
<%
    // 从域中获取 List 集合
    List<Student> stus = (List<Student>) request.getAttribute("stuList");
    // 编写 for 循环遍历 list 集合
    for (Student stu : stus) {
%>
id: <%=stu.getId()%>, name: <%=stu.getName()%><br>
<%
    }
%>

<br>

<%-- 使用 core 标签中 forEach 标签。对 List 集合进行遍历 --%>
<c:forEach items="${stuList}" var="s">
    id: ${s.id}, name: ${s.name} <br>
</c:forEach>