package com.Chiller.Pom.WebPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Chiller.Pom.Utilities.PageObject;

public class SignUpPage extends PageObject{
//	By addItem = By.xpath("//input[.='Add Item']");
    By firstName=By.id("firstname");
    By lastName=By.id("lastname");
	By address=By.id("address");
	By zpcode=By.id("zipcode");
	By submit=By.id("signup");
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		
	}

	public void enterName(String frstName, String secndName) {
	WebElement fstName=	driver.findElement(firstName);
	fstName.clear();
	fstName.sendKeys(frstName);
	
	WebElement lstName =	driver.findElement(lastName);
	lstName.clear();
	lstName.sendKeys(secndName);
		
	}

	public void enterAddress(String adrs) {
		WebElement adr=	driver.findElement(address);
		adr.clear();
		adr.sendKeys(adrs);
		
	}

	public void enterZipcode(String zipcode) {
		WebElement zip=	driver.findElement(zpcode);
		zip.clear();
		zip.sendKeys(zipcode);
	}

	public ReceiptPage clickSubmit() {
		driver.findElement(submit).click();
		return new ReceiptPage(driver);
	}

	public boolean isInitialized() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		

		// get the "Add Item" element
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(firstName));

		return element.isDisplayed();
	}

}
