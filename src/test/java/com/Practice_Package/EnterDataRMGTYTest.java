package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class EnterDataRMGTYTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement state = con.createStatement();
		
		String query="Insert into Project values('TY_PROJ_199', 'Vijayalaxmi', '09/11/2023', 'ProjectTest4', 'Created',4);";
		
		int result = state.executeUpdate(query);
		
		if (result==1) {
			System.out.println("Data is added");
		}
		else {
			System.out.println("Data is not added");
		}
		con.close();
		
	}

}
