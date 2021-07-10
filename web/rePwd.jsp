<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/7/2
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>邮箱注册</title>
    <link rel="stylesheet" href="css/rePwd.css"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

    <style type="text/css">

    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                    if ($("#email").val()) {
                        $.ajax({
                            type: "POST",
                            url: "sendEmailServlet?random" + Math.random(),
                            data: {
                                email: $("#email").val(),
                            },
                            success: function () {
                                alert("验证码发送成功，请注意查收。");
                            },
                        })
                    } else {
                        alert("邮箱发送失败");
                        $("#notice").html("请填写邮箱");
                        setTimeout(function () {
                            $("#notice").hide();
                        }, 1000);
                    }
                }
            );
            //  判断用户是否可以注册
            $("#submit").click(function () {
                if ($("#email").val()) {
                    $("#RegistForm").submit();
                } else { //  如果没有值
                    $("#notice").html("请填写完整信息");
                    setTimeout(function () {
                        $("#notice").hide();
                    }, 1000);
                }
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div id="register">
        <form class="form-horizontal" id="RegistForm" method="post"
              action="rePwdServlet">
            <fieldset>
                <div id="legend" class="">
                    <legend class=""></legend>
                    <h1 align="center">用户修改密码</h1>
                </div>
                <div class="form-group">
                    <!-- Text input-->
                    <div class="col-sm-5">
                        <p>
                            <label class="col-sm-2 control-label">账号</label>
                            <input type="text" placeholder="请输入您的账号" class="form-control"
                                   required name="uname">
                        </p>
                    </div>
                </div>
                <div class="form-group">

                    <div class="col-sm-5">
                        <p>
                            <label class="col-sm-2 control-label">邮箱</label>
                        <input type="email" placeholder="请填写邮箱地址" class="form-control"
                               id="email" name="email" required>
                        </p>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-5">
                        <p>
                            <label class="col-sm-2 control-label">验证码</label>
                        <input type="text" name="code" id="code" placeholder="请输入邮箱的验证码"
                               class="form-control" required>
                        <input type="button" name="btn"
                               class="btn btn-default" id="btn" value="发送验证码"/>
                        </p>
                    </div>

                </div>
                <h4 align="center"><span id="notice" class="hide" >请先完成邮箱验证</span></h4>
                <div class="form-group">
                    <div class="col-sm-5">
                        <p>
                            <label class="col-sm-2 control-label">密码</label>
                        <input type="password" placeholder="请输入新密码" required
                               class="form-control" name="pwd">
                        </p>
                    </div>

                </div>
                <div class="form-group1" align="center">
                    <div class="col-sm-offset-2 col-sm-10 " >
                        <div class="buttons" align="center">
                            <p style="text-align: center;">
                            <input onclick="window.location.href='login.jsp'" type="reset"
                                   class="btn btn-success" value="返回登录"/>
                            <input class="btn btn-info" type="submit" id="submit"
                                   value="提交"/>
                            </p>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
