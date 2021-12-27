<%@page import="com.admin.model.Admin"%>
<%@page import="com.admin.connection.DBCon"%>
<%@page import="com.admin.dao.BillingCycleDao"%>
<%@page import="com.admin.model.BillingCycle"%>
<%@page import="java.util.*"%>
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
List<BillingCycle> list = new BillingCycleDao(DBCon.getConnection()).PaidBills();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><%@include file="include/header.jsp"  %>
<title>Payment History</title>
</head>
<body>
<%@include file="include/nav.jsp" %>

<div class="container mt-5">
		<div class="card-header my-3 text-center ">All Paid Bill Reports of Users</div>
		<table class="table table-light ">
			<thead>
				<tr>
				    <th scope="col" class="text-center">Id</th>
					<th scope="col" class="text-center">User Id</th>
					<th scope="col" class="text-center">Name</th>
					<th scope="col" class="text-center">Zone Name</th>
					<th scope="col" class="text-center">Unit</th>
					<th scope="col" class="text-center">Date</th>
					<th scope="col" class="text-center">Duedate</th>
					<th scope="col" class="text-center">Amount</th>
					<th scope="col" class="text-center">Status</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(BillingCycle bill:list){
					%>
						<tr>
					<td class="text-center"><%= bill.getBillId() %></td>
					<td class="text-center"><%= bill.getId() %></td>
					<td class="text-center"><%= bill.getName()  %></td>
					<td class="text-center"><%= bill.getAddress() %></td>
					<td class="text-center"><%= bill.getUnit() %></td>
					<td class="text-center"><%= bill.getDate() %></td>
					<td class="text-center"><%= bill.getDuedate() %></td>
					<td class="text-center"><%= bill.getAmount()%></td>
					<td class="text-center" style="background-color:tomato;" ><%= bill.getStatus() %></td>
				</tr>
				<% }
			%>
			</tbody>
		</table>
	</div>

<%@include file="include/footer.jsp" %>
</body>
</html>