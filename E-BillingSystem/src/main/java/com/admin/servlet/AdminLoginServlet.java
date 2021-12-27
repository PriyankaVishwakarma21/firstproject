package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connection.DBCon;
import com.admin.dao.AdminDao;
import com.admin.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("Admin/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			//out.print("Its admin login servlet");
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			//out.print(email + " "+ password );
			AdminDao aDao = new AdminDao(DBCon.getConnection());
			Admin admin=aDao.adminLogin(email, password);
			
			if(admin != null) {
				request.getSession().setAttribute("loggedAdmin",admin);
				response.sendRedirect("adminHome.jsp");
			}else {
				out.print("user login falied");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
