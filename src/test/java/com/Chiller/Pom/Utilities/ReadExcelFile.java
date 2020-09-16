package com.Chiller.Pom.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Chiller.Pom.Model.FormSignUp;

public class ReadExcelFile 
{
	
	FormSignUp formSignUp;
	public List<FormSignUp> readExcel() throws IOException {
		
	
	List<FormSignUp> fSignUp = new ArrayList();
	File file=new File("C:/Priya/ExcelSignUpForm/SignUpFormData.xlsx");
	FileInputStream excelStream =new FileInputStream(file);
	XSSFWorkbook hssfWorkbook=new XSSFWorkbook(excelStream);
	XSSFSheet hssfSheet=hssfWorkbook.getSheetAt(0);
	
	for(int i=0;i<=hssfSheet.getLastRowNum();i++) {
		XSSFRow Row=hssfSheet.getRow(i);
		formSignUp=new FormSignUp();
		for(int j=Row.getFirstCellNum();j<Row.getLastCellNum();j++) {
			XSSFCell cell=Row.getCell(j);		
			switch (j) {
			case 0:
				formSignUp.setFirstName(cell.getStringCellValue());	
				break;
			case 1:
				formSignUp.setLastName(cell.getStringCellValue());	
				break;
			case 2:
				formSignUp.setAddress(cell.getStringCellValue());	
				break;
			case 3:
				formSignUp.setZipCode((int) cell.getNumericCellValue());	
				break;

			}
		}
		fSignUp.add(formSignUp);
	}
	System.out.println("First Na: "+fSignUp.size());
	Iterator<FormSignUp> fmSignUp = fSignUp.iterator();
	while(fmSignUp.hasNext()) {
		FormSignUp f = fmSignUp.next();
		
		System.out.println("First Na: "+f.getFirstName());
		System.out.println("First Na: "+f.getLastName());
		System.out.println("First Na: "+f.getAddress());
		System.out.println("First Na: "+f.getZipCode());
		System.out.println("********************************");
	}
	
	 excelStream.close();
	 return fSignUp;
	}
	
	public Object[][] convert1(List<FormSignUp> arrayList) {

		Object[][] array2D = new Object[arrayList.size()][];

		for (int i = 0; i < array2D.length; i++) {
			array2D[i] = new Object[] {arrayList.get(i)};
		}
 
		return array2D;
	}
}
