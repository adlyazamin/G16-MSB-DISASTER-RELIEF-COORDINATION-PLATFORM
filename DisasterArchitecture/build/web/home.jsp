<%@page import="model.User"%>

<%
    User user = (User) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Disaster Relief Coordination Platform</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1>Disaster Relief Coordination Platform</h1>

<h2>Welcome, <%= user.getFullName() %></h2>

<table border="1" cellpadding="10">

    <tr>
        <td><b>User ID</b></td>
        <td><%= user.getUserId() %></td>
    </tr>

    <tr>
        <td><b>Full Name</b></td>
        <td><%= user.getFullName() %></td>
    </tr>

    <tr>
        <td><b>Email</b></td>
        <td><%= user.getEmail() %></td>
    </tr>

    <tr>
        <td><b>Phone</b></td>
        <td><%= user.getPhone() %></td>
    </tr>

    <tr>
        <td><b>Role</b></td>
        <td><%= user.getRole() %></td>
    </tr>

</table>

<br>

<h3>Menu</h3>

<%
    if (user.getRole().equals("Victim")) {
%>

<a href="report.jsp">Submit Disaster Report</a>

<br><br>

<a href="ViewReportServlet">View My Reports</a>

<%
    } else if (user.getRole().equals("Volunteer")) {
%>

<a href="ViewTaskServlet">Volunteer Tasks</a>

<%
    } else if (user.getRole().equals("Government") || user.getRole().equals("NGO")) {
%>

<a href="ViewReportServlet">View All Reports</a>

<br><br>

<a href="resource.jsp">Add Resource</a>

<br><br>

<a href="ViewResourceServlet">View Resources</a>

<br><br>

<a href="ViewNotificationServlet">View Notifications</a>

<%
    }
%>

<br><br>

<hr>

<a href="LogoutServlet">Logout</a>

</body>
</html>