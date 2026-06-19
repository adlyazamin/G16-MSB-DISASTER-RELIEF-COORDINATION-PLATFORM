<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>User Login</h2>

<form action="LoginServlet" method="post">

    <label>Email</label><br>
    <input type="email" name="email" required>
    <br><br>

    <label>Password</label><br>
    <input type="password" name="password" required>
    <br><br>

    <input type="submit" value="Login">

</form>

<br>

<a href="register.jsp">Don't have an account? Register Here</a>

</body>
</html>