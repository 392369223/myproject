<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/26
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问卷页</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        .m1{
           margin-left: 100px;
            margin-right: 100px;
            overflow: auto;
        }
    </style>
    <script>
        function check(v1,v2){
            if(v1.value==null||v1.value==""){
                alert("1error");
                return false;
            }else if(v2.value==null||v2.value==""){
                alert("2error");
                return false;
            }else{
                return true;
            }
        }
    </script>
</head>
<body>
<div class="m1">
    <div>
        <img src="img/bookshow.jpg" width="300px" height="100px" style="display: inline-block"/>
        <h2 style="display: inline-block"><strong>登陆页满意度调查</strong></h2>
        <hr style="border:2px red solid"/>
    </div>
    <div>
        <form method="post" action="question" onsubmit="return check(ss,area)">
        <br>
        <p>您对整体登陆的满意度如何?</p><br>
      <input type="radio" name="ss" value="非常满意">非常满意<br>
        <input type="radio" name="ss" value="满意">满意<br>
        <input type="radio" name="ss" value="一般">一般<br>
        <input type="radio" name="ss" value="不满意">不满意
        <br><br>
        <p>您对登陆页有什么想法,请大声说出来吧!</p>
        <br>
        <textarea name="area" cols="50" rows="10"></textarea><br>
            <input type="submit" value="提交评价">
        </form>
    </div>
</div>
</body>
</html>
