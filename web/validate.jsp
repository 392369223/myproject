<%--
  Created by IntelliJ IDEA.
  User: 86156
  Date: 2021/6/22
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>验证界面</title>
  </head>
  <body>
 <div align = "center" style="background-color: aqua">
   <form method ="post" action="validate">
 <table>
   <tr>
     <td>用户名：</td>
     <td><label>
       <input name="uname" type="text">
     </label></td>
   </tr>
   <tr>
     <td>电子邮箱:</td>
     <td><label>
       <input name="email" >
     </label></td>
   </tr>
   <tr>
     <td>性别:</td>
     <td><label for="sex"></label><input id="sex" type="radio" checked="checked" name="gen" value="男" >男&nbsp;&nbsp;
       <label for="sex1"></label><input id="sex1" type="radio" name="gen" value="女" >女
     </td>
   </tr>

   <tr>
     <td colspan="2" align="center">
       <input type="submit" name="Submit" value="提交">
       <input type="reset" name="Reset" value="取消">
     </td>
   </tr>
 </table>
     </form>
 </div>
  </body>
</html>
