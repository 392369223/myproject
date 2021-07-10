<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/23
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
    <link href="./css/RegCss.jsp"  rel="stylesheet" />
    <style type="text/css">
        html {
            height: 100%;
            width: 100%;
            overflow: hidden;
            margin: 0;
            padding: 0;
            background: url("./img/reg.jpg") no-repeat 0px 0px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            -moz-background-size: 100% 100%;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100%;
        }

        .regin{
            position: absolute;
            right: 150px;
            top:100px;
            width: 25%;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 350px;
            background-color: mistyrose;
            box-shadow: 7px 7px 17px rgba(52, 56, 66, 0.5);
            border-radius: 8px;
        }

        #head {
            text-align: -moz-left;
            margin-left: 50px;
            margin-bottom: 20px;
            margin-top: 0px;
            color: rosybrown;
        }
        .reg {
            float: right;
            width: 300px;
            display: flex;
            flex-direction: column;
            margin: 100px auto;
            margin-top: 40px;
            margin-bottom: 20px;
            padding: 10px;
        }
        input
        {
            margin-left: 15px;
            border-radius: 5px;
            border-style: hidden;
            height: 25px;
            width: 140px;
            background-color: lavenderblush;
            outline: none;
            color: silver;
            padding-left: 10px;
        }
        label,.sexdiv{
            color: rosybrown;
            display: inline-block;
            text-align: justify;
            text-align-last: justify;
            margin: 5px;
        }
        .sexdiv>input{
            width: 15px;
            height: 15px;
        }

        span{
            font-family: "Times New Roman";
            font-size: 16px;
            font-weight: bold;
        }
        .button {
            border-color: cornsilk;
            background-color: royalblue;
            color: aliceblue;
            border-style: hidden;
            border-radius: 5px;
            width: 100px;
            height: 31px;
            font-size: 16px;
        }
        #head_foot{
            position: absolute;
            bottom: 0px;
        }

    </style>
    <script type="text/javascript">
        function check2pwd(v1,v2,v3,v4,v5,v6) {
            if(v2.value.length<6){
                alert("密码长度至少为6位")
                v2.value = "";
                v3.value="";
                return false;
            }else if(v3.value.length>=12){
                alert("密码过长")
                v2.value="";
                v3.value = "";
                return false;
            }
            if(v1.value==null||v1.value==""){
                alert("1error");
                return false;
            }else if(v2.value==null||v2.value==""){
                alert("2error");
                return false;
            }else if(v3.value==null||v3.value==""){
                alert("3error");
                return false;
            }else if(v4.value==null||v4.value==""){
                alert("4error");
                return false;
            }else if(v5.value==null||v5.value=="") {
                alert("5error");
                return false;
            } else if(v6.value==null||v6.value=="") {
                alert("6error");
                return false;
            }
            if (v2.value!=v3.value) {
                alert(v2.value+" "+v3.value);
                v2.value = "";
                v3.value = "";
                return false;
            }else{
                return true;
            }
        }
    </script>
</head>
<body>
<div align="center" class="regin ">
    <div class="w">
    <form name="reg" method="post" action="Reg"  onsubmit="return check2pwd(uname,pwd,pwd2,sex,email,phone)" class="reg" >
        <h1 id="head">用户信息注册<br/>
        </h1>
        <label>
            <span id="name_span">用户名:</span>
            <input id="name" type="text" name="uname" placeholder="请输入用户名">
        </label>
        <label>
            <span>密码：</span>
            <input type="password" name="pwd"  placeholder="请输入密码"/>
        </label>
        <label>
            <span>再次确认密码：</span>
            <input type="password" name="pwd2" id="pwd2" placeholder="再次输入密码"/>
        </label>
            <div class="sexdiv">
            <span>性别：</span>
            <input class="sex" type="radio" name="sex" value="男" checked="checked"/>男
            <input class="sex" type="radio" name="sex" value="女" />女
                <label id="sexsub"></label>
            </div>
        <label>
            <span>联系方式：</span>
            <input class="tel" type="tel" name="phone" placeholder="请输入联系方式" required
                   pattern="[0-9]{11}">
        </label>
        <label>
            <span>邮箱 :</span>
            <input type="email" name="email" placeholder="请输入邮箱地址"
                   pattern="[0-9a-zA-Z]{1,}@.*\.[0-9a-zA-Z]{1,}"/>
        </label>
        <c:choose>
            <c:when test="${not empty requestScope.error}">
                <label style="color: red">注册失败</label>
            </c:when>
        </c:choose>
        <label></label>
        <p style="text-align: center;">
            <input type="submit" class="button"  value="提交">
            <input type="reset" class="button" value="重置">
        </p>
    </form>
    </div>
</div>
<br/>
<div id="head_foot">
    <%@ include file="includeFile.jsp"%>
</div>
</body>
</html>
