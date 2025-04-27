package com.learn.upi.payment;

import java.sql.*;

public  class DatabaseConnection {

	private static final String URL=QueryLoad.getProperty("url");
	private static final String USER_N=QueryLoad.getProperty("username");
	private static final String PASS=QueryLoad.getProperty("password");
	
	
	public static Connection getConection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    return   DriverManager.getConnection(URL,USER_N,PASS);
	}

}
