package com.Chiller.Pom.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {
	
	ExtentReports extndRpot;
	ExtentTest extndTst;
	ExtentHtmlReporter extndHtmlRpot;
	
	public ExtentReports reportConfig() {
		extndHtmlRpot = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-output/extendReport.html"));
	//	extndHtmlRpot.loadXMLConfig(new File(System.getProperty("user.dir")+"/ExtendReport.xml"));
		extndHtmlRpot.config().setDocumentTitle("SignUpForm");
		extndHtmlRpot.config().setReportName("SignUpForm Report");
		extndHtmlRpot.config().setTheme(Theme.STANDARD);
		
		extndRpot=new ExtentReports();
		extndRpot.setSystemInfo("Environment", "QA");
		extndRpot.attachReporter(extndHtmlRpot);
		
		return extndRpot;
	}

}
