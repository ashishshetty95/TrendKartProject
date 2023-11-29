package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage {
	@FindBy(xpath="//select[contains(@name,'DataTables_Table')]")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTbx;
	
	public String checkUserEmail(WebDriver driver) {
		String text=driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[3]")).getText();
		return text;
	}
	
	public ManageUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
	}
	
	
}
