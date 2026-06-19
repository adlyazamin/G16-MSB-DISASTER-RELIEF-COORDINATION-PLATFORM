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
    <title>Submit Report</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2>Disaster Report Form</h2>

<form action="SubmitReportServlet" method="post">

Disaster Type<br>
<input type="text" name="disasterType" required>

<br><br>

Description<br>
<textarea name="description" rows="5" cols="40"></textarea>

<br><br>

Location<br>
<input type="text" name="location" required>

<br><br>

Risk Level<br>

<select name="riskLevel">

<option value="Low">Low</option>
<option value="Medium">Medium</option>
<option value="High">High</option>

</select>

<br><br>

<input type="submit" value="Submit Report">

</form>

</body>

</html>