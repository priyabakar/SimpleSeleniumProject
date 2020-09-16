package com.Chiller.Pom.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Chiller.Pom.Utilities.ExtendReport;
import com.Chiller.Pom.Utilities.ScreenShot;
import com.Chiller.Pom.Utilities.SeleniumWebDriverUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class FunctionalTest {
	ExtentReports ExtndRpot; 
	ExtentTest extndTst;
	ScreenShot screenShot= new ScreenShot();
	protected static WebDriver driver;



	@BeforeClass
	public void setup() {
		driver = SeleniumWebDriverUtil.getDriver();		
	}


	@BeforeTest
	public void reportInit() {
		ExtendReport EXtndRpot = new ExtendReport();
		ExtndRpot = EXtndRpot.reportConfig();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@BeforeMethod
	public void register(Method method) {
		String methodName =method.getName();
		extndTst = ExtndRpot.createTest(methodName);
	}

	@AfterMethod 
	public void cleanUP(ITestResult result) { 
		//driver.manage().deleteAllCookies();

		if(ITestResult.FAILURE == result.getStatus()) {
			String path =screenShot.takeScreenShot(result.getName());
			extndTst.log(Status.FAIL,"Test Method Name: "+result.getName()+"is failed");
			try {
				extndTst.addScreenCaptureFromPath(path);				
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}else  if (ITestResult.SUCCESS == result.getStatus()) {
			extndTst.log(Status.PASS,"Test Method Name: "+result.getName()+"is passed");
		}else  if (ITestResult.SKIP == result.getStatus()) {
			extndTst.log(Status.SKIP,"Test Method Name: "+result.getName()+"is skipped");
		}
	}

	@AfterTest
	public void rptFlush() {
		ExtndRpot.flush();
	}


}
