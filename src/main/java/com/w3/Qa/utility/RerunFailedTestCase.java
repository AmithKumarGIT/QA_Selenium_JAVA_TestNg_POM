package com.w3.Qa.utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.w3.Qa.base.TestBase;

public class RerunFailedTestCase extends TestBase implements IRetryAnalyzer {
	
	private int retrycount = Integer.parseInt(prop.getProperty("initialCount"));
	private static final int maxretryCount = Integer.parseInt(prop.getProperty("maxRetryCount"));
	
	@Override
	public boolean retry(ITestResult result) {
		if(retrycount < maxretryCount) {
			retrycount++;
			return true;
		}
		
		return false;
	}


}
