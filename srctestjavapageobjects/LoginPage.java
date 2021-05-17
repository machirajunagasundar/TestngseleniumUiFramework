package com.optum.remoteSite.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.log4testng.Logger;


import com.optum.automation.coreframework.baseclasses.BasePageFunctions;
import com.optum.automation.coreframework.browser.Locator;
import com.optum.automation.coreframework.browser.LocatorType;
import com.optum.automation.coreframework.browser.PageFactory.Page;
import com.optum.automation.coreframework.utils.AutomationProfile;
import com.optum.remoteSite.databeans.RemoteSiteRequest;

@Page

public class LoginPage extends  BasePageFunctions {

	private static Logger logger = Logger.getLogger(LoginPage.class);
	
	Locator Username = new Locator(LocatorType.id,"username");
	Locator Password = new Locator(LocatorType.id,"password");
	Locator signInButton = new Locator(LocatorType.xpath,"//button[text()='Sign in']");
	Locator homeLink = new Locator (LocatorType.xpath,"//node()[text()='Home']");
		 
	public void performLogin()  {
	
		String title = driver.getTitle();

		if (title.equalsIgnoreCase("Please sign in")) {

			String un = AutomationProfile.getProfile().userName;
			String pwd = AutomationProfile.getProfile().password;

			if (!(Username.equalsIgnoreCase(""))) {
				enterText(Username, un);
				if (!(Password.equalsIgnoreCase(""))) {
					enterText(Password, pwd);
				}
				clickElement(signInButton);
			}
		} else {
			refreshPage();
		}
	
	}
}
	
	
	

//	public void performLogin(RemoteSiteRequest remoteSite) {
//		
//		if(!(remoteSite.username.equalsIgnoreCase(""))) {
//			enterText(Username, remoteSite.username);
//			
//			if(!remoteSite.password.equalsIgnoreCase("")) {
//				enterText(Password, remoteSite.password);
//			}
//			
//			clickElement(signInButton);
//			
//		}
//		
//	}
	
	



