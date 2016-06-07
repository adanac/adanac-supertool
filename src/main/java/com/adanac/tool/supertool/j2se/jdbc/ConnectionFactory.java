package com.adanac.tool.supertool.j2se.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * Connect to DataBase
 * Created by allen
 */
public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://192.168.2.144:3306/demo";
	public static final String USER = "root";
	public static final String PASS = "";

	/**
	 * Get a connection to database
	 * @return Connection object
	 */
	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}

	/**
	 * Test Connection
	 */
	public static void main(String[] args) {
		Connection connection = ConnectionFactory.getConnection();
	}
}
