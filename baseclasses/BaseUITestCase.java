package com.optum.automation.coreframework.baseclasses;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
/**
 * @author Manoj Sharma
 *
 */
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.IInvokedMethod;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.optum.automation.coreframework.browser.DriverFactory;
import com.optum.automation.coreframework.browser.PageFactory;
import com.optum.automation.coreframework.browser.PageFactory.Page;
import com.optum.automation.coreframework.utils.AutomationProfile;
import com.optum.automation.coreframework.utils.Log;
import com.optum.automation.coreframework.utils.ScreenCapture;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.markuputils.ExtentColor;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public abstract class BaseUITestCase {

	@SuppressWarnings("unused")
	private static Logger	logger					= Logger.getLogger(BaseUITestCase.class);
	private String				outputDirTestNG	= null;
	public static String	testClassName		= null;
	public String	browserURL	= null;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	WebDriver			driver			= null;
	String				applicationURL;
    String loginId;
    String loginPassword;
    
	      
	@BeforeSuite(alwaysRun = true)
	public void startup() {
	AutomationProfile.createProfile();
		
	}

	@BeforeTest 
	public void extentReportSetup() {
		//location of the extent report
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")  +"/test-output/"+"/BotReports/"+  dateName + "BotTestReport.html");
		htmlReporter.config().setDocumentTitle("BOT Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Bot Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
		
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);
		// General information releated to application
		extent.setSystemInfo("Application Name", "Build Orchestration tool");
		extent.setSystemInfo("Envirnoment", "Stage");
	}
	
		


	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
			
		if(result.getStatus() == ITestResult.FAILURE)			
			
		{
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 

			//	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			//String screenshotPath = TakeFullScreenshot(driver, result.getName());
			String screenshotPath = TakeScreenshot(driver, result.getName());
			//To add it in the extent report 

			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));


		}
		else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
			 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
			//String screenshotPath = TakeFullScreenshot(driver, result.getName());
			String screenshotPath = TakeScreenshot(driver, result.getName());
			test.pass("Test Case Passed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		}
		
		//driver.quit();
		
		extent.flush();
//		DriverFactory.quitDriver();
	}
	
	
	@AfterSuite
	public void terminateBrowser() throws Exception
	{
		DriverFactory.quitDriver();
	}
	
	

	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollWidth)");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	

	public static String TakeFullScreenshot(WebDriver driver, String screenshotName) throws IOException, AWTException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//Screenshot ts=new AShot().takeScreenshot(driver);
		Robot r = new Robot(); 
		Rectangle capture =  
	            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
	            BufferedImage Image = r.createScreenCapture(capture); 
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getImage(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		//File finalDestination = new File(destination);
	
		
		
		ImageIO.write(Image,"PNG",new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png"));
		//FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	@BeforeClass(alwaysRun = true)
	
	public void loadPageObjects() {		
		
		
		
		applicationURL = AutomationProfile.getProfile().appUrl;
	
		testClassName = this.getClass().getName();
	
		driver = DriverFactory.getDriver();
		
		driver.manage().window().maximize();
		setTimeOutsForDriver();
		
		driver.get(applicationURL);
				
		BasePageFunctions.setDriver(driver);
		try {
			for (Field field : this.getClass().getDeclaredFields()) {
				if (field.getType().isAnnotationPresent(Page.class)) {
					if (!field.isAccessible()) {
						field.setAccessible(true);
					}
					field.set(this, PageFactory.newInstance(field.getType()));
				}
			}
		} catch (Exception e) {
			throw new Error("Error instantiating page object: " + e.getMessage());
		}

				
 	}
	
	private void setTimeOutsForDriver() {
		driver.manage().timeouts().implicitlyWait(Long.parseLong(AutomationProfile.getProfile().implicitWait), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(AutomationProfile.getProfile().pageLoadTimeout), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Long.parseLong(AutomationProfile.getProfile().scriptTimeout), TimeUnit.SECONDS);

	}
	
	
		
}