<%@ page import="com.project.dao.UserDao" %>
<%@ page import="com.project.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/25
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示</title>
</head>
<body>
<%
UserDao dao=new UserDao();
int num=dao.findAllCount();
int allpage=0;
int pageIndex=1;
String s=request.getParameter("pageIndex");
String s2=request.getParameter("pageCount");
int pageCount=20;
if(s2!=null&&s2!=""){
  pageCount=Integer.parseInt("s2");
}
if(s!=null&&s!=""){
  pageIndex=Integer.parseInt(s);
}
if(num%pageCount==0){
  allpage=num/pageCount;
}else{
  allpage=num/pageCount+1;
}
List<User> lst=dao.findUserInfoByPageIndex(pageIndex,pageCount);
%>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>Password</td>
    <td>Sex</td>
    <td>Phone</td>
    <td>Email</td>
    <td>Address</td>

  </tr>
  <%
    for(User u:lst){
      %>
  <tr>
    <td><%=u.getUid()%></td>
    <td><%=u.getUname()%></td>
    <td><%=u.getPwd()%></td>
    <td><%=u.getSex()%></td>
    <td><%=u.getPhone()%></td>
    <td><%=u.getEmail()%></td>
  </tr>
  <%
    }
  %>
  <%
  if(pageIndex==1){
    String s1="show.jsp?pageIndex="+(pageIndex+1);
    %>
  <a href=<%=s1%>>下一页</a>
  <%
  }else if(pageIndex==allpage){
    String s1="show.jsp?pageIndex="+(pageIndex-1);
    %>
  <a href=<%=s1%>>上一页</a>
  <%
  }else{
String ss="show.jsp?pageIndex="+(pageIndex-1);
String sss="show.jsp?pageIndex="+(pageIndex+1);
%>
      <a href=<%=ss%>>上一页</a>
    <a href=<%=sss%>>下一页</a>
  <%
  }
  %>
</table>
</body>
</html>
