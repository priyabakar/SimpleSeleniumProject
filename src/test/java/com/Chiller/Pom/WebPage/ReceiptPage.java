package com.Chiller.Pom.WebPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Chiller.Pom.Utilities.PageObject;

public class ReceiptPage extends PageObject {
	By ThnxDisplay = By.xpath("//h1");

	public ReceiptPage(WebDriver driver) {
		super(driver);

	}


	public boolean isInitialized() { 
		return driver.findElement(ThnxDisplay).isDisplayed();

	}


	public String ConfirmationHeader() {

		return driver.findElement(ThnxDisplay).getText();
	}




}
