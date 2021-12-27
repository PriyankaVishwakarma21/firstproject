<%@page import="com.admin.connection.DBCon"%>
<%@page import="com.admin.dao.BillingCycleDao"%>
<%@page import="com.admin.model.BillingCycle"%>
<%@page import="java.util.List"%>
<%@page import="com.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server

User user = (User)request.getSession().getAttribute("UserInfo");
List<BillingCycle> bills=null;
if(user!= null){
	request.setAttribute("user", user);
	BillingCycleDao billDao = new BillingCycleDao(DBCon.getConnection());
		bills = billDao.PaidBillbyUser(user.getId());
		request.setAttribute("bills", bills);
	//System.out.println(bills);
}else{
	response.sendRedirect("login.jsp");
}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="include/header.jsp" %>
<title>View Bills</title>
</head>
<body>
<%@include file="include/nav.jsp" %>

<div class="container">
		<div class="card-header my-3 text-center ">All Paid Bills</div>
		<table class="table table-light ">
			<thead>
				<tr>
				
					<th scope="col" class="text-center">Bill Id</th>
					<th scope="col" class="text-center">User Id</th>
					<th scope="col" class="text-center">Name</th>
					<th scope="col" class="text-center">Unit</th>
					<th scope="col" class="text-center">Date</th>
					<th scope="col" class="text-center">Bill</th>
					<th scope="col" class="text-center">DueDate</th>
					<th scope="col" class="text-center">Status</th>
					<!--  <th scope="col" class="text-center">Action</th> -->
					
									</tr>
			</thead>
			<tbody>
			<%
				for(BillingCycle bill:bills){
			%>
				<tr>
					<td class="text-center"><%=bill.getBillId() %></td>
					<td class="text-center"><%=bill.getId() %></td>
					<td class="text-center"><%=bill.getName() %></td>
					<td class="text-center"><%=bill.getUnit() %></td>
					<td class="text-center"><%=bill.getDate() %></td>
					<td class="text-center"><%=bill.getAmount() %></td>
					<td class="text-center"><%=bill.getDuedate() %></td>
					<td class="text-center"><%=bill.getStatus() %></td>
					
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
<%@include file="include/footer.jsp" %>
</body>
</html>