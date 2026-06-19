<%@page import="java.util.List"%>
<%@page import="model.Task"%>

<%
List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Volunteer Tasks</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Available Volunteer Tasks</h2>

<table border="1" cellpadding="10">

<tr>
    <th>Task ID</th>
    <th>Report ID</th>
    <th>Description</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
if(tasks != null){

    for(Task task : tasks){
%>

<tr>

    <td><%=task.getTaskId()%></td>

    <td><%=task.getReportId()%></td>

    <td><%=task.getTaskDescription()%></td>

    <td><%=task.getTaskStatus()%></td>

    <td>

        <form action="AcceptTaskServlet" method="post">

            <input type="hidden"
                   name="taskId"
                   value="<%=task.getTaskId()%>">

            <input type="submit"
                   value="Accept">

        </form>

    </td>

</tr>

<%
    }
}
%>

</table>

<br>

<a href="home.jsp">Back Home</a>

</body>
</html>