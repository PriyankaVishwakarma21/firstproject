<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="cn.firstproject.model.*" %>
<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth != null){
		//request.setAttribute("auth",auth);
		response.sendRedirect("index.jsp");//if the user is allready logedin
	}
	
	//cart page
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>

<title>Shopping Cart Login</title>
</head>
<body>
<%@include file="includes/navbar.jsp" %>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
			<!-- user-login is a servlet loginservlet when we submit it goes to loginServlet -->
				<form action="user-login" method="post">

					<div class="form-group">
						<lable>Email Address</lable>
						<input type="email" class="form-control" name="login-email"
							placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<lable>Password</lable>
						<input type="password" class="form-control" name="login-password"
							placeholder="********" required>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>