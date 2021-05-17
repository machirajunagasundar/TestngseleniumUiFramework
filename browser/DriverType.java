package com.optum.automation.coreframework.browser;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
/**
 * @author Manoj Sharma
 *
 */
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public enum DriverType implements DriverSetup {

	
	
    FIREFOX {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        	String geckoDriverPath=DriverType.class.getResource("/drivers/geckodriver.exe").getPath();			
			System.setProperty("webdriver.gecko.driver",geckoDriverPath);
        	FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            return new FirefoxDriver(options);
        }
    },
    CHROME {
    	public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
    	String resourcePath="/drivers/chromedriver.exe";
    	System.out.println(System.getProperties());
    	if(System.getProperty("os.name").toLowerCase().contains("mac"))
    	{
    	resourcePath="/drivers/chromedriver";
    	}
    	String chromeDriverPath=DriverType.class.getResource(resourcePath).getPath();
    	//Setting file executable Dynamically.
    	File f=new File(chromeDriverPath);
    	System.out.println("is Extecutable" + f.canExecute());
    	f.setExecutable(true);
    	System.setProperty("webdriver.chrome.driver",chromeDriverPath);
    	HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
    	chromePreferences.put("profile.password_manager_enabled", false);
    	ChromeOptions options = new ChromeOptions();
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    	options.merge(capabilities);
    	
    
    	options.setExperimentalOption("prefs", chromePreferences);
    	return new ChromeDriver(options);
    	}
    	},

    IE {
        public RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities) {
        	String ieDriverPath=DriverType.class.getResource("/drivers/IEDriverServer.exe").getPath();			
        		System.setProperty("webdriver.ie.driver",ieDriverPath);
        	InternetExplorerOptions options = new InternetExplorerOptions();
            options.merge(capabilities);
            options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //For slow Click problem added this.
            options.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
            //For send Keys Slowness
            options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            
            options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            
            
            return new InternetExplorerDriver(options);
        }
    }};
	