package com.Chiller.Pom.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriverUtil {

	private static WebDriver driver;

	static {

		System.setProperty("webdriver.chrome.driver", "C:/Priya/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		SeleniumWebDriverUtil.driver = driver;
	}

}
