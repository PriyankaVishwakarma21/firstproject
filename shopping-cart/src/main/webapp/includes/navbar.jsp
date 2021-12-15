
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  <div class="container">
    <a class="navbar-brand" href="index.jsp">E-Commerce Shopping cart</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" 
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link active" aria-current="page" href="index.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge badge-danger px-1">${ cart_list.size() }</span></a></li>
        <% 
       // User  auth=(User)request.getSession().getAttribute("auth");
        if(auth != null){%>
        	<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
            <li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>
       <%  }else{%>
        	<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
       <% }
        %>
       
         </ul>
     
    </div>
    </div><!-- container closing -->
  </div>
</nav>