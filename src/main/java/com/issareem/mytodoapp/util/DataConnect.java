package com.issareem.mytodoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * 
 * @author Reem Issa
 * @class_name DataConnect.java
 * @class_description
 * @create_date Aug 28, 2023
 */
public class DataConnect {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my_todos_db", "postgres",
					"postgres");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->" + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}