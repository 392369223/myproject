<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.project.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/5
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改数量</title>
</head>
<body>
<table>
    <tr>
        <td>书名</td>
        <td>${requestScope.book.name}</td>
    </tr>
    <tr>
        <td>作者</td>
        <td>${requestScope.book.author}</td>
    </tr>
    <tr>
        <td>价格</td>
        <td>${requestScope.book.prise}</td>
    </tr>
    <tr>
        <td>图片</td>
        <td><img src="${requestScope.book.path}" width="200px" height="300px"/>
        </td>
    </tr>
    <tr>
        <td>类型</td>
        <td>${requestScope.book.tag}
        </td>
    </tr>
    <tr>
        <td>图书剩余</td>
        <td>${requestScope.book.count}
        </td>
    </tr>
    <tr>
        <form method="post" action="mod2">
            <td>修改数量</td>
            <c:set var="id" value="${requestScope.book.id}" scope="session"></c:set>
            <td><input type="text" name="mod" placeholder="">
            </td>
            <td><input type="submit"></td>
        </form>
    </tr>
</table>
</body>
</html>
