<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/30
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改界面</title>
</head>
<body>
<div>
  <form method="post" action="modify2">
    <span>性别:</span><input type="text" name="sex" value="${requestScope.sex}"><br/>
    <span>电话:</span><input type="text" name="phone" value="${requestScope.phone}"><br/>
    <span>邮件:</span><input type="text" name="email" value="${requestScope.email}">
    <input type="submit" value="确认修改">
  </form>
</div>
</body>
</html>
