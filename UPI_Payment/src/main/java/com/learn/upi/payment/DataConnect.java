package com.learn.upi.payment;

import java.sql.*;

public class DataConnect {


	public static void transaction(String reciever, int amount, int balance) 
	{
		try {
	        Connection con = DatabaseConnection.getConection();
	        String sql = QueryLoad.getProperty("insertProperties");
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, reciever);
	        ps.setInt(2, amount);
	        ps.setInt(3, balance);

	        ps.executeUpdate();
	        System.out.println("Transaction successful for " + reciever);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
			
	}
	public static ResultSet getTransactionHistory()
	{
		ResultSet rs=null;
		try {
			Connection con=DatabaseConnection.getConection();
			String sql1=QueryLoad.getProperty("getPaymentHistory");
			Statement smt=con.createStatement();
			rs=smt.executeQuery(sql1);
			
			while(rs.next())
			{
				System.out.println("Id : "+rs.getInt("id")+",   Reciever name : "+rs.getString("reciever_name")+",   Amount sent : "+rs.getInt("Amount_sent")+",   Balance : "+rs.getInt("balance"));
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return rs;
		
	}

}
