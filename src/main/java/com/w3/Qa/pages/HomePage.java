package com.w3.Qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3.Qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id = "navbtn_certified")
	WebElement certificate;
	@FindBy(xpath = "//span[@class = 'color_h1']")
	WebElement table;
	@FindBy(xpath = "//i[@class = 'fa fa-logo ws-hover-text-green']")
	WebElement w3logo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
     
	public boolean verifycertificate() {
		return certificate.isEnabled();
	}
	
	public boolean verifytable() {
		return table.isDisplayed();
	}
	
	public boolean verifw3logo() {
		return table.isDisplayed();
	}
}
