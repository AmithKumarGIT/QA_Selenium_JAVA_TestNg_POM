package com.w3.Qa.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.w3.Qa.base.TestBase;

public class TakeScreenShot extends TestBase{
	
	public TakeScreenShot() {
		super();
	}
	
	public static String capturescreenshot(WebDriver driver) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File("src/../screenshots/screenshot"+System.currentTimeMillis()+".png");
		String absolutepathlocation = destinationPath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationPath);
		return absolutepathlocation;
	}

}
