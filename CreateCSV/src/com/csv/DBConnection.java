package com.csv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static void main(String[] args) {
		DBConnection dbConnection=new DBConnection();
		System.out.println(dbConnection.getConnection());
	}
	
	public Connection getConnection() {
		Connection connection=null;
		System.out.println("Started");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/adapttech","root","root");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
