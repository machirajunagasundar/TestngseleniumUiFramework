package com.optum.remoteSite.testclasses;

import static org.testng.Assert.assertEquals;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.optum.apiautomation.util.DatabaseUtil;
import com.optum.automation.coreframework.baseclasses.BaseUITestCase;
import com.optum.automation.coreframework.utils.Log;
import com.optum.remoteSite.databeans.RemoteSiteRequest;
import com.optum.remoteSite.pageObjects.ConfiguratorPage;
import com.optum.remoteSite.pageObjects.HomePage;
import com.optum.remoteSite.pageObjects.LoginPage;
import com.optum.remoteSite.pageObjects.ShelfContainerPage;
import com.optum.remoteSite.testDataProviders.RemoteSiteRequestDataProvider;

public class RemotesiteRequestTest extends BaseUITestCase {

	private ConfiguratorPage configPage;
	private ShelfContainerPage shelfPage;
	private HomePage homePage;
	private LoginPage loginPage;

	@Test(priority = 1,

	dataProvider = "InvalidObjectExistanceVerification", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
	public void testInvalidObjectexistanceVerification(RemoteSiteRequest remoteSite)throws InterruptedException, IOException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.verifyClosedStatusSiteCodes(remoteSite);
		configPage.verifyinvalidobjectexistance(remoteSite);
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

	@Test(priority = 2,

	dataProvider = "VerifySubnetsCreationwithoutselectingSiteType", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
	public void testSelectSiteTypeValidationForSubnets(RemoteSiteRequest remoteSite)throws InterruptedException, IOException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.subnets_toggling(remoteSite);
		configPage.verifySiteSelectionValidation();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

	@Test(priority = 3,

			dataProvider = "Containersclearance", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
	public void clearingTheContainers(RemoteSiteRequest remoteSite) throws InterruptedException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		configPage.subnetsClearance(remoteSite);
		configPage.automationReqClearance(remoteSite);
		configPage.shelfContainerupdation(remoteSite);
		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.verifyBuildsiteButtonenabled();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();
	}
	
	
	@Test(priority = 4,

	dataProvider = "VerifyContainersAvailability", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest subnet Creation")
	public void testContainersAvailability(RemoteSiteRequest remoteSite) throws InterruptedException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.validateRemotesiteChangeTicketMessage(remoteSite);
		Log.endTestCase();

	}

	

	@Test(priority = 5,

	dataProvider = "CreatesOnlySubnets", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest subnet Creation")
	public void testSubnetCreation(RemoteSiteRequest remoteSite) throws InterruptedException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.subnets_toggling(remoteSite);
		configPage.clickOnBuildSite();
		configPage.waittillSubnetCreation(remoteSite);
		configPage.selectNoOfRecordsFromDropDown(remoteSite);
		configPage.verifySubnetsCreationForAnysiteType(remoteSite);
		configPage.verifyBuildsiteButtonDisabled();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

	
//	 @Test(priority = 4,
//	
//	 dataProvider =	 "VerifySubnetsCreationwhenConatinerisEmpty",dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
//	 public void testSubnetsCreationwhenConatinerisEmpty(RemoteSiteRequest
//	 remoteSite)
//	 throws InterruptedException, IOException {
//	
//	 // check site codes of no projects.
//	 test = extent.createTest(remoteSite.testDescription);
//	 Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" +
//	 remoteSite.testDescription);
//	
//	 loginPage.performLogin();
//	 homePage.clickConfiguratorlink();
//	 homePage.clickConfigsiteLink();
//	 configPage.validateconfigureSite(remoteSite);
//	 configPage.clickInfoClosebutton();
//	 configPage.clickSettingButton();
//	 configPage.clickonReqProjectFromDropDown(remoteSite);
//	 configPage.expandSiteDetails();
//	 Thread.sleep(5000);
//	 configPage.verifySitesize(remoteSite);
//	 configPage.subnets_toggling(remoteSite);
//	 // configPage.clickOnBuildSite();
//	 // configPage.verifyEmptySubnetContainerMessage(remoteSite);
//	 configPage.verifyContainerEmptiness(remoteSite);
//	 configPage.clickSettingCloseIcon();
//	 Log.endTestCase();
//	 }

	@Test(priority = 6,

	dataProvider = "CreateSubnetsWithDHCP", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
	public void testDHCPCreationforSizeP(RemoteSiteRequest remoteSite) throws InterruptedException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.switchtoDHCPTab();
		configPage.waittillSubnetCreation(remoteSite);
		configPage.verifyDhcpHostCreation(remoteSite);
		configPage.verifyBuildsiteButtonDisabled();
		configPage.verifyDHCPButtonDisabled();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

	@Test(priority = 7,

	dataProvider = "CreateSubnetsWithDNS", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of RemoteSiteRequest")
	public void testDNSCreation(RemoteSiteRequest remoteSite) throws InterruptedException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.switchtoDNSTab();
		configPage.waittillSubnetCreation(remoteSite);
		configPage.verifyDnsHostCreation(remoteSite);
		configPage.verifyBuildsiteButtonDisabled();
		configPage.verifyDNSButtonDisabled();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

		
	
	@Test(priority = 8,

	dataProvider = "VerifyDecomNotificationMessage", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of DecomSiteRequest")
	public void testDecomnotificationMessageVerification(RemoteSiteRequest remoteSite)
			throws InterruptedException, IOException {

		// check build site is disabled for closed sites.
		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);

		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		homePage.clickConfigsiteLink();
		configPage.validateconfigureSite(remoteSite);
		configPage.clickInfoClosebutton();
		configPage.clickSettingButton();
		configPage.clickonReqProjectFromDropDown(remoteSite);
		configPage.expandSiteDetails();
		configPage.verifySitesize(remoteSite);
		configPage.captureandsubmitChangeTicket();
		configPage.verifyDecomSiteConfigExhistanceandClick();
		configPage.verifyDecomNotification();
		configPage.clickSettingCloseIcon();
		Log.endTestCase();

	}

	@Test(priority = 9,

	dataProvider = "VerifyAllocatedStatusAfterDecom", dataProviderClass = RemoteSiteRequestDataProvider.class, description = "Verification of DecomSiteRequest")
	public void testDecomAllocatedStatusafterDecommission(RemoteSiteRequest remoteSite)
			throws InterruptedException, IOException {

		test = extent.createTest(remoteSite.testDescription);
		Log.startTestCase("Starting Test Case " + remoteSite.testCaseID + ":" + remoteSite.testDescription);
		loginPage.performLogin();
		homePage.clickConfiguratorlink();
		shelfPage.validateAllocatedStatusInShelfContainerTable(remoteSite);
	}

}