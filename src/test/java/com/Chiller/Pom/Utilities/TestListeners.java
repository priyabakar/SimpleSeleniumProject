package com.Chiller.Pom.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.Chiller.Pom.Test.SignUpFormTest;

public class TestListeners implements ITestListener {
	
	// ScreenShot screenShot= new ScreenShot();
	public void onTestStart(ITestResult result) {
		System.out.println("Started:"+result.getMethod().getMethodName());
		
	}

	
	  public void onTestSuccess(ITestResult result) {
	  System.out.println("Test Passed Successfully:"+result.getMethod().
	  getMethodName());
	  
	  }
	  
	  public void onTestFailure(ITestResult result) {
	  System.out.println("Test Failed:"+result.getMethod().getMethodName());
	  if(result.getStatus()==ITestResult.FAILURE) {
		//  screenShot.takeScreenShot(result.getName());
	  }
	  
	  }
	 

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped :"+result.getMethod().getMethodName());
		
	}

	
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
		  //	  TODO Auto-generated method stub
	  
	  }
	  
	  public void onStart(ITestContext context) { 
		  // TODO Auto-generated method stub
	  
	  }
	  
	  public void onFinish(ITestContext context) {
		  // TODO Auto-generated method	  stub
	  
	  }
	 
}
