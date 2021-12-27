package com.admin.connection;
import java.sql.*;
public class DBCon {
	private static Connection con=null;
	
	public static Connection getConnection()throws ClassNotFoundException, SQLException {
		if(con==null) {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebillingsys","root","priyanka");
			System.out.println("connected");
		}
		return con;
		//Class.forName("com.mysql.jdbc.Driver");
		//return DriverManager.getConnection("jdbc:mysql://localhost:3306/ebillingsys","root","priyanka");
	}
}
