<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/26
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证界面</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty sessionScope.correct}">
        <form action="correct" method="post">
            <label>输入修改密码:</label>
            <input type="password" name="passwd">
            <input  type="submit" value="提交">
        </form>
    </c:when>
    <c:otherwise>
        页面错误
    </c:otherwise>
</c:choose>
</body>
</html>
