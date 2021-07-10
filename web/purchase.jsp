<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/7/1
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>purchase</title>
    <link type="text/css" rel="stylesheet" href="css/purchase.css">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script>
        $(document).ready(function (){
            $("#mount").change(function (){
                var v1=Number($("#save").text());
                var v2=Number($("#mount").val());
                if(v1<v2){
                    alert("数量不足")
                }else{
                    alert("数量正常");
                }
            });
            $("#w").click(function (){
                var v=$("#mount").val();
                var v2=$("#save2").text();
                var v3=$("#save").text();
                $.ajax({
                    url:"purchase2",
                    type:"post",
                    data:{"v":v,"v2":v2,"v3":v3},
                    success:function (result) {
                        v3=Number(v3);
                        v=Number(v);
                        alert(result);
                    },
                    error:function () {
                        alert("我失败了");
                    }
                });
            });
        });
    </script>
</head>
<body>
<div>
    <img src="${requestScope.path}" width="200px" height="300px">
    <p>${requestScope.bookname}</p>
    <div>
        <p>
            <label>书的编号:</label>
            <label id="save2">${requestScope.bookid}</label><br/>
            <label>库存:</label>
            <label id="save">${requestScope.num}</label><br/>
        </p>
    </div>
    <div>
        <label>购买数量:</label>
        <input type="text" id="mount"><br/>
        <input type="submit" value="加入购物车" id="w">
    </div>
</div>
</body>
</html>
