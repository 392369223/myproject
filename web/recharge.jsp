<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/30
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值</title>
</head>
<body>
<div>
    <div style="display: flex"><label>总金额:</label>
    <span>${requestScope.money}</span></div>
    <form method="post" action="recharge">
    <label>充值金额:</label>
    <select name="recharge">
        <option selected>100</option>
        <option>200</option>
        <option>500</option>
        <option>1000</option>
        <option>2000</option>
        <option>5000</option>
    </select>
    <input type="submit" value="充值">
    </form>
</div>
</body>
</html>
