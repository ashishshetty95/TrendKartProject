package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		//register the database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		
		//create statement
		Statement state = con.createStatement();
		String query = "Insert into Student_info values('Pandya', '9371826497', 'Gujarat','29');";
		
		//Execute update query
		int result = state.executeUpdate(query);
		if (result==1) {
			System.out.println("Data is updated");
		}
		else {
			System.out.println("Data is not updated");
		}
		//Close database
		con.close();
	}

}
