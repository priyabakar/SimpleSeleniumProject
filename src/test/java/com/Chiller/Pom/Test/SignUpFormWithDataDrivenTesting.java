package com.Chiller.Pom.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Chiller.Pom.Model.FormSignUp;
import com.Chiller.Pom.Utilities.ReadExcelFile;
import com.Chiller.Pom.WebPage.ReceiptPage;
import com.Chiller.Pom.WebPage.SignUpPage;
import com.beust.jcommander.internal.Lists;

public class SignUpFormWithDataDrivenTesting extends FunctionalTest {

	private static final Logger log = LoggerFactory.getLogger(SignUpFormWithDataDrivenTesting.class);
	
	@Test(dataProvider = "testdata")
	public void signUpForm(FormSignUp fMSignUP) {

		log.info("signUpForm() - entering");
		log.debug("debug message");
		log.error("error msg");
		driver.get("https://www.kimschiller.com/page-object-pattern-tutorial/");

		SignUpPage signUpPage = new SignUpPage(driver);
		assertTrue(signUpPage.isInitialized());
		signUpPage.enterName(fMSignUP.getFirstName(), fMSignUP.getLastName());
		signUpPage.enterAddress(fMSignUP.getAddress());
		signUpPage.enterZipcode(Integer.toString(fMSignUP.getZipCode()));
		/*
		 * signUpPage.enterName("Priya","Bakar");
		 * signUpPage.enterAddress("1234 rohul street");
		 * signUpPage.enterZipcode("12333");
		 */
		ReceiptPage receiptPage = signUpPage.clickSubmit();

		assertTrue(receiptPage.isInitialized());
		assertEquals("Thank you!", receiptPage.ConfirmationHeader());

	}

	@DataProvider(name = "testdataWORKING")
	public Object[][] testDataExampleWorking() {

		return new Object[][] { { new FormSignUp("FN", "LN", "ADDR", 30044) } };
	}

	@DataProvider(name = "testdata")
	public Object[][] testDataExample() {
		Object[][] obj = null;
		ReadExcelFile rdExcel = new ReadExcelFile();
		// List<FormSignUp> fmSignUp;
		try {
			List<FormSignUp> fmSignUp = rdExcel.readExcel();
			obj = convert1(fmSignUp);
			log.info("testDataExample() - ExceldataList converted to Object");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("testDataExample IOException");
		}
		// return null;
		return obj;
	}

	public Object[] convert(List<FormSignUp> lists) {
		Object[] array = lists.toArray();
		return array;
	}

	public Object[][] convert1prev(List<FormSignUp> lists1) {

		return new Object[][] { lists1.toArray() };
	}

	public Object[][] convert1(List<FormSignUp> arrayList) {

		Object[][] array2D = new Object[arrayList.size()][];

		for (int i = 0; i < array2D.length; i++) {
			array2D[i] = new Object[] {arrayList.get(i)};
		}
 
		return array2D;
	}

	// Object[][] bj=new Object[lists.size()][];
	/*
	 * for (int i = 0; i < array.length; i++) { array[i] = new
	 * Object[lists.get(i).size()]; lists.get(i).toArray(array[i]); }
	 */

}
