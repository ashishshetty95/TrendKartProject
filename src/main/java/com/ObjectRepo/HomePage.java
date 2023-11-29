package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[.='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[.='Wishlist']")
	private WebElement wishlistLink;
	
	@FindBy(xpath="//a[.='My Cart']")
	private WebElement myCartLink;
	
	@FindBy(xpath="//a[.='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath="//span[@class='key']")
	private WebElement trackOrderBtn;
	
	@FindBy(name="product")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='total-price-basket']")
	private WebElement cartBtn;
	
	public void clickOnCategoryFromTab(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//li[@class='dropdown yamm']/a[contains(.,'"+categoryName+"')]")).click();
	}
	
	public void clickOnCategoryFromList(WebDriver driver, String categoryName) {
		driver.findElement(By.xpath("//li[@class='dropdown menu-item']/descendant::a[contains(.,'"+categoryName+"')]")).click();
	}
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutLink;
	
	public List<WebElement> categoriesList(WebDriver driver) {
		List<WebElement> categories = driver.findElements(By.xpath("//nav[@class='yamm megamenu-horizontal']/descendant::a[@class='dropdown-toggle']"));
		return categories;
	}
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getTrackOrderBtn() {
		return trackOrderBtn;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
}
