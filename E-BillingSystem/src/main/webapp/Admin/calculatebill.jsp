<%@page import="com.admin.model.Admin"%>
<%@page import="java.sql.*"%>
<%@page import="com.admin.connection.DBCon"%>
<%@page import="com.user.dao.UserDao"%>
<%@page import="com.user.model.User"%>
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
User u = (User) request.getSession().getAttribute("search");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="include/header.jsp" %>
<title>Calculate Bill</title>
</head>
<body>
<%@ include file="include/nav.jsp" %>

<!--main starts-->
<main>
    <!--container starts-->
    <div class = "container mt-5 ">
        <!--row starts-->
        <div class = "row w-100 d-flex justify-content-center align-items-center" style="margin-top:10%;">
            <!--col-12 starts-->
            <div class = "col-12 col-md-8 col-xxl-5">
                <!--card starts-->
                <div class = "card py-3 px-2 ">
                    <!--division starts starts-->
                    <div class = "division">
                        <div class = "row">
                            <div class = "offset-md-3 col-md-6  mb-3 mt-3 ">
                                <span class = "main-heading ">Enter Bill Information</span>
                            </div>
                        </div>
                        
							<form action = "calculateBillServlet" method="POST" name="BillInfo">
                            <div class = "mb-3">
                               <div class = "form-group">
                                    <label>UserId</label>
                                    <input type = "text" class = "form-control mt-2  " id = "userid" name="userid"
                                    aria-describedby = "emailHelp" value = "<%= u.getId() %>" >
                                </div>
                              <div class = "form-group">
                                    <label>Username</label>
                                    <input type = "text" class = "form-control mt-2  " name="username"
                                     value = "<%= u.getName() %>" >
                                </div>
                            <div class = "form-group">
                                    <label>Zone name</label>
                                    <input type = "text" class = "form-control mt-2  " name="address"
                                     value = "<%= u.getAddress() %>" >
                                </div>
                                <div class = "form-group">
                                    <label>Unit Consumed(In KW)</label>
                                    <input type = "text" class = "form-control mt-2  " name="unit"
                                     value = "" >
                                     </div>
                                <div class = "form-group">
                                    <label>Date</label>
                                    <input type = "date" class = "form-control mt-2  " name="date"
                                     value = "" >
                                </div>
                                <div class = "form-group">
                                    <label>Due Date</label>
                                    <input type = "date" class = "form-control mt-2  " name="duedate"
                                     value = "" >
                                </div>
                                <div class="text-center">
						           <button type="submit" class="btn btn-primary" name="calculate">Calculate Bill</button>
					            </div>
					            
					            <div class="text-ceter">
					            	<a  href="searchUser.jsp">Enter another user bill click here</a>
					            </div>
					            </div>
                        </form>
                        <!--form ends-->
                    </div>
                    <!--division ends-->
                </div>
                <!--cards ends-->
            </div>
            <!--col-12 ends-->
        </div>
        <!--row ends-->
       
    </div>
    <!--container ends-->
</main>
<!--main ends-->

<%@ include file="include/footer.jsp" %>
</body>
</html>