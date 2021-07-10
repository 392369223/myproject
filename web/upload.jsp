<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/25
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="./css/upload.css" rel="stylesheet">
<html>
<head>
    <title>文件上传</title>
    <link type="text/css" rel="stylesheet" href="css/upload.css">
    <style type="text/css">
        /*label{*/
        /*display: inline-block;*/
        /*min-width: 180px;!*或者 width: 100px;*!*/
        /*}*/
        /*.v{*/
        /*padding-left: 600px;*/
        /*background-color:yellowgreen;*/
        /*}*/
    </style>
    <script>
        function check(v1, v2, v3) {
            if (v1.value == null || v1.value == "") {
                alert("1error");
                return false;
            } else if (v2.value == null || v2.value == "") {
                alert("2error");
                return false;
            } else if (v3.value == null || v3.value == "") {
                alert("3error");
                return false;
            }  else {
                return true;
            }
        }
    </script>
</head>
<body>
<%--if(session.getAttribute("uname")==null||session.getAttribute("uname")==""){
    response.sendRedirect("error.jsp");
}--%>
<form action="upload" method="post" onsubmit="return check(username,author,t)" enctype="multipart/form-data"/>
<div align="center" class="v">
    <div align="left">
        <p id="head">书籍信息录入</p>
        <label>书名:</label>
        <input type="text" name="username"><br/>
        <label>作者:</label>
        <input type="text" name="author"><br/>
        <label>价格:</label>
        <input type="text" name="price" pattern="[1-9][0-9]*"><br/>
        <label>书的图片:</label>
        <input type="file" name="file1"><br/>
        <label>类型:</label>
        <select name="t">
            <option selected>生活</option>
            <option>人生</option>
            <option>言情</option>
            <option>历史</option>
            <option>国家</option>
            <option>名著</option>
            <option>亲情</option>
        </select><br/>
        <label>书本数量:</label><input type="text" name="count" pattern="[1-9][0-9]*"><br/>
        <%--<input type="submit" value="提交">--%>
        <p style="text-align: center;">
            <input type="submit" class="buttons"  onclick='checkForm()'value="提交">&nbsp;
            <input type="reset" class="buttons" value="重置">
        </p>
    </div>
</div>
</form>
</body>
</html>
