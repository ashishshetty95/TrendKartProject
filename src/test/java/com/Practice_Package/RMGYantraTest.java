package com.Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	public static void main(String[] args) throws InterruptedException, SQLException {
		WebDriver driver =new ChromeDriver();
		String projectName="ProjectTest4";
		int count=0;
		Thread.sleep(10000);
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Vijayalakshmi");
		WebElement dropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement state = con.createStatement();
		
		String query = "Select * from project;";
		ResultSet result = state.executeQuery(query);
		
		while (result.next()) {
			if (result.getString(4).equalsIgnoreCase(projectName)) {
				System.out.println("Project is added");
				count++;
				break;
			}
			
		}
		if (count==0) {
			System.out.println("Project is not added");
		}
		con.close();
	}

}
