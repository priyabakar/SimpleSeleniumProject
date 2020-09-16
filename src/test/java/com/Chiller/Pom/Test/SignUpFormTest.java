package com.Chiller.Pom.Test;

import static org.testng.Assert.assertEquals;
import java.sql.Connection;
import java.util.List;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Chiller.Pom.Model.FormSignUp;
import com.Chiller.Pom.Utilities.DatabaseConnect;
import com.Chiller.Pom.Utilities.ReadExcelFile;
import com.Chiller.Pom.WebPage.ReceiptPage;
import com.Chiller.Pom.WebPage.SignUpPage;

@Listeners(com.Chiller.Pom.Utilities.TestListeners.class)
public class SignUpFormTest extends FunctionalTest{

	@Test
	public void signUpForm(){
		
	driver.get("https://www.kimschiller.com/page-object-pattern-tutorial/");
	
	SignUpPage signUpPage=new SignUpPage(driver);	
	assertTrue(signUpPage.isInitialized());
	signUpPage.enterName("Priya","Bakar");
	signUpPage.enterAddress("1234 rohul street");
	signUpPage.enterZipcode("12333");
	ReceiptPage receiptPage=signUpPage.clickSubmit();
	
	
	assertTrue(receiptPage.isInitialized());
	assertEquals("Thank you", receiptPage.ConfirmationHeader());
	
	}
	
	@Test(dataProvider = "dbdata")
	public void signUpFormWithDB(FormSignUp frmSignUp){
		
		driver.get("https://www.kimschiller.com/page-object-pattern-tutorial/");
		
		SignUpPage signUpPage=new SignUpPage(driver);	
		assertTrue(signUpPage.isInitialized());
		signUpPage.enterName(frmSignUp.getFirstName(),frmSignUp.getLastName());
		signUpPage.enterAddress(frmSignUp.getAddress());
		signUpPage.enterZipcode(Integer.toString(frmSignUp.getZipCode()));
		ReceiptPage receiptPage=signUpPage.clickSubmit();
		
		
		assertTrue(receiptPage.isInitialized());
		assertEquals("Thank you!", receiptPage.ConfirmationHeader());
		
		}
	
	@DataProvider(name="dbdata")
	public Object[][] dataBaseTest() {
		Object[][] obj=null;
		ReadExcelFile rdExcel = new ReadExcelFile();
		Connection cont=DatabaseConnect.getFormSignupData();
		List<FormSignUp> frmdata= DatabaseConnect.getFormData(cont);
		obj=rdExcel.convert1(frmdata);
		
		frmdata.iterator();
		for(FormSignUp fsu: frmdata) {
		System.out.println("Firstname: "+fsu.getFirstName());
		System.out.println("last name: "+fsu.getLastName());
		System.out.println("address: "+fsu.getAddress());
		System.out.println("zipcode: "+fsu.getZipCode());
		System.out.println("********************************");
		}
		
        return obj;
	}
	
	
	@Test
	public void robotClass() {
		driver.get("https://www.usaupload.com/");
		driver.findElement(By.xpath("//*[@id=\"initialUploadSection\"]/div[1]/div[1]/h2")).click();
		
		
		try {
			Robot robot=new Robot();
			StringSelection ss=new StringSelection("C:\\test.txt");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
		   } catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
