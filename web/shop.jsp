<%@ page import="com.project.bean.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/30
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车界面</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>书名</td>
        <td>作者</td>
        <td>图片</td>
        <td>类型</td>
        <td>库存</td>
        <td>价格</td>
        <td>购买数量</td>
    </tr>
    <%
        List<Book> shopbooks= (ArrayList<Book>)session.getAttribute("shopbooks");
        List<Integer> nums=(ArrayList<Integer>)session.getAttribute("nums");
        int len=shopbooks.size();
        for(int i=0;i<len;i++){%>
    <tr>
        <td><%=shopbooks.get(i).getId()%></td>
        <td><%=shopbooks.get(i).getName()%></td>
        <td><%=shopbooks.get(i).getAuthor()%></td>

        <td><img src="<%=shopbooks.get(i).getPath()%>" width="200px" height="300px"/>
        </td>
        <td><%=shopbooks.get(i).getTag()%></td>
        <td><%=shopbooks.get(i).getCount()%></td>
        <td><%=shopbooks.get(i).getPrise()%></td>
        <td><%=nums.get(i)%></td>
    </tr>
    <%
        };
    %>
    <tr>
        <td><a href="pay">支付</a></td>
        <td><a href="unpay">取消支付</a></td>
    </tr>
</table>

</body>
</html>
