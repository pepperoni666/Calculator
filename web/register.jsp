<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form action="RegisterServlet" method="post">
    Email:<input type="text" name="email"/><br><br/>
    Password:<input type="password" name="password"/><br><br/>
    Confirm password:<input type="password" name="conf_password"/><br><br/>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">

</form>
</body>
</html>