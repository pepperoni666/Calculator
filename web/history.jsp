<%@ page import="calcData.UsersEntity" %>
<%@ page import="calcData.HistoryService" %>
<%@ page import="calcData.HistoryEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: peret
  Date: 12/06/2018
  Time: 01:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<body>
<%
    UsersEntity user = (UsersEntity) session.getAttribute("user");
%>
<p>Welcome <%= user.getEmail()%></p>
<a href="logout.jsp">Logout</a>
<center>
    <table>
        <tr>
            <th><u>Brutto</u></th>
            <th>Ubezpieczenie emerytalne</th>
            <th>Ubezpieczenie rentowe</th>
            <th>Ubezpieczenie chorobowe</th>
            <th>Ubezpieczenie zdrowotne</th>
            <th>Zaliczka na PIT</th>
            <th><u>Netto</u></th>
        </tr>
        <tbody>
            <%
                 HistoryService history = new HistoryService();
                 List<HistoryEntity> list = history.getFullHistory(user.getEmail());
                 for (HistoryEntity h : list) {
            %>
        <tr>
            <td><b><%=h.getBrutto()%></b></td>
            <td><%=h.getUbez_emerytalne()%></td>
            <td><%=h.getUbez_rentowe()%></td>
            <td><%=h.getUbez_chorobowe()%></td>
            <td><%=h.getUbez_zdrowotne()%></td>
            <td><%=h.getZaliczka_pit()%></td>
            <td><b><%=h.getNetto()%></b></td>
        </tr>
            <%}%>
        <tbody>
    </table>
    <br/>
    <a href="home.jsp">Back to calculator</a>
</center>
</body>
</html>
