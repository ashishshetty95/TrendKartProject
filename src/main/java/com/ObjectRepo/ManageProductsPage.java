package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductsPage {
	@FindBy(xpath="//select[contains(@name,'DataTables_Table')]")
	private WebElement showEntriesDD;
	
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTbx;
	
	public WebElement productName(WebDriver driver, String productName) {
		 WebElement name = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/descendant::td[text()='"+productName+"']"));
		 return name;
	}
	
	public void editProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+productName+"']/parent::tr/descendant::i[@class='icon-edit']")).click();
	}
	
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
	
	@FindBy(name="//label[text()='Product Image1']/following-sibling::div/child::a[text()='Change Image']")
	private WebElement changeImage1Link;
	
	@FindBy(id="productimage1")
	private WebElement productImage1UploadBtn;
	
	@FindBy(name="//label[text()='Product Image2']/following-sibling::div/child::a[text()='Change Image']")
	private WebElement changeImage2Link;
	
	@FindBy(id="productimage2")
	private WebElement productImage2UploadBtn;
	 
	@FindBy(name="//label[text()='Product Image3']/following-sibling::div/child::a[text()='Change Image']")
	private WebElement changeImage3Link;
	
	@FindBy(id="productimage3")
	private WebElement productImage3UploadBtn;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateImageBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement imageUpdateSuccessText;
	
	@FindBy(name="close")
	private WebElement closeImageUpdateSuccessText;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateproductBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement productUpdateSuccessText;
	
	@FindBy(name="close")
	private WebElement closeProductUpdateSuccessText;
	
	public void deleteProduct(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//tbody[@role='alert']/descendant::td[text()='"+productName+"']/parent::tr/descendant::i[@class='icon-remove-sign']")).click();
	}
	
	@FindBy(xpath="//div[@class='alert alert-error']")
	private WebElement productDeletedConfirmationText;
	
	@FindBy(name="close")
	private WebElement closeProductDeletedConfirmationText;
	
	public ManageProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getShowEntriesDD() {
		return showEntriesDD;
	}

	public WebElement getSearchTbx() {
		return searchTbx;
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

	public WebElement getChangeImage1Link() {
		return changeImage1Link;
	}

	public WebElement getProductImage1UploadBtn() {
		return productImage1UploadBtn;
	}

	public WebElement getChangeImage2Link() {
		return changeImage2Link;
	}

	public WebElement getProductImage2UploadBtn() {
		return productImage2UploadBtn;
	}

	public WebElement getChangeImage3Link() {
		return changeImage3Link;
	}

	public WebElement getProductImage3UploadBtn() {
		return productImage3UploadBtn;
	}

	public WebElement getUpdateImageBtn() {
		return updateImageBtn;
	}

	public WebElement getImageUpdateSuccessText() {
		return imageUpdateSuccessText;
	}

	public WebElement getCloseImageUpdateSuccessText() {
		return closeImageUpdateSuccessText;
	}

	public WebElement getUpdateproductBtn() {
		return updateproductBtn;
	}

	public WebElement getProductUpdateSuccessText() {
		return productUpdateSuccessText;
	}

	public WebElement getCloseProductUpdateSuccessText() {
		return closeProductUpdateSuccessText;
	}

	public WebElement getProductDeletedConfirmationText() {
		return productDeletedConfirmationText;
	}

	public WebElement getCloseProductDeletedConfirmationText() {
		return closeProductDeletedConfirmationText;
	}	
	
	public void productPresentConfirmation(String actProduct, String expProduct) {
		
	}
}