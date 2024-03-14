package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private static String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static String USER = "root";
	private static String PASS = "Nghia456";
	
	public static final Connection getConection() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			return conn;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
