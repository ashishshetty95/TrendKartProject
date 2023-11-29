package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingBillingAddressPage {
	@FindBy(xpath="//a[@data-toggle='collapse' and contains(.,'Billing Address')]")
	private WebElement billingAddressTab;
	
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
	
	@FindBy(xpath="//a[@data-toggle='collapse' and contains(.,'Shipping Address')]")
	private WebElement shippingAddressTab;
	
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
	
	public ShippingBillingAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBillingAddressTab() {
		return billingAddressTab;
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

	public WebElement getShippingAddressTab() {
		return shippingAddressTab;
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
}
