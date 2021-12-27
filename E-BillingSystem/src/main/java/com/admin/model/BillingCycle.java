package com.admin.model;

import java.util.Arrays;
import java.util.Date;

import com.user.model.User;

public class BillingCycle extends User {
	private int billId;
	private double unit;
	private String date;
	private String duedate;
	private double amount;
	private String status;
	
	
	public BillingCycle() {
		super();
	}


	public BillingCycle(int billId, double unit, String date, String duedate, double amount, String status) {
		super();
		this.billId = billId;
		this.unit = unit;
		this.date = date;
		this.duedate = duedate;
		this.amount = amount;
		this.status = status;
	}


	public BillingCycle(double unit, String date, String duedate, double amount, String status) {
		super();
		this.unit = unit;
		this.date = date;
		this.duedate = duedate;
		this.amount = amount;
		this.status = status;
	}


	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public double getUnit() {
		return unit;
	}


	public void setUnit(double unit) {
		this.unit = unit;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date1) {
		this.date = date1;
	}


	public String getDuedate() {
		return duedate;
	}


	public void setDuedate(String date2) {
		this.duedate = date2;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	


	
	
	
	
	
	
	
}
