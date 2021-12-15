package cn.firstproject.dao;

import java.sql.*;
import java.util.*;



import cn.firstproject.connection.DBCon;
import cn.firstproject.model.*;

public class OrderDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
		boolean result= false;
		
		try {   
			query="insert into orders (o_id,p_id,u_id,o_quantity,o_date) values(?,?,?,?,?)";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, model.getOrderId());
			pst.setInt(2, model.getId());
			pst.setInt(3, model.getUid());
			pst.setInt(4, model.getQuantity());
			pst.setString(5, model.getDate());
			pst.executeUpdate();
			result=true;
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
		
	
	 public List<Order> userOrders(int id) {
	        List<Order> list = new ArrayList<>();
	        try {
	            query = "select * from orders where u_id=? order by orders.o_id desc";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            rs = pst.executeQuery();
	            while (rs.next()) {
	                Order order = new Order();
	                ProductDao productDao = new ProductDao(this.con);
	                int pId = rs.getInt("p_id");
	                Product product = productDao.getSingleProduct(pId);
	                order.setOrderId(rs.getInt("o_id"));
	                order.setId(pId);
	                order.setName(product.getName());
	                order.setCategory(product.getCategory());
	                order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
	                order.setQuantity(rs.getInt("o_quantity"));
	                order.setDate(rs.getString("o_date"));
	                list.add(order);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        return list;
	    }
	
	//which is responcible for cancel order
	public void cancelOrder(int id) {
		try {
			query = "delete from orders where o_id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
