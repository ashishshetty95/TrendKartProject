package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage {
	public WebElement productImage(WebDriver driver, String productName) {
		WebElement image = driver.findElement(By.xpath("//a[text()='"+productName+"']/ancestor::div[@class='product']/descendant::img"));
		return image;
	}
	
	public WebElement productName(WebDriver driver, String productName) {
		WebElement name=driver.findElement(By.xpath("//div[@class='product']/descendant::a[text()='"+productName+"']"));
		return name;
	}
	
	public WebElement productPrice(WebDriver driver, String productName) {
		WebElement price=driver.findElement(By.xpath("//a[text()='"+productName+"']/ancestor::div[@class='product']/descendant::span[@class='price']"));
		return price;
	}
	
	public WebElement addProductToCart(WebDriver driver, String productName) {
		WebElement addToCart=driver.findElement(By.xpath("//a[text()='"+productName+"']/ancestor::div[@class='product']/descendant::button[text()='Add to cart']"));
		return addToCart;
	}
	
	public WebElement addToWishlist(WebDriver driver, String productName) {
		WebElement addToWishlist=driver.findElement(By.xpath("//a[text()='"+productName+"']/ancestor::div[@class='product']/descendant::i[@class='icon fa fa-heart']"));
		return addToWishlist;
	}
	
	public WebElement subCategoryTab(WebDriver driver, String subCategoryName) {
		WebElement subCategoryTab=driver.findElement(By.xpath("//li[@class='dropdown menu-item']/descendant::a[contains(.,'"+subCategoryName+"')]"));
		return subCategoryTab;
	}
	
	public WebElement noProductFound(WebDriver driver) {
		WebElement text=driver.findElement(By.xpath("//div[@class='col-sm-6 col-md-4 wow fadeInUp animated']"));
		return text;
	}
	
	public WebElement categoryName(WebDriver driver, String categoryName) {
		WebElement name = driver.findElement(By.xpath("//tbody/descendant::td[text()='"+categoryName+"']"));
		return name;
	}
	
	@FindBy(xpath="(//div[@class='product'])[1]/descendant::h3[@class='name']/a")
	private WebElement firstProduct;
	
	@FindBy(xpath="//i[@class='icon-remove-sign']")
	private WebElement removeBtn;
	
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}
	
	public void productConfirmation(String actProduct, String expProduct) {
		boolean res=expProduct.equalsIgnoreCase(actProduct);
		Assert.assertTrue(res);
	}
	
}
