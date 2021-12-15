package cn.firstproject.servlet;
import java.io.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.firstproject.connection.DBCon;
import cn.firstproject.dao.UserDao;
import cn.firstproject.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out=response.getWriter()){
			//out.print("this is login servlet"); checks the servelt is working or not
			String email=request.getParameter("login-email");
			String password=request.getParameter("login-password");
			//out.print(email + password); to check its working or not
			UserDao udao=new UserDao(DBCon.getConnection());//initialize the userdao and provide connection by dbcon
			User user=udao.userLogin(email, password);

			//check user is null or not
			if(user != null) {
				//out.print("user login");
				request.getSession().setAttribute("auth", user);//store the user session
				response.sendRedirect("index.jsp");
			}else {
				out.print("user login failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
