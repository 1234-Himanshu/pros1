<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="MENU.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registration</title>
</head>
<body>
     <table>
     <tr>
     <th>Name</th>
     <th>City</th>
     <th>Email</th>
     <th>Mobile</th>
     </tr>
     <%
     ResultSet result=(ResultSet)request.getAttribute("res");
     while(result.next()){
    	%> 
     <tr>
     <td><%=result.getString(1)%></td>
     <td><%=result.getString(2)%></td>
     <td><%=result.getString(3)%></td>
     <td><%=result.getString(4)%></td>
     <td><a href="delete11?email=<%=result.getString(3)%>">delete</a></td>
	 <td><a href="update11?email=<%=result.getString(3)%>&mobile=<%=result.getString(3)%>">update</a></td>
     </tr>
     <%} %>
     </table>
</body>
</html>