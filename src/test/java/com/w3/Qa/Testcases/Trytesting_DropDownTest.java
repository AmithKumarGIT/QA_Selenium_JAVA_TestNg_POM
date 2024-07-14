package com.w3.Qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w3.Qa.base.TestBase;
import com.w3.Qa.pages.LoginPage;
import com.w3.Qa.pages.Trytesting_DropDown;

public class Trytesting_DropDownTest extends TestBase{
	
	Trytesting_DropDown dropdown;
	
	public Trytesting_DropDownTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		TestBase.initialization(prop.getProperty("urlbootstrap"));
	}
	
	@Test(priority = 1)
	public void selectelementfromdropdown() throws InterruptedException {
		dropdown = new Trytesting_DropDown();
		dropdown.selectdropdownElement("Option 2");
		Thread.sleep(10);
	}
	@Test
	public void printAllElement() throws InterruptedException {
		dropdown = new Trytesting_DropDown();
		dropdown.selectallElementFromDropDown();
		Thread.sleep(10);
	}
	
    @AfterMethod
    public void tearDown() {
    	TestBase.teardown();
    }
}
