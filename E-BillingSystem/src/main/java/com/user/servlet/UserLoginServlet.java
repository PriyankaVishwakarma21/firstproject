package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connection.DBCon;
import com.admin.dao.AdminDao;
import com.admin.model.Admin;
import com.user.dao.UserDao;
import com.user.model.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user-login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			//out.print("Its admin login servlet");
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			//out.print(email + " "+ password );
			UserDao uDao = new UserDao(DBCon.getConnection());
			User user=uDao.userLogin(email, password);
			
			if(user != null) {
				//request.getSession().setAttribute("loggedUser",user);
				User u=uDao.fetchUserInfoByEmailPass(email,password);
				System.out.println(u);
				request.getSession().setAttribute("UserInfo",u);
				RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
				rd.forward(request, response);	
				//response.sendRedirect("userHome.jsp");
			}else {
				out.print("user login falied");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
