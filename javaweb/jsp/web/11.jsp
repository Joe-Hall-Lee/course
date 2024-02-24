<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    // 一个 Map 集合
    Map<String, String> map = new HashMap();
    map.put("username", "zhangsan");
    map.put("password", "123");

    // 将 Map 集合存储到 request 域当中。
    request.setAttribute("userMap");

    Map<String, User> userMap2 = new HashMap<>();
    User user = new User();

    user.setUsername("zhangsan");
    userMap2.put("user", user);
    request.setAttribute("pingjingnuli", userMap2);
%>

<%-- 使用 EL 表达式将 Map 集合中的 user 对象中的 username 取出 --%>
${pingjingnuli.user.username}

<br>

<%-- 使用 EL 表达式，将 map 中的数据取出，并输出到浏览器 --%>
${userMap.username}
<br>
${userMap.password}
<br>
${userMap["username"]}
<br>
${userMap["password"]}
