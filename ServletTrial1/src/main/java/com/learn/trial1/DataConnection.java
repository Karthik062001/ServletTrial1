package com.learn.trial1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DataConnection implements Bank {

	protected static final String URL="jdbc:mysql://localhost:3306/Task";
	protected static final String USER_N="root";
	protected static final String PASS="Karthi@123";
	
	
	public static Connection getConection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection(URL,USER_N,PASS);
		return con;
	    
	}
}
