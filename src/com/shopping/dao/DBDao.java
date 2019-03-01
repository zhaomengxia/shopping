package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBDao {

	private static String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "root";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// System.out.println("no");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("ok==");
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			// System.out.println("no---");
			e.printStackTrace();
		}
		return conn;
	}

}
