package com.optum.remoteSite.pageObjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.optum.apiautomation.util.DatabaseUtil;
import com.optum.automation.coreframework.baseclasses.BasePageFunctions;
import com.optum.automation.coreframework.browser.Locator;
import com.optum.automation.coreframework.browser.LocatorType;
import com.optum.automation.coreframework.browser.PageFactory.Page;
import com.optum.remoteSite.databeans.RemoteSiteRequest;

@Page

public class ShelfContainerPage extends BasePageFunctions{

	private static Logger logger = Logger.getLogger(ShelfContainerPage.class);
	
	 Locator selfcontent            = new Locator(LocatorType.xpath, "//h1[text()='Shelf Containers']");
	 Locator selfConatiner_tab= new Locator(LocatorType.xpath,"//span[text()='Shelf Container']");
	
	//Locator shelfContianer_table = new Locator(LocatorType.xpath,"//table[@role='grid']");
	Locator shelfContianer_table = new Locator(LocatorType.xpath,"//table[@class='containerconfig']");
	
	Locator configurator = new Locator(LocatorType.xpath,"//span[text()='Configurator']");


	
	public void validateAllocatedStatusInShelfContainerTable(RemoteSiteRequest remoteSite) {

		clickElement(configurator);
		waitForElementToAppear(selfConatiner_tab);
		clickElement(selfConatiner_tab);
		waitForElementToAppear(shelfContianer_table);
		waitsleep(4000);
		List<List<String>> ContainerList = tableAsLists(shelfContianer_table);
		int rows = ContainerList.size() - 1;
		String containerString = ContainerList.toString();
		List<HashMap<String, Object>> containerData = DatabaseUtil.getSelectResult("select * from containerconfig;");
		for (HashMap<String, Object> row : containerData) {
			if (row.toString().contains(remoteSite.mailRoute)) {
				assertEquals((row.get("allocatedStatus").equals("RESERVED")), true);
			}
		}
	}



	private int len(WebElement findElement) {
		// TODO Auto-generated method stub
		return 0;
	}
}