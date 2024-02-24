<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page import="com.bjpowernode.javaweb.jsp.bean.Address" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    // 创建 User 对象
    User user = new User();
    user.setUsername("jackson");
    user.setPassword("1234");
    user.setAge(50);

    // 创建地址 Address 对象
    Address a = new Address();
    a.setCity("北京");
    a.setStreet("大兴区");
    a.setZipcode("11111111");

    user.setAddr(a);

    // 将 User 对象存储到 request 域当中
    request.setAttribute("userObj", user);
%>

<%-- 使用 EL 表达式，从 request 域当中，取出 User 对象，并将其输出到浏览器 --%>
<%-- 1. 使用 EL 表达式会自动从某个范围中取数据。2. 将其转成字符串。3. 将其输出到浏览器。 --%>
${userObj}

<br>
<%-- 你想输出的是 user 对象的 username 属性 --%>
${userObj.username}
<br>
<%-- 输出 password --%>
${userObj.password}
<br>
<%-- 输出年龄 age --%>
${userObj.age}
<br>
<%-- 输出 email --%>
${userObj.email}
<br>
<%-- 在 EL 表达式中不能添加双引号，如果添加了双引号，EL 表达式就会将其当做普通的字符串输出到浏览器。 --%>
${"userObj"}
userObj

<br>
<%-- 取出 User 对象是哪个城市的？ --%>
城市：${userObj.addr222.city}
街道：${userObj.addr222.street}
邮编：${userObj.addr222.zipcode}