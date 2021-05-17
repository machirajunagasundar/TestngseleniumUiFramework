package com.optum.automation.coreframework.browser;
/**
 * @author Manoj Sharma
 *
 */
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.optum.automation.coreframework.browser.DriverType.valueOf;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.optum.automation.coreframework.utils.AutomationProfile;


public class DriverFactory {
	 private static Logger logger = Logger.getLogger(DriverFactory.class.getName()); 
	private static WebDriver webDriver;
	private static DriverType selectedBrowser;
	private final static boolean useRemoteWebDriver = Boolean.parseBoolean(AutomationProfile.getProfile().runOnGrid);

	private DriverFactory() {
		
	}

	public static WebDriver getDriver() {
		if (null == webDriver) {
			DriverType driverType = null;
			String browser = AutomationProfile.getProfile().browser;
			try {
				driverType = valueOf(browser.toUpperCase());
			} catch (IllegalArgumentException ignored) {
				logger.error("Unknown driver specified");
			} catch (NullPointerException ignored) {
				logger.error("No driver specified");
			}
			selectedBrowser = driverType;
			try {
				instantiateWebDriver(selectedBrowser);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return webDriver;
	}


	public static void quitDriver() {
		if (null != webDriver) {
			webDriver.quit();
			webDriver = null;
		}
	}

	/*
	private static void instantiateWebDriver(DriverType driverType) throws MalformedURLException {
		
		logger.info("Selected Browser: " + selectedBrowser);
		logger.info("Connecting to Selenium Grid: " + useRemoteWebDriver);
		

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		if (useRemoteWebDriver) {
			
			URL seleniumGridURL = new URL(AutomationProfile.getProfile().hubURL);
			String desiredBrowserVersion = AutomationProfile.getProfile().desiredBrowserVersion;
			String desiredPlatform = AutomationProfile.getProfile().desiredPlatform;

			if (null != desiredPlatform && !desiredPlatform.isEmpty()) {
				desiredCapabilities.setPlatform(Platform.valueOf(desiredPlatform.toUpperCase()));
			}

			if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {
				desiredCapabilities.setVersion(desiredBrowserVersion);
			}

			desiredCapabilities.setBrowserName(selectedBrowser.toString());
			webDriver = new RemoteWebDriver(seleniumGridURL, desiredCapabilities);
		} 
		else {
			
			webDriver = driverType.getWebDriverObject(desiredCapabilities);
		}
	}
	
	*/
	
	private static void instantiateWebDriver(DriverType driverType) throws MalformedURLException {

		 

		 logger.info("Selected Browser: " + selectedBrowser);

		 logger.info("Connecting to Selenium Grid: " + useRemoteWebDriver);
		 
	

		 String hub = "https://" + "sso-optum-vengopal_vemula1" + ":" + "003b01d4-1dcb-4859-8e43dc-0d6d106bf6f7" + "@ondemand.us-west-1.saucelabs.com/wd/hub";


		 

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		 

		 if (useRemoteWebDriver) {

		 

		 

		 URL seleniumGridURL = new URL(hub);

		String desiredBrowserVersion = AutomationProfile.getProfile().desiredBrowserVersion;

		String desiredPlatform = AutomationProfile.getProfile().desiredPlatform;
		
	
		ChromeOptions options = new ChromeOptions();
	
		options.addEncodedExtensions("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\n" + 
					"");
	
		
		//desiredCapabilities.setCapability("goog:chromeOptions", chromeOpts);
		
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		desiredCapabilities.setCapability("commandTimeout", 300);

		desiredCapabilities.setCapability("idleTimeout", 90);

		 desiredCapabilities.setCapability("screenResolution", "1600x1200");

		 desiredCapabilities.setCapability("tunnelIdentifier", "Optum-Stage");

		desiredCapabilities.setCapability("parent-tunnel", "optumtest");

		 //desiredCapabilities.setCapability("tunnelIdentifier", "sso-optum-venugopal_vemula1_tunnel_id");

		// desiredCapabilities.setCapability("parent-tunnel", "sso-optum-venugopal_vemula1");

		 

		 if (null != desiredPlatform && !desiredPlatform.isEmpty()) {

		desiredCapabilities.setPlatform(Platform.valueOf(desiredPlatform.toUpperCase()));

		}


		 

		 if (null != desiredBrowserVersion && !desiredBrowserVersion.isEmpty()) {

		 desiredCapabilities.setVersion(desiredBrowserVersion);

		}


		 

		desiredCapabilities.setBrowserName(selectedBrowser.toString());

		 

		 webDriver = new RemoteWebDriver(seleniumGridURL, desiredCapabilities);

		} 

		else {

		 

		 webDriver = driverType.getWebDriverObject(desiredCapabilities);

		}

		}
}
