<%@ page import="calcData.UsersEntity" %><%--
  Created by IntelliJ IDEA.
  User: peret
  Date: 10/06/2018
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%
    UsersEntity user = (UsersEntity) session.getAttribute("user");
%>
<p>Welcome <%= user.getEmail()%></p>
<a href="logout.jsp">Logout</a>
<center>
    <h1>Kalkulator wynagrodzeń (płac) netto-brutto </h1>
    <form method="post" action="CalcServlet">
        Podaj miesieczne wynagrodzenie (brutto)
        <input name = "wynagrod" value="0"/> <br/><br/>
        <input name = "gdzie" type = "checkbox" checked="checked" id="cb"/>
        <label for="cb">Praca w miejscu zamieszkania</label><br/><br/>
        <input type="submit" value="Calculate"/>
    </form>
</center>
</body>
</html>
