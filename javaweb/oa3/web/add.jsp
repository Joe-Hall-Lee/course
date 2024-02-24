<%@page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新增部门</title>
</head>

<body>
<h3>欢迎${username}
</h3>
<h1>新增部门</h1>
<hr>
<form action="${pageContext.request.contextPath}/dept/save" method="post">
    部门编号<input type="text" name="deptno"><br>
    部门名称<input type="text" name="dname"><br>
    部门位置<input type="text" name="loc"><br>
    <input type="submit" value="保存" onclick="window.history.back()">
</form>
</body>

</html>