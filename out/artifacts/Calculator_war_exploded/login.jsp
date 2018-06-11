<%--
  Created by IntelliJ IDEA.
  User: peret
  Date: 10/06/2018
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
<form method="post" action="LoginServlet">
            <h2>Login Page</h2>
            Please provide your credential to use this website
            <br>
            <br>
            <div>Email:</div>
            <input name="email" title="Username" value=""/>
            <div>Password:</div>
            <input name="password" type="password" title="Password" value="" />
            <br />
            <span>
                New User?  <a href="register.jsp" >Register Here</a>
            </span>
            <br />
            <br />
            <input type="submit" value="Login" />
</form>
</center>
</body>
</html>
