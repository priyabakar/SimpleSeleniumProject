package com.Chiller.Pom.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Chiller.Pom.Test.FunctionalTest;
import com.Chiller.Pom.Test.SignUpFormTest;

public class ScreenShot {
  
	
	public ScreenShot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String takeScreenShot(String name) {
		String path = "C:/Users/priya/eclipse-workspace/SimpleSeleniumProject/Screenshot/"+name+".png"; 
		//File destinationFile=new File("./Screenshot/"+name+".png");
		File destinationFile=new File(path);
		File file=((TakesScreenshot)SeleniumWebDriverUtil.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;

	}	

}
