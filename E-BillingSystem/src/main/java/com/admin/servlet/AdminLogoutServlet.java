package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogoutServlet
 */
@WebServlet("/admin-logout")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try(PrintWriter out = response.getWriter()){
				//out.print("Logout Servlet");
				if(request.getSession().getAttribute("loggedAdmin") != null) {
					request.getSession().removeAttribute("loggedAdmin");
					response.sendRedirect("adminlogin.jsp");
				}else {
					response.sendRedirect("index.jsp");
				}
				
			}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
