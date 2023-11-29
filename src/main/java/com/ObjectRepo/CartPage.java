package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public void removeProductFromCart(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[text()='"+productName+"']/ancestor::tr/descendant::input[@type='checkbox']"));
	}
	
	public void increaseQuantityBtn(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[text()='"+productName+"']/ancestor::tr/descendant::div[@class='arrow plus gradient']"));
	}
	
	public void decreaseQuantityBtn(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[text()='"+productName+"']/ancestor::tr/descendant::div[@class='arrow minus gradient']"));
	}
	
	public void grandTotalOfProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[text()='"+productName+"']/ancestor::tr/descendant::span[@class='cart-grand-total-price']"));
	}
	
	@FindBy(xpath="//a[text()='Continue Shopping']")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath="//input[@value='Update shopping cart']")
	private WebElement updateShoppingCartBtn;
	
	@FindBy(name="billingaddress")
	private WebElement billingAddressTbx;
	
	@FindBy(id="bilingstate")
	private WebElement billingStateTbx;
	
	@FindBy(id="billingcity")
	private WebElement billingCityTbx;
	
	@FindBy(id="billingpincode")
	private WebElement billingPinCodeTbx;
	
	@FindBy(name="update")
	private WebElement updateBillingAddressBtn;
	
	@FindBy(name="shippingaddress")
	private WebElement shippingAddressTbx;
	
	@FindBy(id="shippingstate")
	private WebElement shippingStateTbx;
	
	@FindBy(id="shippingcity")
	private WebElement shippingCityTbx;
	
	@FindBy(id="shippingpincode")
	private WebElement shippingPinCodeTbx;
	
	@FindBy(name="shipupdate")
	private WebElement updateShippingAddressBtn;
	
	@FindBy(xpath="//span[@class='inner-left-md']")
	private WebElement grandTotalTxt;
	
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckOutBtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public WebElement getUpdateShoppingCartBtn() {
		return updateShoppingCartBtn;
	}

	public WebElement getBillingAddressTbx() {
		return billingAddressTbx;
	}

	public WebElement getBillingStateTbx() {
		return billingStateTbx;
	}

	public WebElement getBillingCityTbx() {
		return billingCityTbx;
	}

	public WebElement getBillingPinCodeTbx() {
		return billingPinCodeTbx;
	}

	public WebElement getUpdateBillingAddressBtn() {
		return updateBillingAddressBtn;
	}

	public WebElement getShippingAddressTbx() {
		return shippingAddressTbx;
	}

	public WebElement getShippingStateTbx() {
		return shippingStateTbx;
	}

	public WebElement getShippingCityTbx() {
		return shippingCityTbx;
	}

	public WebElement getShippingPinCodeTbx() {
		return shippingPinCodeTbx;
	}

	public WebElement getUpdateShippingAddressBtn() {
		return updateShippingAddressBtn;
	}

	public WebElement getGrandTotalTxt() {
		return grandTotalTxt;
	}

	public WebElement getProceedToCheckOutBtn() {
		return proceedToCheckOutBtn;
	}
	
}
