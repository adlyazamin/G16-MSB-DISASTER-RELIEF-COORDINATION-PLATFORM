<%@page import="java.util.List"%>
<%@page import="model.Notification"%>

<%
List<Notification> notifications =
        (List<Notification>) request.getAttribute("notifications");
%>

<!DOCTYPE html>

<html>

<head>
    <title>Notifications</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2>Emergency Notifications</h2>

<table border="1" cellpadding="10">

<tr>

<th>ID</th>
<th>User ID</th>
<th>Message</th>
<th>Type</th>
<th>Status</th>

</tr>

<%
if(notifications != null){

    for(Notification notification : notifications){
%>

<tr>

<td><%=notification.getNotificationId()%></td>

<td><%=notification.getUserId()%></td>

<td><%=notification.getMessage()%></td>

<td><%=notification.getNotificationType()%></td>

<td><%=notification.getStatus()%></td>

</tr>

<%
    }
}
%>

</table>

<br>

<a href="home.jsp">Home</a>

</body>

</html>