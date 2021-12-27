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

<title>E-BillingSystem</title>

<style>
     /* Style the buttons */
     .btn1 {
        border: none;
        outline: none;
        padding: 12px 16px;
        background-color: white;
        cursor: pointer;
     }

    /* Add a grey background color on mouse-over */
    .btn1:hover {
        background-color: #ddd;
    }

    /* Add a pink background color to the active button */
    .btn1.active {
        background-color: rgb(194,71,92);
        color: white;
    }
    main{
        height:90vh;
    }
 </style>  
</head>
<body>
 <!--Header section-->
    <header>
        <!--navbar section-->
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid"><!--Start container fluid class-->
            <a class="navbar-brand" href="#"><i class="far fa-lightbulb"></i>E-Billing System</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="fas fa-align-right"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav"><!--start collapse navbar-->
                <ul class="navbar-nav ml-auto mb-2" id="navbar-nav">
                    <li class="nav-item ">
                        <a class="nav-link active " aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="User/registration.jsp">SignUp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="User/login.jsp">Login</a>
                    </li>
                </ul>
            </div><!--End collapse navbar-->
        </div><!--End Container fluid-->
    </nav><!--End navbar-->
   </header>
    <!--End header-->
 <% out.print( DBCon.getConnection()); %>
   <main class="main"><!--Start main section-->
       <div class="container"><!--Start container section-->
          <div class="row"><!--Start row section-->
              <div class="col-lg-5 margintop" style="height: 40%;"><!--Start 1st column-->
                 <img src="flight.jpg" alt="" class="img-fluid">
              </div><!--End 1st column-->
              <div class="col-lg-7 margintop"><!--Start 2nd column-->
                <h1>WELCOME TO E-BILLING SYSTEM</h1>
                <P>Welcome to the E-Billing System..
                   Lorem ipsum dolor sit, amet consectetur adipisicing elit. At
                   laborum voluptates natus tenetur cum quidem, aliquam vitae..         
                </P>
                <div class="buttons">
                   <a href="Admin/adminlogin.jsp" class="btn btn-light px-5 py-2">Admin</a>
                   <a href="User/login.jsp" class="btn btn-light px-5 py-2">Customer</a>
                </div>
              </div><!--End 2nd column-->

         </div><!--End row section-->
       </div><!--End conrainer section-->
   </main>
    <!--End main section-->
 
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" ></script>
</body>
</html>