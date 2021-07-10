<%@ page import="com.project.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/25
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <script>
        function fun1() {
            console.log("进入fun1");
            var a = new XMLHttpRequest();
            console.log("123");
            a.onreadystatechange = function () {
                console.log(a.responseText);
                document.getElementById("a").innerHTML=a.responseText;
            }
            a.open("GET","http://localhost:8081/myproject/Test",true);
            a.send();
        }
    </script>
</head>
<body>
<input type="button" onclick="fun1()" value="发送ajax请求">
<div id="a" >
</div>
<%
for(int i=0;i<10;i++){
    if(i==0){
%>
<div><img src="img/jd.jpg">
<%
    }else if(i<9){
%>
    <img src="img/jd.jpg">
<%}
 else{
%>
    <img src="img/jd.jpg"></div>
        <%
        }
}
 %>
</body>
</html>
