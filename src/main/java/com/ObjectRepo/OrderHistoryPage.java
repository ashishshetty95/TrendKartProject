package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderHistoryPage {
	
	public String lastProductName(WebDriver driver) {
		String name=driver.findElement(By.xpath("(//h4[@class='cart-product-description'])[last()]/a")).getText();
		return name;
	}
	
	@FindBy(xpath="//table[@class='table table-bordered']/descendant::tr[last()]/descendant::a[@title='Track order']")
	private WebElement trackLastProduct;
	
	@FindBy(xpath="//head/title")
	private WebElement pageTitle;
	
	public OrderHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTrackLastProduct() {
		return trackLastProduct;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}
	
	public void compareProduct(String actName, String expName) {
		boolean res=actName.equalsIgnoreCase(expName);
		Assert.assertTrue(res);
	}
	
	public void compareTitle(String actTitle, String expTitle) {
		boolean res=actTitle.contains(expTitle);
		Assert.assertTrue(res);
	}
}
