package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	@FindBy(xpath="//h1[@class='name']")
	private WebElement productNameTxt;
	
	@FindBy(xpath="//div[@class='product-info']/descendant::span[@class='price']")
	private WebElement productPrice;
	
	@FindBy(xpath="//a[@data-original-title='Wishlist']")
	private WebElement addProductToWishlistBtn;
	
	@FindBy(xpath="//div[@class='arrow plus gradient']")
	private WebElement increaseQuantityBtn;
	
	@FindBy(xpath="//div[@class='arrow minus gradient']")
	private WebElement decreaseQuantityBtn;
	
	@FindBy(xpath="//a[.=' ADD TO CART']")
	private WebElement addToCartBtn;
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameTxt() {
		return productNameTxt;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getAddProductToWishlistBtn() {
		return addProductToWishlistBtn;
	}

	public WebElement getIncreaseQuantityBtn() {
		return increaseQuantityBtn;
	}

	public WebElement getDecreaseQuantityBtn() {
		return decreaseQuantityBtn;
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
}
