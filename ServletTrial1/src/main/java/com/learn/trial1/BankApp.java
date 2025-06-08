package com.learn.trial1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;


public  class BankApp extends DataConnection{

	
	
	@Override
	public void insert(String name, int AC_no, String Address, String type, double balance) {
	
		try {
			Connection con=DataConnection.getConection();
			String sql="INSERT INTO BANK(name,AC_number,Address,Type_of_AC,Balance)VALUES(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2,AC_no);
			ps.setString(3, Address);
			ps.setString(4, type);
			ps.setDouble(5, balance);
			
			ps.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Map<String, Object>> listacount() throws SQLException
	{
		List<Map<String, Object>> list=new ArrayList<>();

		Connection con=DriverManager.getConnection(URL,USER_N,PASS);
		String sql="select * from bank";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(sql);
		
		while(rs.next())
		{
			Map<String,Object> row= new HashMap<>();
			row.put("name", rs.getString("name"));
			row.put("AC_number", rs.getInt("AC_number"));
			row.put("Address", rs.getString("Address"));
			row.put("Type of AC", rs.getString("Type_of_AC"));
			row.put("Balance", rs.getInt("Balance"));
			list.add(row);
		}
		return list;
		
	}
	public Map<String, Object> perticularData(int ACno) throws SQLException, ClassNotFoundException
	{
		Map<String, Object> row=new HashMap<>();
		
		try {
		Connection con=DataConnection.getConection();
		String sql="select * from bank where AC_number = ?";
		PreparedStatement smt=con.prepareStatement(sql);
		smt.setInt(1, ACno);
		ResultSet rs=smt.executeQuery();
		
		
		if(rs.next())
		{
			row.put("name", rs.getString("name"));
			row.put("AC_number",rs.getInt("AC_number"));
			row.put("Address",  rs.getString("Address"));
			row.put("Type of AC",rs.getString("Type_of_AC"));
			row.put("Balance", rs.getInt("Balance"));
		}
		else if(!rs.next())
		{
			System.out.println("Invalid Input");
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new NumberFormatException(e.getMessage());
		}
	     return row;
	     
		
	}
	
}
