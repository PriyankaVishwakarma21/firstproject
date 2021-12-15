<%@page import="cn.firstproject.connection.DBCon"%>
<%@page import="cn.firstproject.dao.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.firstproject.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
	response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
	response.setHeader("Expires","0");//Proxies server
	User auth=(User)request.getSession().getAttribute("auth");
    List<Order> orders=null;
	if(auth != null){
		request.setAttribute("auth",auth);
		OrderDao orderDao  = new OrderDao(DBCon.getConnection());
		orders = orderDao.userOrders(auth.getId());
	}else{
		response.sendRedirect("login.jsp");
	}
	
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
   
    if(cart_list != null){
    	request.setAttribute("cart_list", cart_list);
    }
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp" %>

<title>Order Page</title>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<%
			if(orders != null){
				for(Order o:orders){%>
				<tr>
					<td><%=o.getDate()%></td>
					<td><%=o.getName()%></td>
					<td><%=o.getCategory()%></td>
					<td><%=o.getQuantity()%></td>
					<td><%=o.getPrice()%></td>
					<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancel</a></td>
				</tr>
				<% }
			}
			%>
			</tbody>
		</table>
	</div>

	<%@include file="includes/footer.jsp" %>
</body>
</html>