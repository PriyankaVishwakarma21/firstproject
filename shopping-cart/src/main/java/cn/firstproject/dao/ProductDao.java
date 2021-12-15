package cn.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import cn.firstproject.model.Cart;
import cn.firstproject.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ProductDao(Connection con) {
		this.con = con;
	}
	
	public List<Product> getAllProducts(){
		List<Product> Products=new ArrayList<>();
		
		try {
			query="select * from products";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Product row=new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getInt("price"));
				row.setImage(rs.getString("image"));
				
				Products.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Products;
	}//end of getAllProducts
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products=new ArrayList<>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select * from products where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs=pst.executeQuery();
					while(rs.next()) {
						Cart row=new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getInt("price")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
				
			}
			
		}catch(Exception e) {
		System.out.println(e.getMessage());
		//e.printStackTrace();
		}
		return products;
	}
	
	
	//
	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		int sum=0;
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query="select price from products where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1,item.getId());
					rs=pst.executeQuery();
					
					while(rs.next()) {
						sum+=rs.getInt("price")*item.getQuantity();
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	
		return sum;
		
	}
	
	public Product getSingleProduct(int id) {
		Product row = null;
		try {
			query = "select * from products where id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				row = new Product();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getInt("price"));
				row.setImage(rs.getString("image"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
