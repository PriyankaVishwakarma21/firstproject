package cn.firstproject.connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static Connection con=null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(con==null) {
			Class.forName("com.mysql.jdbc.Driver");
		  con =	DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","root","priyanka");
			System.out.println("connected");
		}
		return con;
	}
}
