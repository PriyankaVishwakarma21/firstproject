package cn.firstproject.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.firstproject.connection.DBCon;
import cn.firstproject.dao.*;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CancelOrderServlet() {
 }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try(PrintWriter out=response.getWriter()){
			String id = request.getParameter("id");
			if(id != null) {//to make it more resured you can check user is logged in or not
				OrderDao orderDao  = new OrderDao(DBCon.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("orders.jsp");
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
