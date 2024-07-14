package com.w3.Qa.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener implements WebDriverListener {
	
	public void afterClick(WebElement element) {
		System.out.println("Clicking on an Element : "+ element);
	}
	
	public void afterQuit(WebDriver driver) {
		System.out.println("Test Execution Completed");
	}
	
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Typing in an element : "+ element+ "and value as" + keysToSend);
	}
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("About to enter value in an element : "+ element+ "and value as" + keysToSend);
		
	}
	
	public void afterGet(WebDriver driver, String url) {
		System.out.println("Navigated To : "+ url);
	}


}
