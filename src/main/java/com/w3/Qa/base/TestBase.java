package com.w3.Qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.w3.Qa.utility.MyListener;
import com.w3.Qa.utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static WebDriverListener listener;
	public static WebDriver driver = null;
	public static String browsername = null;
	public static Properties prop;
	public static ExtentSparkReporter spartreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\w3\\Qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(String url) {
		if (driver == null) {
			if(prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browsername.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if (browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				}
		}
          listener = new MyListener();
          driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout,TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public static void initializeReport() {
		spartreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/extentreports/report.html");
		spartreporter.config().setDocumentTitle("Automation Report");
		spartreporter.config().setReportName("Automation Test execution report");
		spartreporter.config().setTheme(Theme.STANDARD);
		spartreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(spartreporter);
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		String FileSeparator = System.getProperty("file.separator");
		String Extent_report_path = "."+FileSeparator+"extentreports";
		String ScreenshotPath = Extent_report_path+FileSeparator+"screenshots";
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot"+Math.random()+".png";
		String screenshotpath = ScreenshotPath+FileSeparator+screenshotName;
		FileUtils.copyFile(src, new File(screenshotpath));
		return "."+FileSeparator+"screenshots"+FileSeparator+screenshotName;
		
	}
	
	public static void reportsDetails(String tag, String testCaseName) {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		test = extent.createTest(methodName, testCaseName);
		test.assignCategory(tag);
	}
	
	public static void printStatus(String testStatus,String infomessage ) {
		if(testStatus.equals("INFO")) {
		test.log(Status.INFO, infomessage);
		}
		
		if(testStatus.equals("FAIL")) {
		test.log(Status.FAIL, infomessage);
		}
		
		if(testStatus.equals("PASS")) {
		test.log(Status.PASS, infomessage);
		}
		if(testStatus.equals("SKIP")) {
		test.log(Status.SKIP, infomessage);
		}
		if(testStatus.equals("WARNING")) {
		test.log(Status.WARNING, infomessage);
		}
	}
	
	public static String capturescreenshot(WebDriver driver) throws IOException {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File("src/../screenshots/screenshot"+System.currentTimeMillis()+".png");
		String absolutepathlocation = destinationPath.getAbsolutePath();
		FileUtils.copyFile(srcfile, destinationPath);
		return absolutepathlocation;
	}
	
	public static void flushReport() {
	   extent.flush();
	}
	
	public static void teardown() {
		driver.quit();
		driver = null;
	}
	}


