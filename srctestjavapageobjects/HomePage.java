package com.optum.remoteSite.pageObjects;

import com.optum.automation.coreframework.baseclasses.BasePageFunctions;
import com.optum.automation.coreframework.browser.Locator;
import com.optum.automation.coreframework.browser.LocatorType;
import com.optum.automation.coreframework.browser.PageFactory.Page;

@Page
public class HomePage extends BasePageFunctions {

	Locator home_link = new Locator(LocatorType.xpath, "//node()[text()='Home']");
	Locator configurator_link = new Locator(LocatorType.xpath, "//span[text()='Configurator']");
	Locator configureSite_link = new Locator(LocatorType.xpath, "//span[text()='Configure Site']");
	Locator circuit_order = new Locator(LocatorType.xpath, "//span[text()='Circuit Order']");
	Locator shelfContainer_btn = new Locator(LocatorType.xpath, "//span[text()='Shelf Container']");
	Locator allSites_btn = new Locator(LocatorType.xpath, "//span[text()='All Sites']");
	Locator nonClosedSites_btn = new Locator(LocatorType.xpath, "//span[text()='Not Closed Sites']");
	Locator nslanwan_supportedSites_btn = new Locator(LocatorType.xpath, "//span[text()='nslanwan Supported Sites']");
	Locator nslanwan_closedSites_btn = new Locator(LocatorType.xpath, "//span[text()='nslanwan Closed Sites']");
	Locator BotTitle = new Locator(LocatorType.xpath, "//div[@class='block']");

	public void clickhomeLink() {
		waitsleep(2000);
		clickElement(home_link);
		waitsleep(8000);
	}

	public void clickConfigsiteLink() {
		waitForElementToAppear(configureSite_link);
		clickElement(configureSite_link);
		waitsleep(3000);
		
	}

	public void clickCircuitorderLink(){
		waitForElementToAppear(circuit_order);
		clickElement(circuit_order);
		waitsleep(5000);
	}
	
	public void clickshelfContainerLink() {
		clickElement(shelfContainer_btn);
		waitForPageToLoad();
	}

	public void clickClosedSites() {
		waitForElementToAppear(nslanwan_closedSites_btn);
		clickElement(nslanwan_closedSites_btn);
		waitForPageToLoad();
	}

	
	public void clickConfiguratorlink() {
		waitForElementToAppear(configurator_link);
		clickElement(configurator_link);
		waitsleep(3000);
	}

}
