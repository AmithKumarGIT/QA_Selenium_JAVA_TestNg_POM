package com.w3.Qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3.Qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//a[@class = 'user-anonymous tnb-login-btn w3-bar-item w3-btn bar-item-hover w3-right ws-light-green ga-top ga-top-login']")
	WebElement login;
	
	@FindBy(name = "email")
	WebElement username;
   
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class ='CustomButton_button__V5-G+ LoginForm_login_button__B4Ksc CustomButton_primary__ZDr5g']")
	WebElement submit;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void logintoapp(String enterusername, String enterpassword) {
		username.sendKeys(enterusername);
		password.sendKeys(enterpassword);
		submit.click();
	}

}
