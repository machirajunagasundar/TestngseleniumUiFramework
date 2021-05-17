package com.optum.remoteSite.testclasses;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.optum.apiautomation.util.DatabaseUtil;
import com.optum.automation.coreframework.baseclasses.BaseUITestCase;
import com.optum.automation.coreframework.utils.Log;
import com.optum.remoteSite.databeans.CircuitOrder;
import com.optum.remoteSite.databeans.RemoteSiteRequest;
import com.optum.remoteSite.pageObjects.ConfiguratorPage;
import com.optum.remoteSite.pageObjects.HomePage;
import com.optum.remoteSite.pageObjects.LoginPage;
import com.optum.remoteSite.testDataProviders.CircuitOrderDataProvider;
import com.optum.remoteSite.testDataProviders.RemoteSiteRequestDataProvider;


public class CircuitOrderTest extends BaseUITestCase {
	
	private ConfiguratorPage configPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Test(priority = 1,

			dataProvider = "VerifyCircuitOrderCreation", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify the creation of Circuit Order")
			public void testCircuitOrderCreation(CircuitOrder cirord) throws InterruptedException {

				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);

				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.clickNewOrderButton();
				configPage.enterBasicRequestDetails(cirord);
				configPage.enterCircuitInformationDetails(cirord);
				configPage.enterOrderStatusDetails(cirord);
				configPage.enterRequestNotesDetails(cirord);
				configPage.clickCreateOrderButton(cirord);
				configPage.verifythecircuitordervalidationmessage(cirord);
				Log.endTestCase();

			}	
	
	@Test(priority = 2,
			
			dataProvider = "VerifyAuditTable", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify the existance of AuditTable")
			public void testCircuitOrderAuditTable(CircuitOrder cirord) throws InterruptedException {
		
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.globalSearch(cirord);
				configPage.clickOnRequiredOrderNumber(cirord);
				configPage.verificationOfAuditTableExistance();
				Log.endTestCase();
		
			}
	
	@Test(priority = 3,
			
			dataProvider = "VerifyColumnwithDropdownElements", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify dropdown elements matching with column names")
			public void testdropdownelementswithcolumnnames(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.existingColumnsClearance(cirord);
				configPage.selectionOfRequiredColumn(cirord);
				configPage.dropdownElementsComparissionWithTableColumnsCount();
				Log.endTestCase();
				
			}
	
	@Test(priority = 4,
			
			dataProvider = "VerifyGlobalSearchFunctionality", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify Global Search functionality")
			public void testverificationofGlobalSearchFunctionality(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.globalSearch(cirord);
				configPage.dataValidationInCircuitOrderTable(cirord);
				Log.endTestCase();
				
			}
	
	@Test(priority = 5,
			
			dataProvider = "VerifyNormalSearchFunctionality", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify Normal Search functionality")
			public void testverificationofNormalSearchFunctionality(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.normalSearch(cirord);
				configPage.dataValidationInCircuitOrderTable(cirord);
				Log.endTestCase();
				
			}
	
	@Test(priority = 6,
			
			dataProvider = "UploadCarrierStatusSpreadsheet", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify Upload Carrier functionality")
			public void testUploadfunctionalityForCarrierStatusSpreadsheet(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickUploadCarrierSpreadsheet();
				configPage.selectFileTypeTobeUpload(cirord);
				configPage.uploadFileattachment(cirord);
				configPage.verificationOfFileUpload(cirord);
				Log.endTestCase();				
			}
	
	@Test(priority = 7,
			
			dataProvider = "VerifyFieldlevelValidation", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify Field Level Validation")
			public void testFieldLevelValidation(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.clickNewOrderButton();
				configPage.enterBasicRequestDetails(cirord);
				configPage.enterCircuitInformationDetails(cirord);
				configPage.enterOrderStatusDetails(cirord);
				configPage.enterRequestNotesDetails(cirord);
				configPage.clickCreateOrderButton(cirord);
				configPage.verificationOfFieldlevelValidation(cirord);
				Log.endTestCase();	
			}	
	
	@Test(priority = 8,
			
			dataProvider = "VerifyTheRequestCategory", dataProviderClass = CircuitOrderDataProvider.class, description = "Verify The Existence Of Request category")
			public void testTheexistanceofRequestCategory(CircuitOrder cirord) throws InterruptedException {
			
				test = extent.createTest(cirord.testDescription);
				Log.startTestCase("Starting Test Case " + cirord.testCaseID + ":" + cirord.testDescription);
				
				loginPage.performLogin();
				homePage.clickCircuitorderLink();
				configPage.clickOrderDashboard();
				configPage.verifytherequestType(cirord);				
				Log.endTestCase();	
			}	
	
	
	
}