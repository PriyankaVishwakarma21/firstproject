<%@page import="com.admin.connection.DBCon"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

<title>Admin Login</title>
</head>
<body>
 
<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Admin Login</div>
			<div class="card-body">
			<!-- user-login is a servlet loginservlet when we submit it goes to loginServlet -->
				<form action="AdminLoginServlet" method="post">

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

					<div class="mt-4 text-center">
						<button type="button" class="btn btn-sm text-center button">
							<a href="../index.jsp" > <i
								class="fa fa-home fa-sm"></i> Back to Home
							</a>
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" ></script>
</body>
</html>