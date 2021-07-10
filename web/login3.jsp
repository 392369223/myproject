<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/23
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
    <link rel="icon" href="./image/logo.jpg">
    <style>
        body {
            background-color: ivory;
        }

        * {
            padding: 0;
            margin: 0;
        }

        .w {
            width: 990px;
        / / 总标签的宽度 margin: 0, 0, 0, 10;
        / / color: #000;
        }

        .logo {
            position: relative;
            width: 30%;
            margin-left: 3px;
            height: 60px;
            float: left;
        }

        .q-link {
            position: absolute;
            right: 30px;
            color: #999;
            float: right;
            top: 42px;
        }

        .q-link:hover {
            color: red;
        }

        a {
            color: #666;
            text-decoration: none;
        }

        b {
            position: absolute;
            left: 140px;
            top: 40px
        }

        #tag {
            position: absolute;
            top: 20px;
            right: 30px;
        }

        .w2 {
            width: 100%;
            height: 25px;
            padding-bottom: 5px;
            padding-top: 5px;
            clear: both;
            background-color: lightgrey;
        }

        .w3 {
            background: url("./image/reg .jpg");
            background-size: cover;
            width: 100%;
            height: 100%;
            padding-top: 50px;
            border: 1px solid darkred;
        }

        .w4 {
            position: absolute;
            top: 240px;
            right: 100px;
            width: 20%;
            border: 1px;
            background-color: mistyrose;
            padding: 20px 30px 20px 30px;
            border-radius: 50px;
        }

        .w5 {
            margin-bottom: 10px;
            margin-top: 10px;
            height: 30px;
        }

        .w6 {
            height: 30px;
            width: 200px;
            color: whitesmoke;
            background-color: rosybrown;
            border-radius: 20px;
        }

        .w7, .w8 {
            border: 2px black;
            display: inline-block;
            min-width: 100px;
            width: 80px;
            height: 40px;
        }

        .ww {
            color: black;
        }

        .ww:hover {
            color: rosybrown;
        }

        .squ {
            height: 30px;
        }
        label {
            display: inline-block;
            vertical-align: middle
        }
    </style>
    <script>
        function check3(v1,v2){
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
<div align="left">
    <div class="w">
        <div id="logo" class="logo">
            <a href="#" id="logoimg" alt="京东" style="outline: rgb(109, 109, 109) none 0px;"><img src="./image/book.jpg" width="160" height="60"></a>
            <b>欢迎登陆</b>
        </div>
        <a class="q-link" href="index.jsp" target="_blank" style="outline: rgb(109, 109, 109) none 0px;">
            <b></b>
            登陆页面，调查问卷
        </a>
    </div>
    <div id="tag">
        <label><b>闲鱼网上书城</b></label>
    </div>
</div>
<div class="w2" align="center">
    <p>根据《网络安全法》，为保障您的安全和正常使用，请设置登陆验证码并记住</p>
</div>
<div class="w3" align="center">
    <div class="hhh">
        <div class="w4">
            <h1 style="color: rosybrown">账户登陆</h1>
            <hr>
            <br/>
            <form action="login" onsubmit="return check3(user_name,pwd)" method="post">
                <div class="w5"><label class="w7">
                    <img src="./image/log.jpg" width="32px" height="32px"></label>
                    <input type="text" class="squ" name="user_name" placeholder="账户名"></div>
                <div class="w5"><label class="w8">
                    <img src="./image/pwd.jpg" width="32px" height="32px"></label>
                    <input type="password" class="squ" name="pwd" placeholder="密码"></div>
                <div align="right">
                    <a class="ww" href="#">忘记密码</a>
                </div>
                <div class="w5">
                    <br/>
                    <input type="submit" value="登陆" class="w6">
                </div>
                <br/><br/>
                <hr/>
                <br/>
                <div align="right">
                    <a class="ww" href="Reg.jsp">立即注册</a>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="includeFile.jsp" %>
</body>
</html>
