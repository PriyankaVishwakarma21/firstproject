<%@page import="java.util.*"%>
<%@page import="cn.firstproject.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="cn.firstproject.connection.DBCon" %>
<%@ page import="cn.firstproject.model.*" %>
<% 
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//it prevents the back button //Http 1.1
response.setHeader("Pragma","no-cahe");//works in older versionHttp.1.0
response.setHeader("Expires","0");//Proxies server
	User auth=(User)request.getSession().getAttribute("auth");
	if(auth != null){
		request.setAttribute("auth",auth);
	}
	
//call product
ProductDao pd=new ProductDao(DBCon.getConnection());
List<Product> Products=pd.getAllProducts();
//cart page
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp" %>

<title>Welcome to Shopping Cart</title>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<% //out.print(DBCon.getConnection()); %>
	<div class="container">   <!-- card body -->
		
			<div class="card-header my-3">All Products</div>
			<div class="row">
			<%
			  if(! Products.isEmpty()){
				  for(Product p:Products){%>
					  <div class="col-md-3 my-3">
						<div class="card w-100" style="width: 18rem;">
							<img src="product-images/<%= p.getImage()%>" class="card-img-top" alt="...">
							<div class="card-body">
								<h5 class="card-title"><%= p.getName() %></h5>
								<h6 class="price">Price: $<%= p.getPrice() %></h6>
								<h6 class="category">Category: <%= p.getCategory() %></h6>
								<div class="mt-3 d-flex ustify-content-between">
								<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark">Add to Cart</a>&nbsp
								<a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-primary">Buy Now</a>
								</div>
							</div>
						</div>
						</div>
				<%  }
			  }
			%>
				
					
				
			</div>
	
	</div>

	<%@include file="includes/footer.jsp" %>
</body>
</html>