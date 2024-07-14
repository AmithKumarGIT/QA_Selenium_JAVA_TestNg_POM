package com.w3.Qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w3.Qa.base.TestBase;
import com.w3.Qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initialization(prop.getProperty("url"));
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void clickLogin() {
		loginPage.clickLogin();
	}
	@Test(priority = -1)
	public void logintoapp() {
		loginPage.clickLogin();
		loginPage.logintoapp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
    @AfterMethod
    public void tearDown() {
    	TestBase.teardown();
    }
}
