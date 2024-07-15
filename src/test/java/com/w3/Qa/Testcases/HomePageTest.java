package com.w3.Qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.w3.Qa.base.TestBase;
import com.w3.Qa.pages.HomePage;
import com.w3.Qa.pages.LoginPage;
import com.w3.Qa.utility.TakeScreenShot;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTest() {
		super();
	}
    @BeforeTest()
	public void getAttacher(){
	TestBase.initializeReport();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initialization(prop.getProperty("url"));
		homepage = new HomePage();
		loginpage = new LoginPage();
		loginpage.clickLogin();
		loginpage.logintoapp(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void certificate() {
		TestBase.reportsDetails("smoke","verifyCertificate");
		TestBase.printStatus("INFO","Started verifying the certificate page");
		boolean bool =homepage.verifycertificate();
		Assert.assertTrue(bool);
		TestBase.printStatus("PASS","Certificate page verified successfully");
	}
	@Test
	public void w3logo() throws IOException {
		TestBase.reportsDetails("regression","verifyw3logo");
		boolean bool =homepage.verifw3logo();
		try {
		Assert.assertTrue(bool);
		TestBase.printStatus("PASS","w3logo verified successfully");
		}
		catch (AssertionError e){
			e.printStackTrace();
			TestBase.printStatus("FAIL", "W3 logo verification failed: " + e.getMessage());
		}
		
	}
	@Test(dependsOnMethods = "certificate")
	public void table() {
		TestBase.reportsDetails("sanity","verifyTable");
		boolean bool =homepage.verifytable();
		Assert.assertTrue(bool);
		TestBase.printStatus("WARNING","Table verified successfully");
	}
	
	@Test()
	public void verifyAssert1() throws IOException {
		TestBase.reportsDetails("sanity","verifyAssert1");
		try {
			Assert.assertTrue(false);
		}
		catch (AssertionError e) {
			e.printStackTrace();
			TestBase.printStatus("FAIL", "Assertion Failed: " + e.getMessage());
			TakeScreenShot.capturescreenshot(driver);
			Assert.fail();
	
		}
	}
	
	@Test()
	public void verifyAssert2() throws IOException {
		TestBase.reportsDetails("sanity","verifyAssert2");
		Assert.assertEquals(1, 2);
		TestBase.printStatus("INFO","Started Verifying");
		TakeScreenShot.capturescreenshot(driver);
	}
	
    @AfterMethod
    public void tearDown() {
    	TestBase.teardown();
    }
    
    @AfterTest()
    public void afterTestCleanup() {
    	TestBase.flushReport();
    }

}
