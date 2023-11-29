package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTryCatchTest {
	
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int result=0;
		try {
			//Register with database
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Create connection with database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","root");
			
			//Create statement
			Statement state = con.createStatement();
			String query="insert into Student_info values('Jadeja','9514789632','Chennai',33);";
			
			//Execute Update query
			result = state.executeUpdate(query);
			
			if (result==1) {
				System.out.println("Data updated succesfully");
			}
			else {
				System.out.println("Data not updated");
			}
		} catch (Exception e) {
			
		}
		finally {
			//Close connection
			con.close();
		}
		
		
		
	}

}
