package com.user.dao;

import java.sql.*;
import java.util.*;
import com.admin.model.Admin;
import com.admin.model.BillingCycle;
import com.user.model.User;

public class UserDao {
		private static Connection  con;
		private static PreparedStatement pst;
		private static String query;
		private static ResultSet rs;
		
		public  UserDao(Connection con) {
			this.con = con;
		}
	//register user
		public boolean register(User user) {
			boolean result=false;
			try {		
				query="insert into users (id,name,email,phoneno,address,password) values (?,?,?,?,?,?);";
				pst = this.con.prepareStatement(query);
				pst.setInt(1,user.getId());
				pst.setString(2, user.getName());
				pst.setString(3, user.getEmail());
				pst.setString(4, user.getPhoneno());
				pst.setString(5, user.getAddress());
				pst.setString(6, user.getPassword());
				pst.executeUpdate();
				result=true;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//user login
		public User userLogin(String email, String password) {
			User user=null;
			try {
				query="select * from users where email=? and password=?";
				pst=this.con.prepareStatement(query);
				pst.setString(1, email);
				pst.setString(2, password);
				rs=pst.executeQuery();
				
				if(rs.next()) {
					user=new User();
					user.setId(rs.getInt("id"));//id is db coloumn name of admin_login tb
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
				}
					
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			return user;
		}
		
		//all users
		public  List<User> selectAllUser() {
			List<User> list=new ArrayList<>();
			
			try {
				query="select * from users";
				pst=con.prepareStatement(query);
				//pst.setInt(1, id);
				rs=pst.executeQuery();
				
				while(rs.next()) {
					User user=new User();
					 user.setId(rs.getInt("id")); 
					 user.setName(rs.getString("name"));
					 user.setEmail(rs.getString("email"));
					 user.setPhoneno(rs.getString("phoneno"));
					 user.setAddress(rs.getString("address"));
		
					list.add(user);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		//get user info by id
		public User userInfoById(int id) {
			User u=null;
			try {
				query="select * from users where id = ?";
				pst = this.con.prepareStatement(query);
				pst.setInt(1, id);
				rs=pst.executeQuery();
				
				while(rs.next()) {
					u = new User();
					u.setId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneno(rs.getString(4));
					u.setAddress(rs.getString(5));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return u;
		}
		
		//get user info by email,password
		public User fetchUserInfoByEmailPass(String email,String password) {
			User u=null;
			try {
				query = "select * from users where email = ? and password = ?";
				pst = this.con.prepareStatement(query);
				pst.setString(1, email);
				pst.setString(2, password);
				rs = pst.executeQuery();
				while(rs.next()) {
					u = new User();
					u.setId(rs.getInt(1));
					u.setName(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setPhoneno(rs.getString(4));
					u.setAddress(rs.getString(5));
					u.setPassword(rs.getString(6));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return u;
		}
		
		
		
		
}
