package com.Chiller.Pom.Model;

public class FormSignUp {
	
	private String FirstName;
	private String LastName;
	private String Address;
	private int ZipCode;
	
	public FormSignUp(){
		
	}	
	
	public FormSignUp(String firstName, String lastName, String address, int zipCode) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		ZipCode = zipCode;
	}
	
	@Override
	public String toString() {
		return "FormSignUp [FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address + ", ZipCode="
				+ ZipCode + "]";
	}

	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	
	
}
