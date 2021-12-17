package com.jbdc.jbdcprac;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductComponent {

	public boolean tryConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		boolean isConnected = connection.isValid(2);
		
		connection.close();
		
		return isConnected;
	}
	
}
