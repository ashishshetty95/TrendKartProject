package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InsertProductPage {
	@FindBy(name="category")
	private WebElement categoryDD;
	
	 @FindBy(id="subcategory")
	 private WebElement subCategoryDD;
	 
	 @FindBy(name="productName")
	 private WebElement productNameTbx;
	 
	 @FindBy(name="productCompany")
	 private WebElement productCompanyTbx;
	 
	 @FindBy(name="productpricebd")
	 private WebElement priceBeforeDiscount;
	 
	 @FindBy(name="productprice")
	 private WebElement priceAfterDiscount;
	 
	 @FindBy(name="productDescription")
	 private WebElement productDescription;
	 
	 @FindBy(name="productShippingcharge")
	 private WebElement productShippingCharge;
	 
	 @FindBy(id="productAvailability")
	 private WebElement productAvailabilityDD;
	 
	 @FindBy(id="productimage1")
	 private WebElement productImage1UploadBtn;
	 
	 @FindBy(name="productimage2")
	 private WebElement productImage2UploadBtn;
	 
	 @FindBy(name="productimage3")
	 private WebElement productImage3UploadBtn;
	 
	 @FindBy(name="submit")
	 private WebElement insertProductBtn;
	 
	 @FindBy(xpath="//div[@class='alert alert-success']")
	 private WebElement productInsertedSuccessText;
	
     @FindBy(name="close")
	 private WebElement closeProductInsertedSuccessText;
	 
	 public InsertProductPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }

	public WebElement getCategoryDD() {
		return categoryDD;
	}

	public WebElement getSubCategoryDD() {
		return subCategoryDD;
	}

	public WebElement getProductNameTbx() {
		return productNameTbx;
	}

	public WebElement getProductCompanyTbx() {
		return productCompanyTbx;
	}

	public WebElement getPriceBeforeDiscount() {
		return priceBeforeDiscount;
	}

	public WebElement getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public WebElement getProductDescription() {
		return productDescription;
	}

	public WebElement getProductShippingCharge() {
		return productShippingCharge;
	}

	public WebElement getProductAvailabilityDD() {
		return productAvailabilityDD;
	}

	public WebElement getProductImage1UploadBtn() {
		return productImage1UploadBtn;
	}

	public WebElement getProductImage2UploadBtn() {
		return productImage2UploadBtn;
	}

	public WebElement getProductImage3UploadBtn() {
		return productImage3UploadBtn;
	}

	public WebElement getInsertProductBtn() {
		return insertProductBtn;
	}
	 
	public void insertProductBtn() {
		insertProductBtn.click();
	}

	public WebElement getProductInsertedSuccessText() {
		return productInsertedSuccessText;
	}

	public WebElement getCloseProductInsertedSuccessText() {
		return closeProductInsertedSuccessText;
	} 
	public void productInsertedConfirmation(String aText) {
		boolean res=productInsertedSuccessText.getText().contains(aText);
		Assert.assertTrue(res);
	}
}
