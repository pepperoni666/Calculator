<%--
  Created by IntelliJ IDEA.
  User: peret
  Date: 10/06/2018
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.removeAttribute("userId");
    session.removeAttribute("password");
    session.invalidate();
%>
    <h1>You have successfully logged out</h1>
    To login again <a href="login.jsp">click here</a>.
</body>
</html>
