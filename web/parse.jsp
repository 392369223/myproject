<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/6/25
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //javax.naming.Context提供了查找JNDI的接口
    Context ctx = new InitialContext();
    //java:comp/env/为前缀，通过lookup查找
    String name = (String) ctx.lookup("java:comp/env/jndiName");
    out.println("JNDI: " + name);
%>
<%
    //javax.naming.Context提供了查找JNDI的接口
    Context ctx2 = new InitialContext();
    //java:comp/env/为前缀，通过lookup查找
    DataSource ds = (DataSource) ctx2.lookup("java:comp/env/jdbc/hrs");
    Connection conn = ds.getConnection();
    PreparedStatement sta=conn.prepareStatement("select * from student");
    ResultSet s=sta.executeQuery();
%>
<table border="1">
    <tr><td>ID</td><td>name</td><td>password</td>
        <td>sex</td>
    </tr>
        <%
        while(s.next()){
%>
    <tr> <td><%=s.getInt(1)%></td>
        <td><%=s.getString(2)%></td>
        <td><%=s.getString(3)%></td>
        <td><%=s.getString(4)%></td>
    </tr>
        <%
        }
        s.close();
        sta.close();
        conn.close();
%>
</body>
</html>
