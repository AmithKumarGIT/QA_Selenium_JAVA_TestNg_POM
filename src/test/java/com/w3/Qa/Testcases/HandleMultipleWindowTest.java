package com.w3.Qa.Testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w3.Qa.base.TestBase;
import com.w3.Qa.pages.HandleMultipleWindows;
import com.w3.Qa.pages.Trytesting_DropDown;

public class HandleMultipleWindowTest extends TestBase{
	
	HandleMultipleWindows multipleWindow;
	
	public HandleMultipleWindowTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		TestBase.initialization(prop.getProperty("urlmultiplewindow"));
	}
	
	@Test(priority = 0)
	public void getMultipleWindow() throws InterruptedException {
		multipleWindow = new HandleMultipleWindows();
		multipleWindow.handleMultipleWindow();
		Thread.sleep(10);
	}
	
	@Test(priority = 1)
	public void switchtoChildWindow() throws InterruptedException {
		multipleWindow = new HandleMultipleWindows();
		multipleWindow.switchToChildWindow();
		Thread.sleep(10);
	}
    @AfterMethod
    public void tearDown() {
    	TestBase.teardown();
    }
}
