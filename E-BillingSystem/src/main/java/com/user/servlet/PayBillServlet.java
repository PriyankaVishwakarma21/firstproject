package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connection.DBCon;
import com.admin.dao.BillingCycleDao;
import com.admin.model.BillingCycle;

/**
 * Servlet implementation class PayBillServlet
 */
@WebServlet("/pay-bill")
public class PayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;cherset=UTF-8");
		try(PrintWriter out =response.getWriter() ){
			out.println("pay bill servlet is working");
			int id=(int)Integer.parseInt(request.getParameter("id"));
			int userid=(int)Integer.parseInt(request.getParameter("userid"));
			//String status="Paid";
			//System.out.println("id= " + id + "userid= " + userid);
			//out.println(id +" "+ userid);
			//out.println( Integer.parseInt(request.getParameter("id")) );
			//out.println( Integer.parseInt(request.getParameter("userid")) );
			//System.out.println("billid= " + id + " userid= " + userid);
			BillingCycle bill = new BillingCycle();
			
			bill.setBillId(id);
			bill.setId(userid);
			//bill.setStatus(status);
			//out.println(bill);
			//System.out.println(bill);
			BillingCycleDao billdao = new BillingCycleDao(DBCon.getConnection());
			boolean result= billdao.paybill(bill);   
			//System.out.println(result);
			
			if(result) {
				response.sendRedirect("payment_history.jsp");
			}
		} catch (Exception e) {
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
