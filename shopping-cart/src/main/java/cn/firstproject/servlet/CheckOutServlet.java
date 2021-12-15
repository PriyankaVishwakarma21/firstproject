package cn.firstproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.firstproject.connection.DBCon;
import cn.firstproject.dao.OrderDao;
import cn.firstproject.model.*;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			//out.println("check out servlet");
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			Date date= new Date();
			//retrive all cart products
			ArrayList<Cart> cart_list= (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
			User auth=(User)request.getSession().getAttribute("auth");//get the authentication user
			
			//check auth and cart list
			if(cart_list != null && auth != null) {
				//prepare order obj
				for(Cart c:cart_list) {
					Order order = new Order();
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					//instantiate the dao class
					OrderDao oDao = new OrderDao(DBCon.getConnection());
					//calling the insert method
				boolean result =	oDao.insertOrder(order);
				if(!result) break;
				
				}//end of for
				
				cart_list.clear();
				response.sendRedirect("orders.jsp");
				
				
			}else {
				if(auth == null) response.sendRedirect("login.jsp");
				response.sendRedirect("cart.jsp");
			}
			
		}catch(Exception e) {
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
