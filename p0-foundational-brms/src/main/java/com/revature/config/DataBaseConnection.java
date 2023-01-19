package com.revature.config;

import java.sql.*;
import java.util.ResourceBundle;

public class DataBaseConnection {
	private static Connection connection =null;
	
	public static Connection getConnection(){
		if(connection == null) {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
			String dburl = resourceBundle.getString("dburl");
			String username = resourceBundle.getString("username");
			String password = resourceBundle.getString("password");
			try {
				Class.forName(resourceBundle.getString("driver"));
				connection = DriverManager.getConnection(dburl,username,password);
			}
			catch(ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
				
			}
		}
		
		return connection;
	}
}
