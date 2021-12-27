package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.connection.DBCon;
import com.admin.dao.BillingCycleDao;
import com.admin.model.BillingCycle;



/**
 * Servlet implementation class calculateBillServlet
 */
@WebServlet("/calculateBill")
public class calculateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculateBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			out.println("calulate bill is working");
			int userId = Integer.parseInt(request.getParameter("userid"));
			String name = request.getParameter("username");
			String address = request.getParameter("address");
			double unit =Double.parseDouble(request.getParameter("unit"));
			
			/*String date = request.getParameter("date");
			String duedate = request.getParameter("duedate");
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMMM-yyyy");
			String date1 = formatter.format(date);
			String duedate1 = formatter.format(duedate);*/
			
			String[] date = request.getParameterValues("date");
			String[] duedate = request.getParameterValues("duedate");
			SimpleDateFormat formatter=new SimpleDateFormat("yy-MM-dd");
			Date date1= formatter.parse(date[0]);
			Date duedate1 = formatter.parse(duedate[0]);
			
			 double amount;
			 amount =unit*24*9;
			 String status ="Not Paid";
			 
			 out.println(userId + " " + name + " "+ address+" "+ unit + " "+date1 +" "+duedate1 +" "+ amount + " " + status);
			 System.out.println(userId + " " + name + " "+ address+" "+ unit + " "+date1 +" "+duedate1 +" "+ amount + " " + status);
			 BillingCycle bill = new BillingCycle();
			 bill.setId(userId);
			 bill.setName(name);
			 bill.setAddress(address);
			 bill.setUnit(unit);
			 bill.setDate(formatter.format(date1));
			 bill.setDuedate(formatter.format(duedate1));
			 bill.setAmount(amount);
			 bill.setStatus(status);
			 
			 BillingCycleDao billdao = new BillingCycleDao(DBCon.getConnection());
			boolean result = billdao.insertbill(bill);
			System.out.println(result);
			if(result) {
				
				response.sendRedirect("billreport.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
}// end of doget
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
