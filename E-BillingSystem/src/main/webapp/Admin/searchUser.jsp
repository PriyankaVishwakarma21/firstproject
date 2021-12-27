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
                                <span class = "main-heading ">Enter Search User Information</span>
                            </div>
                        </div>
                         <!--form starts-->
                        <form action = "SearchUserServlet" method="POST" name="UserSearch">
                            <div class = "mb-3">
                            
                                <div class = "form-group">
                                    <label>UserId</label>
                                    <input type = "text" class = "form-control mt-2  " id = "userid" name="userid"
                                    aria-describedby = "emailHelp" value = "" >
                                </div>
                                <div class="text-center">
						           <button type="submit" class="btn btn-success" name="search" href="calculatebill.jsp" >Search</button>
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