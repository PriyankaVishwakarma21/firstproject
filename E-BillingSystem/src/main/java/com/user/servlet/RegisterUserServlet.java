package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.connection.DBCon;
import com.user.dao.UserDao;
import com.user.model.User;

/**
 /* Servlet implementation class RegisterUserServlet
 */
@WebServlet("/register-user")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("useremail");
		String phoneno = request.getParameter("phoneno");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		
		User user = new User(name,email,phoneno,address,password);
		try {
			UserDao uDao = new UserDao(DBCon.getConnection());
			uDao.register(user);
		
			response.sendRedirect("login.jsp");
			/*if(user != null) {
				//request.getSession().setAttribute("User",user);
				//response.sendRedirect("login.jsp");
			}*/
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
