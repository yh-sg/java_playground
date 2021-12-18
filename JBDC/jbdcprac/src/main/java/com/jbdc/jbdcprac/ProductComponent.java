package com.jbdc.jbdcprac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductComponent {

	public void tryConnection(double minPrice, double maxPrice) throws Exception{
		
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {

			String url = "jdbc:mysql://localhost:3306/classicmodels";
			String user = "root";
			String password = "12345678";
			
			connection = DriverManager.getConnection(url, user, password);
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery("SELECT * FROM products");
			preparedStatement = connection.prepareStatement("SELECT productName,quantityInStock,buyPrice FROM products WHERE buyPrice BETWEEN ? AND ?");
			
			preparedStatement.setDouble(1, minPrice);
			preparedStatement.setDouble(2, maxPrice);
			
			resultSet = preparedStatement.executeQuery();
						
			while(resultSet.next()) {
				//there are several resultSet methods like .first(), .last(), printAt(5) etc
				String name = resultSet.getString("productName");
				int quantity = resultSet.getInt("quantityInStock");
				double price = resultSet.getDouble("buyPrice");
				System.out.format("%-45s %5d %10.2f%n",name, quantity, price);
			}
			
		}catch(Exception e){
			ExceptionHandler.handleException(e);
		}finally {
			resultSet.close();
//			statement.close();
			preparedStatement.close();
			connection.close();
		}
		
	}
	
}
