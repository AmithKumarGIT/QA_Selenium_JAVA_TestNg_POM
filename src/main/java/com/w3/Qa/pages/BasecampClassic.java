package com.w3.Qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w3.Qa.base.TestBase;

public class BasecampClassic extends TestBase {
	
	@FindBy(id = "signup_first_name")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(id = "signup_last_name")
	WebElement LastName;

	@FindBy(id = "signup_email_address")
	WebElement Email;

	@FindBy(id = "signup_company_name")
	WebElement Company;

	@FindBy(id = "signup_username")
	WebElement UserName;
	
	@FindBy(id = "signup_password")
	WebElement Password;

	@FindBy(id = "signup_password_confirmation")
	WebElement ConfirmPassWord;
	
	public BasecampClassic() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterRegistrationDetails(String firstName,String lastName,String email,String company,String username,String password,String confirmpassword) {
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		Email.sendKeys(email);
		Company.sendKeys(company);
		UserName.sendKeys(username);
		Password.sendKeys(password);
		ConfirmPassWord.sendKeys(confirmpassword);
		
	}
	/*
	 * public void enterLastName(String lastName) {
	 * 
	 * LastName.sendKeys(lastName);
	 * 
	 * } public void email(String email) { Email.sendKeys(email);
	 * 
	 * } public void Company(String company) {
	 * 
	 * Company.sendKeys(company);
	 * 
	 * } public void UserName(String username) {
	 * 
	 * UserName.sendKeys(username);
	 * 
	 * } public void password(String password) { Password.sendKeys(password);
	 * 
	 * } public void ConfirmPassword(String confirmpassword) {
	 * ConfirmPassWord.sendKeys(confirmpassword);
	 * 
	 * }
	 */
}
