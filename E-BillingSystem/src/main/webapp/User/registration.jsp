<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <%@include file="include/header.jsp" %>
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
      
    </head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Register Account</div>
			<div class="card-body">
			
				<form action="RegisterUserServlet" method="post">
					<div class="form-group">
						<lable>Username</lable>
						<input type="text" class="form-control" name="username"
							placeholder="Enter Your Name" required>
					</div>
					<div class="form-group">
						<lable>Email</lable>
						<input type="email" class="form-control" name="useremail"
							placeholder="Enter Your Email" required>
					</div>
					<div class="form-group">
						<lable>Phone Number</lable>
						<input type="text" class="form-control" name="phoneno"
							placeholder="Enter Your Phone Number" required>
					</div>
					<div class="form-group">
						<lable>Address</lable>
						<input type="textarea" class="form-control" name="address"
							placeholder="Enter Your Address" required>
					</div>
					<div class="form-group">
						<lable>Password</lable>
						<input type="password" class="form-control" name="password"
							placeholder="Enter your Password" required>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
					<div class="text-center">
					 <a href="login.jsp">Already have Account?</a>
					</div>

				</form>
			</div>
		</div>
	</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
