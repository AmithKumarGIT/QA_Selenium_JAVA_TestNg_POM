package com.w3.Qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.w3.Qa.base.TestBase;

public class Trytesting_DropDown extends TestBase {
	
	@FindBy(xpath = "//select[@id = 'option']")
	WebElement dropdown;
	
	@FindBy(xpath = "//div[@class = 'information closable']/following-sibling::p/child::select")
	WebElement clickDropDown;
	
	@FindBy(xpath = "//div[@class = 'information closable']/following-sibling::p/child::select/child::option")
	List<WebElement> dropdownbootstrap;
	
	public Trytesting_DropDown() {
		PageFactory.initElements(driver, this);
	}
     
	public void selectdropdownElement(String value) {
		Select selectDropdown = new Select(dropdown);
		selectDropdown.selectByVisibleText(value);
	}
	
	public void selectallElementFromDropDown() throws InterruptedException {
		clickDropDown.click();
		Thread.sleep(5);
		System.out.println(dropdownbootstrap.size());
		for(WebElement ele : dropdownbootstrap) {
			if(ele.getText().equals("India")) {
				ele.click();
			System.out.println(ele.getText());
			};
			
		}
	}
}
	

