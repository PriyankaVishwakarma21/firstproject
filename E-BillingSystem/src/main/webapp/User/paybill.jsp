<%@page import="com.user.model.User"%>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server
User user = (User)request.getSession().getAttribute("UserInfo");
  if(user == null){
	  response.sendRedirect("login.jsp");
  }
  //int id = Integer.parseInt(request.getParameter("id"));
 // int userid = Integer.parseInt(request.getParameter("userid"));
 // System.out.println(id + " "+ userid);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="include/header.jsp" %>
<title>Pay Bill</title>
</head>
<body>
<%@include file="include/nav.jsp" %>
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
                            <div class = "offset-md-3 col-md-6  mb-3 mt-3 text-center">
                                <span class = "main-heading ">Pay Bill</span>
                            </div>
                        </div>
                        <!--form starts-->
                        <form action = "" method="POST">
                            <div class = "mb-3">
                             <div class = "form-group">
                                    <label ><i class = "fas fa-user fa-sm mt-2 "></i>Card Number</label>
                                    <input type = "text" class = "form-control mt-2" 
                                    id = "aUser" value = "" >
                                </div>
                                <div class = "form-group">
                                    <label><i class = "fas fa-envelope fa-sm mt-2"></i>Expiry Date</label>
                                    <input type = "email" class = "form-control mt-2  " id = "aEmail1" 
                                    aria-describedby = "emailHelp" value = "" >
                                </div>
                                <div class = "form-group">
                                    <label ><i class = "fas fa-user fa-sm mt-2 "></i>CVV Code</label>
                                    <input type = "text" class = "form-control mt-2" 
                                    id = "aUser" value = "" >
                                </div>
                                <div class = "form-group">
                                    <label ><i class = "fas fa-user fa-sm mt-2 "></i>Bill Amount</label>
                                    <input type = "text" class = "form-control mt-2" 
                                    id = "aUser" value = "<%= request.getParameter("bill") %>" >
                                </div>
                                <div class="text-center form-group"><a class="btn btn-sm btn-primary" href="PayBillServlet?id=<%=request.getParameter("id")%>&userid=<%=request.getParameter("userid") %>">Pay</a></div>
                               
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