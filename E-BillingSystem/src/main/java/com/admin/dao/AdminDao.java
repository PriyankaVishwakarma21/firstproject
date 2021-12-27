package com.admin.dao;

import java.sql.*;

import com.admin.model.Admin;
import com.user.model.User;

public class AdminDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public AdminDao(Connection con) {
		this.con = con;
	}
	
	public Admin adminLogin(String email, String password) {
		Admin admin=null;
		try {
			query="select * from admin_login where email=? and password=?";
			pst=this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				admin=new Admin();
				admin.setId(rs.getInt("id"));//id is db coloumn name of admin_login tb
				admin.setName(rs.getString("name"));
				admin.setEmail(rs.getString("email"));
			}
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return admin;
	}
	
	//update user info by id
			public boolean updateuserinfo(User user){
				boolean result=false;
				try {
					query="update users set name=? , phoneno = ?, address=? where id=?";
					pst=this.con.prepareStatement(query);
					
					pst.setString(1, user.getName());
					pst.setString(2, user.getPhoneno());
					pst.setString(3, user.getAddress());
					pst.setInt(4, user.getId());
					pst.executeUpdate();
					result=true;
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return result;
			}
			//delete user by id
			public void deleteUser(int id) {
		try {
			query = "delete from users where id=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
