<%@page import="java.util.List"%>
<%@page import="model.Resource"%>

<%
List<Resource> resources = (List<Resource>) request.getAttribute("resources");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Resources</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Emergency Resources</h2>

<table border="1" cellpadding="10">

<tr>

<th>ID</th>
<th>Resource</th>
<th>Quantity</th>
<th>Location</th>
<th>Status</th>

</tr>

<%
if(resources != null){

    for(Resource resource : resources){
%>

<tr>

<td><%=resource.getResourceId()%></td>

<td><%=resource.getResourceName()%></td>

<td><%=resource.getQuantity()%></td>

<td><%=resource.getLocation()%></td>

<td><%=resource.getStatus()%></td>

</tr>

<%
    }
}
%>

</table>

<br>

<a href="resource.jsp">Add Resource</a>

<br><br>

<a href="home.jsp">Home</a>

</body>
</html>