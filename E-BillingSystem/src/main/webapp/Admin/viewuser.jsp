<%@page import="com.admin.connection.DBCon"%>
<%@page import="com.user.dao.UserDao"%>
<%@page import="com.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.admin.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server

Admin admin = (Admin)session.getAttribute("loggedAdmin");
if(admin == null){
	  response.sendRedirect("adminlogin.jsp");
}
List<User> list = new UserDao(DBCon.getConnection()).selectAllUser();


 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="include/header.jsp" %>
<title>All Users</title>
</head>
<body>
<%@include file="include/nav.jsp" %>
 
 
 <div class="container">
		<div class="card-header my-3 text-center ">All Users</div>
		<table class="table table-light ">
			<thead>
				<tr>
					<th scope="col" class="text-center">User Id</th>
					<th scope="col" class="text-center">User Name</th>
					<th scope="col" class="text-center">Email</th>
					<th scope="col" class="text-center">Phone no.</th>
					<th scope="col" class="text-center">Address</th>
					<th scope="col" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(User u:list){
			%>
				<tr>
					<td class="text-center" name="userid"><%= u.getId() %></td>
					<td class="text-center" name="username"><%= u.getName() %></td>
					<td class="text-center" name="email"><%= u.getEmail() %></td>
					<td class="text-center" name="phoneno"><%= u.getPhoneno() %></td>
					<td class="text-center" name="address"><%= u.getAddress() %></td>
					<td class="text-center"><a class="btn btn-sm btn-success" href="updateuserinfo.jsp?userid=<%=u.getId()%>
					&username=<%=u.getName() %>&email=<%=u.getEmail() %>&phoneno=<%=u.getPhoneno() %>&address=<%=u.getAddress() %>">Edit</a>&nbsp
					    <a class="btn btn-sm btn-danger" href="DeleteUserServlet?userid=<%=u.getId()%>">Delete</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>

<%@include file="include/footer.jsp" %>
</body>
</html>
