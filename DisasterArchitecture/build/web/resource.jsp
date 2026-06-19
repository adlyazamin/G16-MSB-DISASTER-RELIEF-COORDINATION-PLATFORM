<%@page import="model.User"%>

<%
User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Resource</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Add Resource</h2>

<form action="AddResourceServlet" method="post">

Resource Name<br>
<input type="text" name="resourceName" required>

<br><br>

Quantity<br>
<input type="number" name="quantity" required>

<br><br>

Location<br>
<input type="text" name="location" required>

<br><br>

Status<br>

<select name="status">
    <option>Available</option>
    <option>Low Stock</option>
    <option>Out of Stock</option>
</select>

<br><br>

<input type="submit" value="Add Resource">

</form>

</body>
</html>