<%@ page import="com.project.bean.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/2
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sell</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>书名</td>
        <td>买家姓名</td>
        <td>书本单价</td>
        <td>书本数量</td>
        <td>总销售额</td>
    </tr>
    <c:forEach items="${requestScope.lst}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.name}</td>
            <td>${v.buyname}</td>
            <td>${v.prise}</td>
            <td>${v.count}</td>
            <td>${v.prise*v.count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
