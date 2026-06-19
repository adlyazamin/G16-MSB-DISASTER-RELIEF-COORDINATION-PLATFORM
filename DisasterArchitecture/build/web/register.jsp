<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Register</h2>

<form action="RegisterServlet" method="post">

    <label>Full Name</label><br>
    <input type="text" name="fullName" required><br><br>

    <label>Email</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password</label><br>
    <input type="password" name="password" required><br><br>

    <label>Phone</label><br>
    <input type="text" name="phone" required><br><br>

    <label>Role</label><br>
    <select name="role">
        <option value="Victim">Victim</option>
        <option value="Volunteer">Volunteer</option>
        <option value="NGO">NGO</option>
        <option value="Government">Government</option>
    </select>

    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>