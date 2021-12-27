package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connection.DBCon;
import com.admin.dao.AdminDao;
import com.user.model.User;

/**
 * Servlet implementation class updateuserinfoservlet
 */
@WebServlet("/update_user_info")
public class updateuserinfoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateuserinfoservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			out.println("update user info");
			int userid=Integer.parseInt(request.getParameter("userid1"));
			String username= request.getParameter("username1");
			String email=request.getParameter("useremail1");
			String phoneno=request.getParameter("phoneno1");
			String address = request.getParameter("address1");
			//out.println(userid + " " + username + " "+ email + " " + phoneno + " " + address);
			User u=new User();
			u.setId(userid);
			u.setName(username);
			u.setPhoneno(phoneno);
			u.setAddress(address);
			
			AdminDao udao = new AdminDao(DBCon.getConnection());
			boolean result = udao.updateuserinfo(u);
			System.out.println(result);
			if(result) {
				response.sendRedirect("viewuser.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
