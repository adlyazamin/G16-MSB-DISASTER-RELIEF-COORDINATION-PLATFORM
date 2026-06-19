<%@page import="java.util.List"%>
<%@page import="model.Report"%>

<%
List<Report> reports = (List<Report>) request.getAttribute("reports");
%>

<!DOCTYPE html>

<html>

<head>
    <title>View Reports</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2>Disaster Reports</h2>

<table border="1" cellpadding="10">

<tr>

<th>ID</th>
<th>User ID</th>
<th>Disaster</th>
<th>Description</th>
<th>Location</th>
<th>Risk</th>
<th>Status</th>

</tr>

<%
if(reports != null){

for(Report report : reports){
%>

<tr>

<td><%=report.getReportId()%></td>

<td><%=report.getUserId()%></td>

<td><%=report.getDisasterType()%></td>

<td><%=report.getDescription()%></td>

<td><%=report.getLocation()%></td>

<td><%=report.getRiskLevel()%></td>

<td><%=report.getStatus()%></td>

</tr>

<%
}
}
%>

</table>

<br>

<a href="report.jsp">Submit Another Report</a>

<br><br>

<a href="home.jsp">Home</a>

</body>

</html>