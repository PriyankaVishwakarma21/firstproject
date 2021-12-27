package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.connection.*;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/Delete-User")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			//int id=Integer.parseInt(request.getParameter("userid"));
			//out.println("Delete user servlet is working");
			//out.println("userid = "+id);
			String id = request.getParameter("userid");
			out.println("userid= "+id);
			if(id != null) {//to make it more resured you can check user is logged in or not
				AdminDao adminDao  = new AdminDao(DBCon.getConnection());
				adminDao.deleteUser(Integer.parseInt(id));
			}
			response.sendRedirect("viewuser.jsp");
		}catch (Exception e) {
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
