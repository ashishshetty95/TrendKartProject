package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class DataBaseEntryTest {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.nextLine();
		Random r=new Random();
		int age=r.nextInt(100);
		boolean flag=false;
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement state = con.createStatement();
		String query="Select name from employee;";
		ResultSet result = state.executeQuery(query);
		
		int size=result.getFetchSize();
		System.out.println(size);
		
		int i=1;
		while (result.next()) {
			if (result.getString(i).equalsIgnoreCase(name)) {
				flag=true;
				System.out.println("Name already present");
				break;
			}
			else if (i<=size) {
				i++;
			}
		}
		if (flag==false) {
				state.executeUpdate("Insert into employee values('"+name+"',"+age+");");
		}
		System.out.println(size);
		String Output="Select * from employee;";
		ResultSet finalres = state.executeQuery(Output);
		while (finalres.next()) {
			System.out.println(finalres.getString(1)+"   "+finalres.getString(2));
		}
		
	}

}
