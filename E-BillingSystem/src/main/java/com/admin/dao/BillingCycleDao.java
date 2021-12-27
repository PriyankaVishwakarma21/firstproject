package com.admin.dao;

import java.sql.*;
import java.util.*;

import com.admin.model.BillingCycle;

public class BillingCycleDao {
	private static Connection  con;
	private static PreparedStatement pst;
	private static String query;
	private static ResultSet rs;
	
	
	public BillingCycleDao(Connection con) {
		this.con=con;
	}
	
	public boolean insertbill(BillingCycle bill) {
		boolean result = false;
		try {
			query = "insert into bill (id,userid,username,address,unit,date,duedate,amount,status) values(?,?,?,?,?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, bill.getBillId());
			pst.setInt(2, bill.getId());
			pst.setString(3, bill.getName());
			pst.setString(4, bill.getAddress());
			pst.setDouble(5, bill.getUnit());
			pst.setString(6, bill.getDate());
			pst.setString(7, bill.getDuedate());
			pst.setDouble(8, bill.getAmount());
			pst.setString(9, bill.getStatus());
			pst.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<BillingCycle> notPaidBills(){
		List<BillingCycle> list = new ArrayList<>();
		
		try {
			query="select * from ebillingsys.bill where status = 'Not Paid'";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				BillingCycle bill = new BillingCycle();
				bill.setBillId(rs.getInt("id"));
				bill.setId(rs.getInt("userid"));
				bill.setName(rs.getString("username"));
				bill.setAddress(rs.getString("address"));
				bill.setUnit(rs.getDouble("unit"));
				bill.setDate(rs.getString("date"));
				bill.setDuedate(rs.getString("duedate"));
				bill.setAmount(rs.getDouble("amount"));
				bill.setStatus(rs.getString("status"));
				list.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<BillingCycle> PaidBills(){
		List<BillingCycle> list = new ArrayList<>();
		
		try {
			query="select * from ebillingsys.bill where status = 'Paid'";
			pst=this.con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				BillingCycle bill = new BillingCycle();
				bill.setBillId(rs.getInt("id"));
				bill.setId(rs.getInt("userid"));
				bill.setName(rs.getString("username"));
				bill.setAddress(rs.getString("address"));
				bill.setUnit(rs.getDouble("unit"));
				bill.setDate(rs.getString("date"));
				bill.setDuedate(rs.getString("duedate"));
				bill.setAmount(rs.getDouble("amount"));
				bill.setStatus(rs.getString("status"));
				list.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<BillingCycle> notPaidBillbyUser(int id){
		List<BillingCycle> list = new ArrayList<>();
		
		try {
			query = "select * from ebillingsys.bill where userid = ? and status = 'Not Paid'";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				BillingCycle bill = new BillingCycle();
				bill.setBillId(rs.getInt("id"));
				bill.setId(rs.getInt("userid"));
				bill.setName(rs.getString("username"));
				bill.setAddress(rs.getString("address"));
				bill.setUnit(rs.getDouble("unit"));
				bill.setDate(rs.getString("date"));
				bill.setDuedate(rs.getString("duedate"));
				bill.setAmount(rs.getDouble("amount"));
				bill.setStatus(rs.getString("status"));
				list.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<BillingCycle> PaidBillbyUser(int id){
		List<BillingCycle> list = new ArrayList<>();
		
		try {
			query = "select * from ebillingsys.bill where userid = ? and status = 'Paid'";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				BillingCycle bill = new BillingCycle();
				bill.setBillId(rs.getInt("id"));
				bill.setId(rs.getInt("userid"));
				bill.setName(rs.getString("username"));
				bill.setAddress(rs.getString("address"));
				bill.setUnit(rs.getDouble("unit"));
				bill.setDate(rs.getString("date"));
				bill.setDuedate(rs.getString("duedate"));
				bill.setAmount(rs.getDouble("amount"));
				bill.setStatus(rs.getString("status"));
				list.add(bill);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean paybill(BillingCycle bill) {
		boolean result=false;
		try {
			query = "update bill set status ='Paid' where id=? and userid=?";
			pst=this.con.prepareStatement(query);
			pst.setInt(1, bill.getBillId());
			pst.setInt(2, bill.getId());
			pst.executeUpdate();
			result=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
