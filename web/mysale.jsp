<%@ page import="com.project.bean.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/1
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>mysale</title>
</head>
<body>
<table>
    <tr>
        <td>图书ID</td>
       <td>图书名称</td>
        <td>作者</td>
        <td>价格</td>
        <td>图片</td>
        <td>类型</td>
        <td>数量</td>
        <td>上架信息</td>
        <td>上下架</td>
        <td>修改书本信息</td>
    </tr>
    <c:forEach items="${requestScope.lst}" var="v">
        <tr>
        <td>${v.id}</td>
        <td>${v.name}</td>
        <td>${v.author}</td>
        <td>${v.prise}</td>
        <td><img src="${v.path}"></td>
        <td>${v.tag}</td>
        <td>${v.count}</td>
        <td>${v.label==1?"已上架":"已下架"}</td>
        <td>
            <a href="rack?id=${v.id}&s=${v.label==1?"down":"up"}">${v.label==1?"下架":"上架"}</a>
        </td>
        <td>
            <a href="mod?id=${v.id}">修改</a>
        </td>
       </tr>
   </c:forEach>
</table>
</body>
</html>
