<%@page import="com.admin.model.Admin"%>
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
<%@include file="include/header.jsp" %>
<title>Update Cost</title>
</head>
<body>
<%@include file="include/nav.jsp" %>
<main>
    <!--container starts-->
    <div class = "container mt-4 ">
        <!--row starts-->
        <div class = "row w-100 d-flex justify-content-center align-items-center" style="margin-top:10%;">
            <!--col-12 starts-->
            <div class = "col-12 col-md-8 col-xxl-5">
                <!--card starts-->
                <div class = "card py-3 px-2 ">
                    <!--division starts starts-->
                    <div class = "division">
                        <div class = "row">
                            <div class = "offset-md-3 col-md-6  mb-3 mt-3 " style="text-style:solid">
                                <span class = "main-heading " >Charge/Unit</span>
                            </div>
                        </div>

                            <form action = "" method="POST">
                            <div class = "mb-3">
                              <div class = "form-group">
                                    <label>Unit Greater then 300</label>
                                    <input type = "text" class = "form-control mt-2  " name="name"
                                     value = "" >
                                </div>
                            <div class = "form-group">
                                    <label>Unit Greater then 200 less than 300</label>
                                    <input type = "text" class = "form-control mt-2  " name="address"
                                     value = "" >
                                </div>
                                <div class = "form-group">
                                    <label>Unit Greater then 100 less than 200</label>
                                    <input type = "text" class = "form-control mt-2  " name="unit"
                                     value = "" >
                                     </div>
                                <div class = "form-group">
                                    <label>Unit less than 100</label>
                                    <input type = "text" class = "form-control mt-2  " name="dues"
                                     value = "" >
                                </div>
                                <div class="text-center">
						           <button type="submit" class="btn btn-primary" name="updateCost">Update Cost</button>
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
<%@include file="include/footer.jsp" %>
</body>
</html>