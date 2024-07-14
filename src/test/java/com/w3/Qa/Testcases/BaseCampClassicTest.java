package com.w3.Qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w3.Qa.base.TestBase;
import com.w3.Qa.pages.BasecampClassic;
import com.w3.Qa.utility.TestUtil;

public class BaseCampClassicTest extends TestBase {
	
	BasecampClassic basecampclassic;
	String sheetname = "Registration";
	
	public BaseCampClassicTest() {
		super();
	}
     
	@BeforeMethod()
	public void setup() {
		TestBase.initialization(prop.getProperty("urlbasecampclassic"));
		basecampclassic = new BasecampClassic();
	}
	
	@Test(dataProvider = "getRegistrationData")
	public void doregistration(String firstname, String lastname, String email,String company, String username,String password, String confirmpassword) {
		
		if(firstname.equalsIgnoreCase("Amit4")) {
		basecampclassic.enterRegistrationDetails(firstname,lastname,email,company,username,password,confirmpassword);
		}
	}
	
	@DataProvider
	public Object[][] getRegistrationData() {
		Object[][] registrationData = TestUtil.getTestData(sheetname);
		return registrationData;
	}
	
	
	@AfterMethod()
	public void tearDown() {
		TestBase.teardown();
	}
}
