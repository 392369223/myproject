<%@ page import="com.project.bean.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/1
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>myorder</title>
</head>
<body>
<table>
    <tr><td>ID</td><td>图书姓名</td><td>图书卖家</td><td>购买图书数量</td><td>图书价格</td>
        <td>总价格</td>
    </tr>
    <c:forEach items="${requestScope.lst}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.name}</td>
            <td>${v.salername}</td>
            <td>${v.count}</td>
            <td>${v.prise}</td>
            <td>${v.count*v.prise}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
