package com.w3.Qa.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.w3.Qa.base.TestBase;

public class HandleMultipleWindows extends TestBase{
	
	@FindBy(id = "newWindowBtn")
	WebElement newWindow;
	
	@FindBy(id = "lastName")
	WebElement lastName;
	
	@FindBy(id = "femalerb")
	WebElement gender;
	
	@FindBy(id = "englishchbx")
	WebElement clickenglish;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	public HandleMultipleWindows() {
		PageFactory.initElements(driver, this);
	}
	public void handleMultipleWindow() {
		newWindow.click();
		String Parenthandle = driver.getWindowHandle();
		System.out.println("Parent window id" + ":" + Parenthandle);
		Set<String> multiplewindow = driver.getWindowHandles();
		for(String window : multiplewindow) {
			System.out.println(window);
		}
		
	}
	
	public void switchToChildWindow() throws InterruptedException {
		newWindow.click();
		String Parenthandle = driver.getWindowHandle();
		System.out.println("Parent window id" + ":" + Parenthandle);
		Set<String> multiplewindow = driver.getWindowHandles();
		for(String window : multiplewindow) {
			if(!(window.equals(Parenthandle)))
				driver.switchTo().window(window);
			System.out.println("Switched to parent window");
			    driver.manage().window().maximize();
			    //lastName.sendKeys("Kumar");
			    gender.click();
			    clickenglish.click();
			    email.sendKeys("abc@gmail.com");
			    password.sendKeys("addssd");
			   Thread.sleep(10);
		}
		driver.switchTo().window(Parenthandle);
	}

}
