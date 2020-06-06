package com.hpi.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseReader {
	
	public Connection con;
	public Statement stmt;
	public  static String hostUrl="jdbc:mysql://gssprintosdev.ccqkizlpkrzs.us-west-2.rds.amazonaws.com:3306/enablementservice?zeroDateTimeBehavior=convertToNull";
	public  static String username="test";
	public  static String password="Sutk@123";
	public  static String driverName="com.mysql.jdbc.Driver";
	
	
	
	public  Connection getConnection() throws ClassNotFoundException, SQLException
	{
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(hostUrl, username, password);
			if(con!=null){
				System.out.println("Connected to database....");
			}
			con.createStatement();
			
		} catch (Exception e) {
			System.out.println("Driver not found" +e);
		}
		System.out.println("Returning the Conection Object....");
		return con;
	}
	
/*	public ResultSet getData(String query) throws ClassNotFoundException, SQLException{
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}*/
}
