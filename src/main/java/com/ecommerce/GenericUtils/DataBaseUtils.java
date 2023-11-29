package com.ecommerce.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Connection con;
	/**
	 * This method is used to get connection with database
	 * @throws SQLException 
	 */
	public void connectDB() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(iPathConstants.DBURL, iPathConstants.DB_USERNAME, iPathConstants.dB_PASSWORD);
	}
	/**
	 * This method is used to execute select query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeSelectQuery(String query) throws SQLException {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		return result;
	}
	/**
	 * This method is used to execute non select query
	 * @param query
	 * @return 
	 * @throws SQLException 
	 */
	public void executeUpdate(String query, int expected) throws SQLException {
		Statement state = con.createStatement();
		int result = state.executeUpdate(query);
		if (expected==result) {
			System.out.println("Update is success");
		}
		else {
			System.out.println("Update failed");
		}
	}
	
	public void closeConnection() throws SQLException {
		con.close();
	}
}
