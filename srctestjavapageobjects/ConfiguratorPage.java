package com.optum.remoteSite.pageObjects;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlTest;

import com.optum.apiautomation.util.DatabaseUtil;
import com.optum.automation.coreframework.baseclasses.BasePageFunctions;
import com.optum.automation.coreframework.browser.Locator;
import com.optum.automation.coreframework.browser.Locator.DynamicLocator;
import com.optum.automation.coreframework.browser.LocatorType;
import com.optum.automation.coreframework.browser.PageFactory.Page;
import com.optum.automation.coreframework.utils.AutomationProfile;
import com.optum.automation.coreframework.utils.Log;
import com.optum.remoteSite.databeans.CircuitOrder;
import com.optum.remoteSite.databeans.RemoteSiteRequest;

@Page



public class ConfiguratorPage extends BasePageFunctions {

	private static Logger logger = Logger.getLogger(ConfiguratorPage.class);
	
	
	Locator order_dashboard = new Locator(LocatorType.xpath, "//span[text()='Order Dashboard']");
	Locator circuit_orders = new Locator(LocatorType.xpath, "//h2[text()='Circuit Orders']");
	Locator new_order_button = new Locator(LocatorType.xpath,"//div[@class='ui-grid-col-1']/button[@label='New Order']");
	Locator new_order_window_title = new Locator(LocatorType.xpath, "//div/span[text()='New Order']");
	Locator order_number = new Locator(LocatorType.xpath, "//input[@formcontrolname='uhgOrderId']");
	Locator vendor = new Locator(LocatorType.xpath, "//input[@formcontrolname='venderName']");
	Locator domestic_dropdown = new Locator(LocatorType.xpath, "//div[contains(text(),' Domestic/International')]/following-sibling::div/p-dropdown/div");
	Locator city = new Locator(LocatorType.xpath, "//input[@formcontrolname='siteCity']");
	Locator ok_button = new Locator(LocatorType.xpath, "//span[text()='Ok']");
	Locator alert_message = new Locator(LocatorType.xpath, "//span[text()='Alert Message']");
	Locator req1_email = new Locator(LocatorType.xpath, "//input[@formcontrolname='requestor1Email']");
	Locator new_change_dropdown = new Locator(LocatorType.xpath, "//div[contains(text(),' New/Change')]/following-sibling::div/p-dropdown/div/div[3]");
	Locator mail_code = new Locator(LocatorType.xpath, "//input[@formcontrolname='siteCode']");
	Locator allrequests_tab = new Locator(LocatorType.xpath, "//span[contains(text(),'All Requests')]");
	Locator openrequests_tab = new Locator(LocatorType.xpath, "//li[@role='tab']/a[@role='presentation']/span[text()='Open Requests']");
	Locator completedreq_tab = new Locator(LocatorType.xpath, "//li[@role='tab']/a[@role='presentation']/span[text()='Completed Requets']");
	Locator canceledreq_tab = new Locator(LocatorType.xpath, "//li[@role='tab']/a[@role='presentation']/span[text()='Canceled Requets']");
	Locator domestic_search = new Locator(LocatorType.xpath, "//input[@placeholder='Domestic/ International']");
	Locator business_search = new Locator(LocatorType.xpath, "//input[@placeholder='Business']");
	Locator requestor_search = new Locator(LocatorType.xpath, "//input[@placeholder='Requester 1']");
	Locator business = new Locator(LocatorType.xpath, "//div[contains(text(),' Business')]/following-sibling::div/p-dropdown/div/div[3]");
	Locator state = new Locator(LocatorType.xpath, "//input[@formcontrolname='siteState']");
	Locator basicrequest_details = new Locator(LocatorType.xpath, "//span[text()=' Basic Request Details ']");
	Locator connection_type = new Locator(LocatorType.xpath, "//p-dropdown[@formcontrolname='connectionType']/child::div/div[3]");
	Locator circuit_information_tab = new Locator(LocatorType.xpath, "//span[contains(text(),' Circuit Information ')]");
	Locator circuit_type = new Locator(LocatorType.xpath, "//input[@formcontrolname='circuitType']");
	Locator access_carrier = new Locator(LocatorType.xpath, "//input[@formcontrolname='accessCarrier']");
	Locator lecCircuitId = new Locator(LocatorType.xpath, "//input[@formcontrolname='lecCircuitID']");
	Locator carrierCircuitId = new Locator(LocatorType.xpath, "//input[@formcontrolname='circuitId']");
	Locator required_ord_number = new Locator(LocatorType.xpath, "//table[@role='grid']/tbody/tr/td[1]/span/a");
	Locator sameAccessCarrier = new Locator(LocatorType.xpath, "//p-dropdown[@formcontrolname='sameCarrier']/div/div[2]/span");
	Locator order_status_dates_tab = new Locator(LocatorType.xpath, "//span[contains(text(),' Order Status/Dates ')]");
	Locator nspg_received = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='nspgRecieved']/span/button");
	Locator lec_install_date = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='lecInstalledDate']/span/button");
	Locator ixc_due = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='ixcDueDate']/span/button");
	Locator uhg_turnup = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='uhgTurnupDate']/span/button");
	Locator cancel_date = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='canceledOrderDate']/span/button");
	Locator date_sent_to_vendor = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='vendorSubmissionDate']/span/button");
	Locator lec_delivered = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='lecDeliveredDate']/span/button");
	Locator ixc_complete = new Locator(LocatorType.xpath, "//p-calendar[@formcontrolname='ixcCompletionDate']/span/button");
	Locator ready_for_activation = new Locator(LocatorType.xpath, "//input[@formcontrolname='activationStatus']");
	Locator request_notes_tab = new Locator(LocatorType.xpath, "//span[contains(text(),' Request Notes ')]");
	Locator add_notes = new Locator(LocatorType.xpath, "//textarea[@formcontrolname='newNote']");
	Locator create_order_button = new Locator(LocatorType.xpath, "//span[text()='Create Order']");
	Locator calendar_table_button = new Locator(LocatorType.xpath, "//button[contains(@class,'ui-datepicker-trigger ui-calendar-button')]");
	Locator cancel_button = new Locator(LocatorType.xpath, "//span[text()='Cancel']");
	Locator order_audit_view = new Locator(LocatorType.xpath, "//span[contains(@class,'pi pi-plus')]");
	Locator order_audit_table = new Locator(LocatorType.xpath, "//div[contains(@class,'component-table')]//thead[@class='ui-table-thead']");
	Locator column_select_dropdown = new Locator(LocatorType.xpath,"//button[@icon='pi pi-file-excel']/following-sibling::p-multiselect/child::div/div[3]");
	Locator column_select_dropdown_close = new Locator(LocatorType.xpath, "//span[contains(@class,'pi pi-times')]");
	Locator column_select_main_checkbox = new Locator(LocatorType.xpath, "//div[@role='checkbox']");
	Locator BotTitle = new Locator(LocatorType.xpath, "//div[@class='block']");
	Locator networkservices_label = new Locator(LocatorType.xpath, "//span[text()='Network Services']");
	Locator contact_label = new Locator(LocatorType.xpath, "//span[text()='Contact Us']");
	Locator termOfuse_label = new Locator(LocatorType.xpath, "//span[text()='Terms of Use']");
	Locator allrights_label = new Locator(LocatorType.xpath,"//span[text()='© 2020 Optum, Inc. All ri m,<"+ "<.ghts reserved.']");
	Locator globalsearch = new Locator(LocatorType.xpath, "//input[@placeholder='Global Search']");
	Locator mailroute_txtfield = new Locator(LocatorType.xpath, "//input[@placeholder='mailRoute']");
	Locator infoicon = new Locator(LocatorType.xpath, "//span/i[@title='Site Details']");
	Locator sitedetails_label = new Locator(LocatorType.xpath, "//node()[text()='Site Details']");
	Locator state_label = new Locator(LocatorType.xpath, "//node()[text()='State: ']");
	Locator legmail_route_label = new Locator(LocatorType.xpath, "//node()[text()='Leg. MailRoute: ']");
	Locator address_label = new Locator(LocatorType.xpath, "//node()[text()='Address: ']");
	Locator city_label = new Locator(LocatorType.xpath, "//node()[text()='City: ']");
	Locator status_label = new Locator(LocatorType.xpath, "//node()[text()='Status: ']");
	Locator zipcode_label = new Locator(LocatorType.xpath, "//node()[text()='Zip Code: ']");
	Locator country_label = new Locator(LocatorType.xpath, "//node()[text()='Country: ']");
	Locator site_info_close_btn = new Locator(LocatorType.xpath, "//a[@role='button']/span");
	Locator sitedetails_info = new Locator(LocatorType.xpath, "//div[@id=\"ui-accordiontab-16-content\"]//div/label");
	Locator status_txtfield = new Locator(LocatorType.xpath, "//input[@placeholder='siteStatus']");
	Locator setting_btn = new Locator(LocatorType.xpath,"//button[@class='ui-button-secondary ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only']");
	Locator setting_close_btn = new Locator(LocatorType.xpath, "//span[text()='Close']");
	Locator setting_close_icon = new Locator(LocatorType.xpath, "//div/a[@role='button']/span");
	Locator Asn_details_expand = new Locator(LocatorType.xpath, "//node()[text()=' ASN/Circuit Details ']");
	Locator network_details_expand = new Locator(LocatorType.xpath, "//node()[text()=' Network Details ']");
	Locator config_details_expand = new Locator(LocatorType.xpath, "//node()[text()=' Configurator Specific Input ']");
	Locator BuildSite_Configure_expand = new Locator(LocatorType.xpath,	"//node()[text()=' Build Site DNS/IPAM Configuration ']");
	Locator select_dhcp_offflag = new Locator(LocatorType.xpath,"//div[@role='button'][@class='ui-button ui-widget ui-state-default ui-button-text-only ng-star-inserted']");
	Locator select_dns_onflag = new Locator(LocatorType.xpath,"//p-selectbutton[3]/div[@class='ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-2']");
	Locator select_dns_offflag = new Locator(LocatorType.xpath,"//p-selectbutton[3]/div/div[@class='ui-button ui-widget ui-state-default ui-button-text-only ng-star-inserted']");
	Locator subnet_flag = new Locator(LocatorType.xpath,"//div[@role='group'][@class='ui-selectbutton ui-buttonset ui-widget ui-corner-all ui-buttonset-1']/div/span");
	Locator build_site_btn = new Locator(LocatorType.xpath, "//button[@label='Build Site']");
	Locator alert_popup = new Locator(LocatorType.xpath, "//span[text()='Confirm']");
	Locator build_confirmclick = new Locator(LocatorType.xpath, "//button[@label='Confirm']");
	Locator ProjectId_drpdown = new Locator(LocatorType.id, "projectType");
	Locator ProjectId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[1]/li/span");
	Locator Project2ndId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[2]/li/span");
	Locator Project3rdId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[3]/li/span");
	Locator Project4thId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[4]/li/span");
	Locator Project5thId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[5]/li/span");
	Locator Project6thId_select = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[6]/li/span");
	Locator createSubnet_table = new Locator(LocatorType.xpath, "//table[@class='subnettable']");
	Locator mailRoute_headerTitle = new Locator(LocatorType.xpath, "//div[@role='dialog']/div/span");
	Locator Project_notfound_alert = new Locator(LocatorType.xpath, "//div[@role='alert']");
	Locator siteType_dropdown = new Locator(LocatorType.xpath, "//p-dropdown[@formcontrolname='selectedSubnet']/div");
	Locator sitesize_small = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[4]/li/span");
	Locator sitesize_medium = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[3]/li/span");
	Locator sitesize_pico = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[5]/li/span");
	Locator sitesize_large = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[1]/li/span");
	Locator sitesize_XL = new Locator(LocatorType.xpath, "//ul/p-dropdownitem[2]/li/span");
	Locator siteDetails_expand = new Locator(LocatorType.xpath, "//span[text()=' Site Details ']");
	Locator create_chnage_error = new Locator(LocatorType.xpath,"//div[@class='btn-group ng-star-inserted'][1]/child::span[1]");
	Locator decom_change_ticket = new Locator(LocatorType.xpath,"//div/label[text()='Decom Site Config :']");
	Locator pagination_dropdown = new Locator(LocatorType.xpath,"//a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all']/following-sibling::p-dropdown/div/div[3]/span");
	Locator error_cross_icon = new Locator (LocatorType.xpath,"//i[@class='pi pi-times']");
	Locator siteSizeAlertMessage = new Locator(LocatorType.xpath,"//span[text()='Please select a Site type from Site Details to proceed']");
	Locator pagination_nextbutton = new Locator(LocatorType.xpath,"//a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all']");
	Locator pagination = new Locator(LocatorType.xpath, "//table[@class='subnettable']/following::p-paginator[@styleclass='ui-paginator-bottom']/div/span[2]/a");
	Locator container_validation_message = new Locator(LocatorType.xpath,"//span[text()='Failed : No IPs are available to create a site of size: L Please contact the New_Remote_Site_Automation@ds.uhc.com and they will get the needed IPs allocated/created. ']");
	Locator cirord_warning_popup = new Locator(LocatorType.xpath, "//div[contains(text(),'Warn')]");
	Locator cirord_warning_message = new Locator(LocatorType.xpath, "//div[contains(text(),'Warn')]/following-sibling::div");
	Locator cirord_alert_popup = new Locator(LocatorType.xpath, "//span[contains(text(),'Alert Message')]");
	Locator cirord_alert_message = new Locator(LocatorType.xpath, "//div[contains(text(),'Order Saved Successfully.')]");
	Locator cirord_pagination_downarrow = new Locator(LocatorType.xpath, "//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable')]");
	Locator cirord_pagination_selection = new Locator(LocatorType.xpath, "//p-dropdownitem[contains(@class,'ng-star-inserted')][3]/li/span");
	Locator cirord_table = new Locator(LocatorType.xpath, "//table[@role='grid']/tbody");
	Locator file_upload = new Locator(LocatorType.xpath, "//span[text()='File Upload']");
	Locator upload_carrier_status_spreadsheet = new Locator(LocatorType.xpath, "//span[text()='Upload Carrier Status Spreadsheet']");
	Locator upload_file = new Locator(LocatorType.xpath, "//button/span[text()='Upload File']");
	Locator verizonFile_radiobutton = new Locator(LocatorType.xpath, "//p-radiobutton[@label='Verizon File']/div/div[2]/span");
	Locator attFile_radiobutton = new Locator(LocatorType.xpath, "//p-radiobutton[@label='ATT File']/div/div[2]/span");
	Locator excelUpload_validationMessage = new Locator(LocatorType.xpath, "//div[contains(text(),' Unable to process the Excel sheet.')]");
	Locator choose_file_button = new Locator(LocatorType.xpath, "//div[@role='region']/div/div/div/div[3]/input");
	Locator fileupload_errorMessage = new Locator(LocatorType.xpath, "//label[contains(text(),'*Please Select Carrier Name')]");
	Locator upload_confrm_table = new Locator(LocatorType.xpath, "//table[@class='ui-table-scrollable-header-table']");
	
	Locator pagination_value = new Locator(LocatorType.xpath, "//p-dropdownitem[3]/li[1]/span");
	Locator second_pageoftypeXL = new Locator(LocatorType.xpath, "//p-paginator[@styleclass='ui-paginator-bottom']/child::div/child::span[2]/child::a[2]");
	Locator dnsHost_rec_table = new Locator(LocatorType.xpath, "//span[text()='DNS']");
	Locator dhcpHost_rec_table = new Locator(LocatorType.xpath, "//span[text()='DHCP']");
	Locator subnet_rec_table = new Locator (LocatorType.xpath, "//span[text()='Subnets']");
	Locator create_DHCP_button = new Locator(LocatorType.xpath, "//span[contains(text(),'Create DHCP')]");
	Locator create_DNS_button = new Locator(LocatorType.xpath, "//span[contains(text(),'Create DNS')]");
	Locator logout_application = new Locator(LocatorType.xpath, "//i[@title='Logout']");
	Locator decom_verification = new Locator(LocatorType.xpath, "//div[@class='ng-star-inserted']/label[contains(text(),'submited successfully')]");
	Locator decomsite_tab = new Locator(LocatorType.xpath, "//span[contains(text(),' Decom Site DNS/IPAM Configuration ')]");
	Locator decomesite_config_button = new Locator(LocatorType.xpath, "//span[contains(text(),'decom site config')]");
	Locator buildSite_createchange = new Locator(LocatorType.xpath, "//div[@class='btn-group ng-star-inserted'][1]/preceding-sibling::div/span[1]");
	Locator changeNumber_textbox = new Locator(LocatorType.xpath, "//div[@class='ui-grid-col-3']/input");
	Locator submit_button = new Locator(LocatorType.xpath, "//button[@label='Submit']");
	Locator dropdown_selected_elements_count = new Locator(LocatorType.xpath, "//p-multiselect[@placeholder='Choose Columns']/div/div[2]/span");

	DynamicLocator prjid = new DynamicLocator(LocatorType.xpath, "//span[contains(text(),'%s')]");
	DynamicLocator stsize= new DynamicLocator(LocatorType.xpath, "//span[contains(text(),'%s(')]");
	DynamicLocator siteTypeselection = new DynamicLocator(LocatorType.xpath, "//p-dropdown[@formcontrolname='selectedSubnet']/div/div[2]/span[contains(text(),'%s')]");
	DynamicLocator domint = new DynamicLocator(LocatorType.xpath, "//span[contains(text(),'%s')]");
	DynamicLocator newchng = new DynamicLocator(LocatorType.xpath, "//li[@aria-label='%s']/span");
	DynamicLocator bus = new DynamicLocator(LocatorType.xpath, "//li[@aria-label='%s']/span");
	DynamicLocator conTyp = new DynamicLocator(LocatorType.xpath, "//li[@aria-label='%s']/span");
	DynamicLocator acccar = new DynamicLocator(LocatorType.xpath, "//span[contains(text(),'%s')]");
	DynamicLocator datepicker = new DynamicLocator(LocatorType.xpath, "//table/thead/following-sibling::tbody/following::td//a[text()='%s']");
	DynamicLocator col_element_selection = new DynamicLocator(LocatorType.xpath, "//span[contains(text(),'%s')]/preceding-sibling::div");
	DynamicLocator cell_color = new DynamicLocator(LocatorType.xpath, "//table[@role='grid']/tbody/tr/td['%s']/span[@class='status-color-red']");
	
	
	public void validateconfigureSite(RemoteSiteRequest remoteSite) throws InterruptedException {

		if (!(remoteSite.globalSearch.equalsIgnoreCase(""))) {
			enterText(globalsearch, remoteSite.globalSearch);

		}
		waitsleep(1000);
		isTextPresent(remoteSite.globalSearch, mailroute_txtfield);
		clickElement(infoicon);
		verifySiteInformation(remoteSite);

	}
	
	
	
	public void calendardatepicker(Locator locator, String val) {

		waitForElementToAppear(locator);
		clickElement(locator);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(val);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");	
		
		String date = val;
		
		if ((date == "") || (date == null)) {

			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyPress(KeyEvent.VK_ESCAPE);
			} catch (Exception exp) {
				exp.printStackTrace();
			}

		} else {
			String spl[] = date.split("/");
			String month = spl[0];
			String day = spl[1];
			String year = spl[2];
			System.out.println(month + "=========" + day + "===============" + year);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			clickElement(datepicker.format(spl[1]));
		}
	}

	public void clickInfoClosebutton() {
		
		waitForElementToAppear(site_info_close_btn);
		clickElement(site_info_close_btn);

	}

	public void clickSettingButton() {

		waitForElementToAppear(setting_btn);
		clickElement(setting_btn);
	}

	public void clickSettingCloseButton() {
		clickElement(setting_close_btn);
	}

	public void clickSettingCloseIcon() {
		clickElement(setting_close_icon);
		
	}
	
	public void clickOrderDashboard() {
		waitForElementToAppear(order_dashboard);
		clickElement(order_dashboard);
	}
	
	public void clickNewOrderButton() {
		waitForElementToAppear(new_order_button);
		clickElement(new_order_button);
		waitForElementToAppear(new_order_window_title);
		assertEquals(isVisible(new_order_window_title), true);
	}
	
	public void enterBasicRequestDetails(CircuitOrder cirord) {

		waitForElementToAppear(order_number);
		enterText(order_number, cirord.order_number);
		waitForElementToAppear(vendor);
		enterText(vendor, cirord.vendor);

		if (!(cirord.testDescription).contains("without selecting only Domestic/International Dropdown")) {
			waitForElementToAppear(domestic_dropdown);
			clickElement(domestic_dropdown);
			if ((cirord.domestic_international)
					.equalsIgnoreCase(getText(domint.format(cirord.domestic_international)))) {
				clickElement((domint.format(cirord.domestic_international)));
				assertEquals((cirord.domestic_international)
						.equalsIgnoreCase(getText(domint.format(cirord.domestic_international))), true);
			} else {
				logger.error("Please Check The domestic_international field entered in TestDataSheet.");
				assertEquals((cirord.domestic_international)
						.equalsIgnoreCase(getText(domint.format(cirord.domestic_international))), true);
			}
		} else {
			logger.error("It will not select the data from the domestic_international dropdown.");
		}
		waitsleep(3000);
		waitForElementToAppear(city);
		enterText(city, cirord.city);
		waitForElementToAppear(req1_email);
		enterText(req1_email, cirord.requestor1_mailid);

		if (!(cirord.testDescription).contains("without selecting only New/Change Dropdown")) {
			waitForElementToAppear(new_change_dropdown);
			clickElement(new_change_dropdown);

			if ((cirord.new_change).equalsIgnoreCase(getText(newchng.format(cirord.new_change)))) {
				clickElement((newchng.format(cirord.new_change)));
				assertEquals((cirord.new_change).equalsIgnoreCase(getText(newchng.format(cirord.new_change))), true);
			} else {
				logger.error("Please Check The new_change field entered in TestDataSheet.");
				assertEquals((cirord.new_change).equalsIgnoreCase(getText(newchng.format(cirord.new_change))), true);
			}
		} else {

			logger.error("It will not select the data from the New/Change dropdown.");
		}

		waitForElementToAppear(mail_code);
		enterText(mail_code, cirord.mail_code);

		if (!(cirord.testDescription).contains("without selecting only Business Dropdown")) {
			waitForElementToAppear(business);
			clickElement(business);
			if ((cirord.business).equalsIgnoreCase(getText(bus.format(cirord.business)))) {
				clickElement((bus.format(cirord.business)));
				assertEquals((cirord.business).equalsIgnoreCase(getText(bus.format(cirord.business))), true);
			} else {
				logger.error("Please Check the business entered in TestDataSheet.");
				assertEquals((cirord.business).equalsIgnoreCase(getText(bus.format(cirord.business))), true);
			}
		} else {

			logger.error("It will not select the data from the Business dropdown.");
		}

		if (!(cirord.testDescription).contains("without providing the data only in State Field")) {
			waitForElementToAppear(state);
			enterText(state, cirord.state);
		}

		if (!(cirord.testDescription).contains("without providing the data only in Connection Type")) {
			waitForElementToAppear(connection_type);
			clickElement(connection_type);
			if ((cirord.connection_type).equalsIgnoreCase(getText(conTyp.format(cirord.connection_type)))) {
				clickElement((conTyp.format(cirord.connection_type)));
				assertEquals((cirord.connection_type).equalsIgnoreCase(getText(conTyp.format(cirord.connection_type))),true);

			} else {
				logger.error("Please Check The ProjectID entered in TestDataSheet.");
				assertEquals((cirord.connection_type).equalsIgnoreCase(getText(conTyp.format(cirord.connection_type))),true);
			}
		} else {

			logger.error("It will not select the data from the Connection Type dropdown.");
		}
	}
		
	public void enterCircuitInformationDetails(CircuitOrder cirord) {
		
		waitForElementToAppear(circuit_information_tab);
		clickElement(circuit_information_tab);
		waitForElementToAppear(circuit_type);
		enterText(circuit_type, cirord.circuit_type);
		waitForElementToAppear(access_carrier);
		enterText(access_carrier, cirord.access_carrier);
		waitForElementToAppear(lecCircuitId);
		enterText(lecCircuitId, cirord.lec_circuitId);
		waitForElementToAppear(carrierCircuitId);
		enterText(carrierCircuitId, cirord.carrier_circuitId);
		waitForElementToAppear(sameAccessCarrier);
		clickElement(sameAccessCarrier);		
		if ((cirord.same_access_carrier).equalsIgnoreCase(getText(acccar.format(cirord.same_access_carrier))))
		{
			clickElement((acccar.format(cirord.same_access_carrier)));
			assertEquals((cirord.same_access_carrier).equalsIgnoreCase(getText(acccar.format(cirord.same_access_carrier))),true);
		}else
		{
			logger.error("Please Check The ProjectID entered in TestDataSheet.");
			assertEquals((cirord.same_access_carrier).equalsIgnoreCase(getText(acccar.format(cirord.same_access_carrier))),true);
		}		
	}
	
	public void enterOrderStatusDetails(CircuitOrder cirord) {

		waitForElementToAppear(order_status_dates_tab);
		clickElement(order_status_dates_tab);
		waitForElementToAppear(nspg_received);
		calendardatepicker(nspg_received, cirord.nspg_received);
		waitForElementToAppear(date_sent_to_vendor);
		calendardatepicker(date_sent_to_vendor, cirord.date_sent_to_vendor);
		waitForElementToAppear(lec_install_date);
		calendardatepicker(lec_install_date, cirord.lec_install_date);
		waitForElementToAppear(lec_delivered);
		calendardatepicker(lec_delivered, cirord.lec_delivered);
		waitForElementToAppear(ixc_due);
		calendardatepicker(ixc_due, cirord.ixc_due);
		waitForElementToAppear(ixc_complete);
		calendardatepicker(ixc_complete, cirord.ixc_complete);
		waitForElementToAppear(uhg_turnup);
		calendardatepicker(uhg_turnup, cirord.uhg_turnup);
		waitForElementToAppear(ready_for_activation);
		enterText(ready_for_activation, cirord.ready_for_activation);
		waitForElementToAppear(cancel_date);
		calendardatepicker(cancel_date, cirord.cancel_date);
	}
	
	
	
	public void verifythecircuitordervalidationmessage(CircuitOrder cirord){
		
		if (!(cirord.testDescription).contains("without")) {
			waitsleep(3000);
			if (isVisible(cirord_alert_popup)) {
				assertEquals((getText(cirord_alert_message).contains(cirord.alert_message)), true);
				clickElement(ok_button);
			} else {
				assertEquals((getText(cirord_alert_message).contains(cirord.alert_message)), true);
			}

		} else if ((cirord.testDescription).contains("without")) {
			waitsleep(3000);
			if (isVisible(cirord_warning_popup)) {
				assertEquals((getText(cirord_warning_message).contains(cirord.alert_message)), true);
			} else {
				assertEquals((getText(cirord_warning_message).contains(cirord.alert_message)), true);
			}
		}
	}

	public void globalSearch(CircuitOrder cirord) {
		
		dynamicGlobalSearch(cirord.order_number);
		dynamicGlobalSearch(cirord.new_change);
		dynamicGlobalSearch(cirord.vendor);
		dynamicGlobalSearch(cirord.mail_code);
		dynamicGlobalSearch(cirord.circuit_type);
		dynamicGlobalSearch(cirord.carrier_circuitId);
		dynamicGlobalSearch(cirord.connection_type);

	}
	
	public void normalSearch(CircuitOrder cirord) {
		
		waitForElementToAppear(domestic_search);

		if (!(cirord.domestic_international).equalsIgnoreCase("")) {
			enterText(domestic_search, cirord.domestic_international);
		} else if (!(cirord.business).equalsIgnoreCase("")) {
			enterText(business_search, cirord.business);
		} else if (!(cirord.requestor1_mailid).equalsIgnoreCase("")) {
			enterText(requestor_search, cirord.requestor1_mailid);
		}
	}
	
	public void dataValidationInCircuitOrderTable(CircuitOrder cirord) {

		waitForElementToAppear(cirord_pagination_downarrow);
		clickElement(cirord_pagination_downarrow);
		waitForElementToAppear(cirord_pagination_selection);
		clickElement(cirord_pagination_selection);
		WebElement cirordtbl = findElement(cirord_table);
		List<WebElement> rowsList = cirordtbl.findElements(By.tagName("tr"));
//		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//		System.out.println(rowsList.size());
		for (int k = 1; k <= rowsList.size(); k++) {
			// System.out.println(rowsList.get(k).getText());
			List<WebElement> columnsList = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr[" + k + "]/td"));
			for (int l = 0; l <= columnsList.size() - 1; l++) {
				if ((cirord.testDescription).contains("OrderNumber") && (l == 0)) {
					assertEquals((columnsList.get(l).getText().contains(cirord.order_number)), true);
				} else if ((cirord.testDescription).contains("New/Change") && (l == 1)) {
					assertEquals((columnsList.get(l).getText().contains(cirord.new_change)), true);
				} else if ((cirord.testDescription).contains("Vendor") && (l == 2)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.vendor)), true);
				} else if ((cirord.testDescription).contains("MailCode") && (l == 3)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.mail_code)), true);
				} else if ((cirord.testDescription).contains("Domestic/International") && (l == 4)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.domestic_international)), true);
				} else if ((cirord.testDescription).contains("Business") && (l == 5)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.business)), true);
				} else if ((cirord.testDescription).contains("Requester 1") && (l == 8)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.requestor1_mailid)), true);
				} else if ((cirord.testDescription).contains("Circuit Type") && (l == 10)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.circuit_type)), true);
				} else if ((cirord.testDescription).contains("Carrier Circuit ID") && (l == 11)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.carrier_circuitId)), true);
				} else if ((cirord.testDescription).contains("Connection Type") && (l == 12)) {
					assertEquals((columnsList.get(l).getText().equalsIgnoreCase(cirord.connection_type)), true);
				}

			}

		}
	}
	
	public void selectFileTypeTobeUpload(CircuitOrder cirord){
		waitForElementToAppear(file_upload);
		if ((cirord.vendor).equalsIgnoreCase("Verizon")){
			waitForElementToAppear(verizonFile_radiobutton);
			clickElement(verizonFile_radiobutton);
		}else if ((cirord.vendor).equalsIgnoreCase("ATT")){
			waitForElementToAppear(attFile_radiobutton);
			clickElement(attFile_radiobutton);
		}else if ((cirord.vendor).equalsIgnoreCase("")){
//			logger.error("Please Check The data entered in Vendor field of TestDataSheet.");
		}		
	}
	
	public void clickUploadCarrierSpreadsheet(){		
		waitForElementToAppear(upload_carrier_status_spreadsheet);
		clickElement(upload_carrier_status_spreadsheet);				
	}
	
	public void uploadFileattachment(CircuitOrder cirord){
		
		operate_ChooseFile_Button(choose_file_button);
		uploadattachment(cirord);
		waitForElementToAppear(upload_file);
		clickElement(upload_file);		
	}
	

	public void operate_ChooseFile_Button(Locator locator) {
		WebElement element = findElement(locator);
		int x =element.getLocation().getX();
		int y =element.getLocation().getY();
		int width = element.getSize().width;
		int height= element.getSize().height;
		Robot robot;
	    try {
	        robot = new Robot();
	        robot.mouseMove(x+20, y+150);
	        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
	        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	    } catch (AWTException e1) {
	        e1.printStackTrace();
	    }
	}
	
	
	
	
	
	public void verificationOfFileUpload(CircuitOrder cirord) {
		
		if ((cirord.vendor).contains("Verizon")||(cirord.vendor).contains("ATT")) {
			if((cirord.alert_message)==""){
				assertEquals(isVisible(upload_confrm_table),true);
			} else if (!(cirord.alert_message).equalsIgnoreCase("")){
			waitForElementToAppear(alert_message);
			assertEquals((cirord.alert_message).contains(getText(excelUpload_validationMessage)), true);
			waitsleep(4000);
			clickElement(ok_button);
			}
		} else if ((cirord.vendor).contains("")) {
			waitForElementToAppear(fileupload_errorMessage);
			assertEquals((cirord.alert_message).contains(getText(fileupload_errorMessage)), true);
		}
	}
	
	
	public void clickOnRequiredOrderNumber(CircuitOrder cirord) {
		if (getText(required_ord_number).equalsIgnoreCase(cirord.order_number)) {
			waitForElementToAppear(required_ord_number);
			clickElement(required_ord_number);
		}
	}
	
	public void verificationOfAuditTableExistance(){
		waitsleep(4000);
		clickElement(order_audit_view);
		if (isVisible(order_audit_table)){
			assertEquals(isVisible(order_audit_table), true);
		}else{
			assertEquals(isVisible(order_audit_table), true);
		}
	}
	
	public void existingColumnsClearance(CircuitOrder cirord){
		waitForElementToAppear(column_select_dropdown);
		clickElement(column_select_dropdown);
		waitForElementToAppear(column_select_main_checkbox);
		clickElement(column_select_main_checkbox);		
	}
	
	public void selectionOfRequiredColumn(CircuitOrder cirord){
		
		checkRequiredColumnNameFromDropdown(cirord.vendor);
		checkRequiredColumnNameFromDropdown(cirord.domestic_international);
		checkRequiredColumnNameFromDropdown(cirord.city);
		checkRequiredColumnNameFromDropdown(cirord.requestor1_mailid);
		checkRequiredColumnNameFromDropdown(cirord.new_change);
		checkRequiredColumnNameFromDropdown(cirord.mail_code);
		checkRequiredColumnNameFromDropdown(cirord.business);
		checkRequiredColumnNameFromDropdown(cirord.state);
		checkRequiredColumnNameFromDropdown(cirord.connection_type);
		checkRequiredColumnNameFromDropdown(cirord.circuit_type);
		checkRequiredColumnNameFromDropdown(cirord.access_carrier);
		checkRequiredColumnNameFromDropdown(cirord.lec_circuitId);
		checkRequiredColumnNameFromDropdown(cirord.carrier_circuitId);
		checkRequiredColumnNameFromDropdown(cirord.same_access_carrier);
		checkRequiredColumnNameFromDropdown(cirord.ip_config_info);
		checkRequiredColumnNameFromDropdown(cirord.nspg_received);
		checkRequiredColumnNameFromDropdown(cirord.lec_install_date);
		checkRequiredColumnNameFromDropdown(cirord.ixc_due);
		checkRequiredColumnNameFromDropdown(cirord.uhg_turnup);
		checkRequiredColumnNameFromDropdown(cirord.cancel_date);
		checkRequiredColumnNameFromDropdown(cirord.date_sent_to_vendor);
		checkRequiredColumnNameFromDropdown(cirord.lec_delivered);
		checkRequiredColumnNameFromDropdown(cirord.ready_for_activation);
		waitForElementToAppear(column_select_dropdown_close);
		clickElement(column_select_dropdown_close);
		waitsleep(5000);
		
	}
	
	public void dropdownElementsComparissionWithTableColumnsCount(){
		
		waitForElementToAppear(dropdown_selected_elements_count);
		int ddelecount = 0;
		String elements_count = getText(dropdown_selected_elements_count);
		
		if ((elements_count).contains(",")) {
			String[] elecnt = elements_count.split(",");
			ddelecount = elecnt.length;
		} else if ((elements_count).contains("selected")) {
			String[] elecnt = elements_count.split(" ");
			ddelecount = Integer.parseInt(elecnt[0]);
		} else {
			ddelecount = 1;
		}
		
		int cirord_table_columns = getXpathCount("//table[@role='grid']/thead/tr[1]/th");
		int colcount = cirord_table_columns-1;
		if ((ddelecount)==(colcount)){
			System.out.println("==================================================================");
			System.out.println("No.of Elements selected from dropdown are : "+ddelecount);
			System.out.println("No.of Columns displayed after selection are : "+colcount+" (Ignoring OrderNumber field as it is default field)");
			System.out.println("==================================================================");
			assertEquals((Integer.valueOf(ddelecount)==Integer.valueOf(colcount)),true);
			
		}else
		{
			assertEquals((Integer.valueOf(ddelecount)==Integer.valueOf(colcount)),true);
		}
		
	}
	
	public void dynamicGlobalSearch(String val){

	if (!(val).equalsIgnoreCase("")) {
		enterText(globalsearch, val);		
		}	
	waitsleep(3000);
	}

	public void checkRequiredColumnNameFromDropdown(String dropelement){
		
		if (!(dropelement).equalsIgnoreCase("")){		
			waitForElementToAppear(col_element_selection.format(dropelement));
			clickElement(col_element_selection.format(dropelement));
		}
		
	}
	
	public void enterRequestNotesDetails(CircuitOrder cirord){
		
		waitForElementToAppear(request_notes_tab);
		clickElement(request_notes_tab);
		waitForElementToAppear(add_notes);
		enterText(add_notes, cirord.add_Notes);	
		
	}	
	
	public void clickCreateOrderButton(CircuitOrder cirord){
		waitForElementToAppear(create_order_button);
		clickElement(create_order_button);	
	}

	public void expandSiteDetails() {
		clickElement(siteDetails_expand);
		waitsleep(3000);
	}

	public void expandAsnDetails() {
		clickElement(Asn_details_expand);
	}

	public void expandnetworkDetails() {

		waitForElementToAppear(network_details_expand);
		waitsleep(3000);
		clickElement(network_details_expand);
	}

	public void expandConfigDetails() {
		waitForElementToAppear(config_details_expand);
		clickElement(config_details_expand);
	}

	public void verificationOfFieldlevelValidation(CircuitOrder cirord){
		
		// clickOrderDashboard();
		waitForElementToAppear(globalsearch);
		enterText(globalsearch, cirord.order_number);
		waitForElementToAppear(cirord_table);
		WebElement cirordtbl = findElement(cirord_table);
		waitsleep(4000);
		List<WebElement> columnsList = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td"));
		for (int i = 1; i <= columnsList.size(); i++) {
			if ((cirord.testDescription).contains("LECinstallDateFieldFunctionality") && (i == 23)) {
//				assertEquals(isVisible(cell_color.format(i)),true);
				assertEquals(columnsList.get(i).getText().contains(""), true);
			} else if ((cirord.testDescription).contains("LECDeliveredFieldFunctionality") && (i == 24)) {
				assertEquals(columnsList.get(i).getText().contains(""), true);
//				assertEquals(isVisible(cell_color.format(i)),true);				
			} else if ((cirord.testDescription).contains("IXCCompleteFieldFunctionality") && (i == 26)) {
//				assertEquals(isVisible(cell_color.format(i)),true);
				assertEquals(columnsList.get(i).getText().contains(""), true);
			} else if ((cirord.testDescription).contains("UHCTurnUpFieldFunctionality") && (i == 28)) {
//				assertEquals(isVisible(cell_color.format(i)),true);
				assertEquals(columnsList.get(i).getText().contains(""), true);
			}
		}
	}
	
	
	public void verifytherequestType(CircuitOrder cirord) {

		if ((cirord.testDescription).contains("Open Request")) {

			waitForElementToAppear(globalsearch);
			enterText(globalsearch, cirord.order_number);
			dataValidationInCircuitOrderTable(cirord);
			operate_ChooseFile_Button(openrequests_tab);
			waitForElementToAppear(globalsearch);
			enterText(globalsearch, cirord.order_number);
			dataValidationInCircuitOrderTable(cirord);
		} else if ((cirord.testDescription).contains("Completed Request")) {
			operate_ChooseFile_Button(completedreq_tab);
			waitForElementToAppear(globalsearch);
			enterText(globalsearch, cirord.order_number);
			dataValidationInCircuitOrderTable(cirord);
		} else if ((cirord.testDescription).contains("Cancelled Request"))
			operate_ChooseFile_Button(canceledreq_tab);
		waitForElementToAppear(globalsearch);
		enterText(globalsearch, cirord.order_number);
		dataValidationInCircuitOrderTable(cirord);
	}
	
	public void subnets_toggling(RemoteSiteRequest remoteSite){
		
		if ((remoteSite.testDescription).contains("Create subnets")){
			waitForElementToAppear(select_dhcp_offflag);
			clickReqElement(select_dhcp_offflag);
			waitsleep(2000);
			waitForElementToAppear(select_dns_offflag);
			clickReqElement(select_dns_offflag);
			
		}else if ((remoteSite.testDescription).contains("Create DHCP")){
			waitsleep(2000);
			waitForElementToAppear(select_dns_offflag);
			clickReqElement(select_dns_offflag);			
		}else if ((remoteSite.testDescription).contains("Create DNS")){
			waitsleep(2000);
			waitForElementToAppear(select_dhcp_offflag);
			clickReqElement(select_dhcp_offflag);		
		}		
		
	}
	
	public void toggleisDhcpoffFlag() {

//		waitForElementToAppear(BuildSite_Configure_expand);
		
		System.out.println("++++++++++++++++++++++++++++one");
		clickReqElement(select_dhcp_offflag);
		System.out.println("++++++++++++++++++++++++++++two");
		boolean dhcpflag = isEnabled(select_dhcp_offflag);
		System.out.println(dhcpflag + "++++++++++++++++++++++++++++three");
		System.out.println(dhcpflag);
		assertEquals(dhcpflag, true);

	}

	public void toggleisDnsoffFlag() {

//		waitForElementToAppear(BuildSite_Configure_expand);
		waitForElementToAppear(select_dns_offflag);
		waitsleep(2000);
		clickReqElement(select_dns_offflag);
		boolean dnsflag = isEnabled(select_dns_offflag);
		System.out.println(dnsflag);
		assertEquals(dnsflag, true);

	}

	public void selectNoOfRecordsFromDropDown(RemoteSiteRequest remoteSite) {
	
		waitForElementToAppear(pagination_dropdown);	
		clickElement(pagination_dropdown);
		waitForElementToAppear(pagination_value);
		clickElement(pagination_value);
		
		}
			
	

	public void clickonReqProjectFromDropDown(RemoteSiteRequest remoteSite) {
		waitForElementToAppear(ProjectId_drpdown);
		clickElement(ProjectId_drpdown);		
		if ((remoteSite.projectId).equalsIgnoreCase(getText(prjid.format(remoteSite.projectId))))
		{
			clickElement((prjid.format(remoteSite.projectId)));
			assertEquals((remoteSite.projectId).equalsIgnoreCase(getText(prjid.format(remoteSite.projectId))),true);
		}else 
		{
			logger.error("Please Check The ProjectID entered in TestDataSheet.");
			assertEquals((remoteSite.projectId).equalsIgnoreCase(getText(prjid.format(remoteSite.projectId))),true);
		}
	}
	

	public void verifySiteSelectionValidation() {

		clickElement(build_site_btn);
		WebElement e = findElement(siteSizeAlertMessage);
		bringElementToFocus(e);
		boolean result = isTextPresent("Please select a Site type from Site Details to proceed", siteSizeAlertMessage);
		waitsleep(3000);
		assertEquals(result, true);
	}

	public void verifyEmptySubnetContainerMessage(RemoteSiteRequest remoteSite) {

		WebElement w = findElement(container_validation_message);
		bringElementToFocus(w);
		waitsleep(7000);
		boolean contmsg = isTextContain(
				"Failed : No IPs are available to create a site of size: " + remoteSite.siteSize
						+ " Please contact the New_Remote_Site_Automation@ds.uhc.com and they will get the needed IPs allocated/created. ']",
				container_validation_message);
		assertEquals(contmsg, true);
	}

	public void clickOnBuildSite() {

//		waitForElementToAppear(BuildSite_Configure_expand);
		waitForElementToAppear(build_site_btn);
		clickElement(build_site_btn);
		waitsleep(2000);
		clickElement(build_confirmclick);
	}

	private void verifySiteInformation(RemoteSiteRequest remoteSite) {
		
		waitForElementToAppear(sitedetails_label);
		assertEquals(getText(sitedetails_label).trim(), remoteSite.siteDetails);
		assertEquals(getText(status_label).trim(), remoteSite.status);
		assertEquals(getText(legmail_route_label), remoteSite.legalmailroute);
		assertEquals(getText(address_label).trim(), remoteSite.address);
		assertEquals(getText(city_label).trim(), remoteSite.city);
		assertEquals(getText(state_label).trim(), remoteSite.state);
		assertEquals(getText(zipcode_label).trim(), remoteSite.zipCode);
		assertEquals(getText(country_label).trim(), remoteSite.country);

	}

	public void verifyClosedStatusSiteCodes(RemoteSiteRequest remoteSite) {

		waitsleep(5000);
		if (!remoteSite.mailRoute.equalsIgnoreCase("")) {
			enterText(mailroute_txtfield, remoteSite.mailRoute);
		}

		if (!remoteSite.statusColumn.equalsIgnoreCase("")) {
			enterText(status_txtfield, remoteSite.statusColumn);
		}

		clickElement(setting_btn);

		waitsleep(3000);

		boolean verify = isTextPresent(remoteSite.mailRouteheader, mailRoute_headerTitle);
		assertEquals(verify, true);

	}
	
	
	public void verifyBuildsiteButtonDisabled(){
		waitsleep(3000);
		WebElement e = findElement(build_site_btn);
		bringElementToFocus(e);			
		boolean disable = isDisabled(build_site_btn);
		assertEquals(disable, true);		
		
	}
	
	
	public void verifyBuildsiteButtonenabled(){
		
		waitForElementToAppear(build_site_btn);
		WebElement e = findElement(build_site_btn);
		bringElementToFocus(e);			
		boolean enable = isEnabled(build_site_btn);
		assertEquals(enable, true);		
		
	}
		
	
	public void validateRemotesiteChangeTicketMessage(RemoteSiteRequest remoteSite) {

		if (isEnabled(build_site_btn)) {

			refreshPage();
			waitsleep(3000);
			boolean available = isVisible(BotTitle);
			assertEquals(available, true);
		} else if (getText(create_chnage_error).contains("Completed")) {

			captureandsubmitChangeTicket();
			verifyDecomSiteConfigExhistanceandClick();
			verifyDecomNotification();
			clickSettingCloseIcon();

		}
	}
	
	public void verifyinvalidobjectexistance(RemoteSiteRequest remoteSite) {
		
		if ((remoteSite.testDescription).contains("subnets disabled")){
			
			verifyBuildsiteButtonDisabled();
				
		} else if ((remoteSite.testDescription).contains("no projects found")){
			
			boolean result = isTextPresent("projectsNo Projects Found", Project_notfound_alert);
			assertEquals(result, true);
		} else {
			
			logger.error("Please check the Test Desctiption in the Test Data Field");
			assertEquals(remoteSite.testDescription,true);
		}		
	}
	
	
	
	
	public void verifyDHCPButtonDisabled() {

		boolean disable = isDisabled(create_DHCP_button);		
		System.out.println(disable);
		assertEquals(disable, false);		
	}
	
	public void verifyDNSButtonDisabled() {
		boolean disable = isDisabled(create_DNS_button);
		assertEquals(disable, false);	
		
	}
	
	

	public void selectSiteSizeSmall() {

		waitForElementToAppear(siteType_dropdown);
		waitsleep(3000);
		clickElement(siteType_dropdown);
		waitForElementToAppear(sitesize_small);
		clickElement(sitesize_small);

	}

	public void selectSiteSizePico() {

		waitForElementToAppear(siteType_dropdown);
		clickElement(siteType_dropdown);
		waitForElementToAppear(sitesize_pico);
		clickElement(sitesize_pico);

	}
	
	public void expandDecomSiteConfiguration() {
		
		waitForElementToAppear(decomsite_tab);
		clickElement(decomsite_tab);
	}

	public void captureandsubmitChangeTicket(){ 
		
		waitForElementToAppear(buildSite_createchange);
		String Change = getText(buildSite_createchange);
		String[] ct = Change.split(":");
		expandDecomSiteConfiguration();
		enterText(changeNumber_textbox, (ct[0]).trim());
		waitForElementToAppear(submit_button);
		clickElement(submit_button);
				
	}
	
	
	public void switchtonewtabs(){
		
		try {
	        // Open New Tab by simulating Ctrl+t
	        Robot r = new Robot();
	        r.keyPress(KeyEvent.VK_CONTROL);
	        r.keyPress(KeyEvent.VK_T);
	        r.keyRelease(KeyEvent.VK_T);
	        r.keyRelease(KeyEvent.VK_CONTROL);
	        
	        

//	        // Create Array List to keep Tab information
//	        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//
//	        // Navigate to New Tab
//	        driver.switchTo().window(tabs2.get(1));

	        // go to URL2
	        driver.get("https://bot-dev.optum.com");
	        waitForElementToAppear(BotTitle);
	         
	        
	        
	        
	        
	          
	    } catch (Exception e) {
	    }

	}

	
	
	
	
	
	
	
	
	public void verifyDecomSiteConfigExhistanceandClick(){
		
		waitForElementToAppear(decomesite_config_button);
		boolean available = isVisible(decomesite_config_button);
		assertEquals(available, true);	
		clickElement(decomesite_config_button);
		waitForElementToAppear(alert_popup);
		clickElement(alert_popup);	
	}
	
	public void verifyDecomNotification() {
		waitForElementToAppear(decom_verification);		
		assertEquals(getText(decom_verification).trim(), "Decom Site request has been submited successfully, you will get email notification once it is done. Please reload the screen after notification!");
	}
	
	
	public void selectSiteSizeMedium() {

		waitForElementToAppear(siteType_dropdown);
		clickElement(siteType_dropdown);
		waitForElementToAppear(sitesize_medium);
		clickElement(sitesize_medium);
		waitsleep(2000);

	}

	public void selectSiteSizelarge() {

		waitForElementToAppear(siteType_dropdown);
		clickElement(siteType_dropdown);
		waitForElementToAppear(sitesize_large);
		clickElement(sitesize_large);

	}

	public void selectSiteSizeXL() {

		waitForElementToAppear(siteType_dropdown);
		clickElement(siteType_dropdown);
		waitForElementToAppear(sitesize_XL);
		clickElement(sitesize_XL);

	}
	
	public void verifySitesize(RemoteSiteRequest remoteSite) {
		waitForElementToAppear(siteType_dropdown);
		
		if (getText(siteType_dropdown).equalsIgnoreCase("Select Site"))
		{
			clickElement(siteType_dropdown);
			waitForElementToAppear(stsize.format(remoteSite.siteSize));
			clickElement(stsize.format(remoteSite.siteSize));
		} else if(getText(siteTypeselection.format(remoteSite.siteSize)).equalsIgnoreCase(remoteSite.siteSize))
		{
			boolean result = getText(siteTypeselection.format(remoteSite.siteSize)).equalsIgnoreCase(remoteSite.siteSize);
			assertEquals(result, true);
		}else
		{
			logger.error("Please check the testdata you might have entered either WRONG or MISSED siteSize field");
			boolean result = isTextPresent(remoteSite.siteSize, siteType_dropdown);
			assertEquals(getText(siteType_dropdown),true);
		}
	}	
		
	
	

	
	public void switchtoSubnetTab(){
		waitForElementToAppear(subnet_rec_table);
		clickElement(subnet_rec_table);
	}
	
	public void switchtoDHCPTab(){
		waitForElementToAppear(dhcpHost_rec_table);
		clickElement(dhcpHost_rec_table);		
		waitForElementToAppear(create_DHCP_button);
		clickElement(create_DHCP_button);
		waitForElementToAppear(build_confirmclick);
		clickElement(build_confirmclick);
	}
	
	
	
	
	public void switchtoDNSTab(){
		waitForElementToAppear(dnsHost_rec_table);
		clickElement(dnsHost_rec_table);
//		waitForElementToAppear(create_DNS_button);
//		clickElement(create_DNS_button);
//		waitForElementToAppear(build_confirmclick);
//		clickElement(build_confirmclick);	
	}
	
	
	// verify subnet creations when container is empty(user should be notified
	// with
	// a error message)

	public void verifyContainerEmptiness(RemoteSiteRequest remoteSite) {

		waitsleep(4000);

		waitForElementToAppear(create_chnage_error);

		String errorMessage = "Failed : No IPs are available to create a site of size: " + remoteSite.siteSize
				+ " Please contact the New_Remote_Site_Automation@ds.uhc.com and they will get the needed IPs allocated/created.";

		assertEquals(errorMessage.contains(getText(create_chnage_error)), true);

	}

	public void waittillSubnetCreation(RemoteSiteRequest remoteSite) throws InterruptedException {


		waitForElementToAppear(createSubnet_table);
		
		if (isVisible(createSubnet_table)){
		}	
		else{
			assertEquals(isVisible(createSubnet_table),true);
		}		
		
	}

	public void verifyDhcpHostCreation(RemoteSiteRequest remoteSite) {

		waitForElementToAppear(dhcpHost_rec_table);
		clickElement(dhcpHost_rec_table);
		selectNoOfRecordsFromDropDown(remoteSite);

		if ((((remoteSite.siteSize).equalsIgnoreCase("P")) || ((remoteSite.siteSize).equalsIgnoreCase("S"))|| ((remoteSite.siteSize).equalsIgnoreCase("M"))) || ((remoteSite.siteSize).equalsIgnoreCase("L"))) {
			List<List<String>> uilist = tableAsLists(createSubnet_table);
			String uilistString = uilist.toString();

			List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult(
					"select * from dhcpgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '" + AutomationProfile.getProfile().userName+ "')");

			System.out.println(list);
			for (HashMap<String, Object> row : list) {

				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
				System.out.println(uilistString.contains(row.get("subnet").toString()));
				System.out.println(uilistString.contains(row.get("dhcpRange").toString()));
				assertEquals(uilistString.contains(row.get("subnet").toString()), true);
				assertEquals(uilistString.contains(row.get("dhcpRange").toString()), true);
				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
			}
		} else if ((remoteSite.siteSize).equalsIgnoreCase("XL")) {
			List<List<String>> uilist1 = tableAsLists(createSubnet_table);
			waitForElementToAppear(pagination_nextbutton);
			clickElement(pagination_nextbutton);
			List<List<String>> uilist2 = tableAsLists(createSubnet_table);
			List<List<String>> newList = ListUtils.union(uilist1, uilist2);
			int rows = newList.size() - 2;
			System.out.println("*************************************************************************");
			System.out.println("Total number of rows in XL sitetype are: " + rows);
			System.out.println("*************************************************************************");
			Assert.assertEquals(61, rows);
			String uilistString = newList.toString();
			List<HashMap<String, Object>> xllist = DatabaseUtil.getSelectResult(
					"select * from dhcpgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '" + AutomationProfile.getProfile().userName+ "')");
			for (HashMap<String, Object> row : xllist) {
				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
				System.out.println("Entered into DHCP - XL block");
				System.out.println(uilistString.contains(row.get("subnet").toString()));
				System.out.println(uilistString.contains(row.get("dhcpRange").toString()));
				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
				assertEquals(uilistString.contains(row.get("subnet").toString()), true);
				assertEquals(uilistString.contains(row.get("dhcpRange").toString()), true);
			}

		}

	}

	

	public void verifySubnetsCreationForAnysiteType(RemoteSiteRequest remoteSite) {
	
		if ((((remoteSite.siteSize).equalsIgnoreCase("P")) || ((remoteSite.siteSize).equalsIgnoreCase("S"))|| ((remoteSite.siteSize).equalsIgnoreCase("M"))) || ((remoteSite.siteSize).equalsIgnoreCase("L"))) {
			waitsleep(3000);
			List<List<String>> uilist = tableAsLists(createSubnet_table);
			int rows = uilist.size() - 1;

			if (remoteSite.siteSize.equalsIgnoreCase("P")) {
				Assert.assertEquals(4, rows);
			} else if (remoteSite.siteSize.equalsIgnoreCase("S")) {
				Assert.assertEquals(8, rows);
			} else if (remoteSite.siteSize.equalsIgnoreCase("M")) {
				Assert.assertEquals(16, rows);
			} else if (remoteSite.siteSize.equalsIgnoreCase("L")) {
				Assert.assertEquals(32, rows);
			}

			String uilistString = uilist.toString();
			List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult(
					"select * from subnetgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "')");
			for (HashMap<String, Object> row : list) {
				assertEquals(uilistString.contains(row.get("subnet").toString()), true);
				assertEquals(uilistString.contains(row.get("vLan").toString()), true);
			}
			
			
		}

		else if ((remoteSite.siteSize).equalsIgnoreCase("XL")) {

			List<List<String>> uilist1 = tableAsLists(createSubnet_table);
			waitsleep(3000);
//			waitForElementToAppear(pagination_nextbutton);
			clickElement(pagination_nextbutton);
			List<List<String>> uilist2 = tableAsLists(createSubnet_table);
			List<List<String>> newList = ListUtils.union(uilist1, uilist2);
			int rows = newList.size() - 2;
			System.out.println("*************************************************************************");
			System.out.println("Total number of rows in XL sitetype are: " + rows);
			System.out.println("*************************************************************************");
			Assert.assertEquals(61, rows);
			String uilistString = newList.toString();
			List<HashMap<String, Object>> xllist = DatabaseUtil.getSelectResult(
					"select * from subnetgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "')");
			// "select * from subnetgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+// remoteSite.globalSearch + "' and createdby = '"+AutomationProfile.getProfile().userName +"')");
			for (HashMap<String, Object> row : xllist) {
				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
				System.out.println("Entered into SUBNETS - XL block");
				System.out.println(uilistString.contains(row.get("subnet").toString()));
				System.out.println(uilistString.contains(row.get("vLan").toString()));
				System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
				assertEquals(uilistString.contains(row.get("subnet").toString()), true);
				assertEquals(uilistString.contains(row.get("vLan").toString()), true);
			}
		}
	}
		
	
//	public void verifySubnetsCreationforXL(RemoteSiteRequest remoteSite) {
//
////		selectSiteSizeXL();
////
////		clickOnBuildSite();
//
//		// wait for subnet creation
////		waitsleep(500000);
//		
//		waitsleep(2000);
//
//		selectNoOfRecordsFromDropDown(remoteSite);
//
		
//
//	}

	public void verifyDnsHostCreation(RemoteSiteRequest remoteSite) {

		waitForElementToAppear(dnsHost_rec_table);
		clickElement(dnsHost_rec_table);
		selectNoOfRecordsFromDropDown(remoteSite);
		if ((((remoteSite.siteSize).equalsIgnoreCase("P")) || ((remoteSite.siteSize).equalsIgnoreCase("S"))|| ((remoteSite.siteSize).equalsIgnoreCase("M")))) {
			List<List<String>> uilist = tableAsLists(createSubnet_table);
			String uilistString = uilist.toString();

			List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult(
					"select * from dnsgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '" + AutomationProfile.getProfile().userName+ "')");

			System.out.println(list);
			for (HashMap<String, Object> row : list) {

				assertEquals(uilistString.contains(row.get("hostName").toString()), true);
				assertEquals(uilistString.contains(row.get("ipAddress").toString()), true);
				assertEquals(uilistString.contains(row.get("vLan").toString()), true);

			}
		} else if ((remoteSite.siteSize).equalsIgnoreCase("L") || ((remoteSite.siteSize).equalsIgnoreCase("XL"))) {
			
			
				int elesize = getXpathCount("//table[@class='subnettable']/following::p-paginator[@styleclass='ui-paginator-bottom']/div/span[2]/a");
				int i;
				List<List<String>> uilist1 = tableAsLists(createSubnet_table);
				
				for (i=1; i<=elesize-1; i++)
				{				
					waitForElementToAppear(pagination_nextbutton);
					clickElement(pagination_nextbutton);
					List<List<String>> uilist2 = tableAsLists(createSubnet_table);
					List<List<String>> newList = ListUtils.union(uilist1, uilist2);	
								
					if (i==elesize-1){
					String uilistString = newList.toString();
					System.out.println("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
					System.out.println(uilistString);
					System.out.println("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
					
					List<HashMap<String, Object>> xllist = DatabaseUtil.getSelectResult(
							"select * from dnsgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '" + AutomationProfile.getProfile().userName+ "');");
					
					System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
					System.out.println(xllist);
					System.out.println(")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))");
					
					for (HashMap<String, Object> row : xllist) {
						assertEquals(uilistString.contains(row.get("hostName").toString()), true);
						assertEquals(uilistString.contains(row.get("ipAddress").toString()), true);
						assertEquals(uilistString.contains(row.get("vLan").toString()), true);
						}
					}				
				
				}
		}
	}

			
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			
			
//			List<List<String>> uilist1 = tableAsLists(createSubnet_table);
//			waitForElementToAppear(pagination_nextbutton);
//			clickElement(pagination_nextbutton);
//			List<List<String>> uilist2 = tableAsLists(createSubnet_table);
//			List<List<String>> newList = ListUtils.union(uilist1, uilist2);
//			int rows = newList.size() - 2;
//			System.out.println("*************************************************************************");
//			System.out.println("Total number of rows in XL sitetype are: " + rows);
//			System.out.println("*************************************************************************");
//			Assert.assertEquals(61, rows);
//			String uilistString = newList.toString();
//			List<HashMap<String, Object>> xllist = DatabaseUtil.getSelectResult(
//					"select * from dnsgenerated where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '" + AutomationProfile.getProfile().userName+ "')");
//			for (HashMap<String, Object> row : xllist) {
//				assertEquals(uilistString.contains(row.get("hostName").toString()), true);
//				assertEquals(uilistString.contains(row.get("ipAddress").toString()), true);
//				assertEquals(uilistString.contains(row.get("vLan").toString()), true);
//
//			}
//
		

	
	
	
	
	public void subnetsClearance(RemoteSiteRequest remoteSite) {

		String containerType = null;
		String colname = null;
		
		if ((remoteSite.testDescription).contains("subnet containers")){
			containerType = "subnetgenerated";
			colname = "subnetGeneratedId";
		}
		else if ((remoteSite.testDescription).contains("DHCP containers")){
			containerType = "dhcpgenerated";
			colname = "dhcpGeneratedId";
		}
		else if ((remoteSite.testDescription).contains("DNS containers")){
			containerType = "dnsgenerated";
			colname = "dnsGeneratedId";
		}
		
		
		List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult("select * from "+containerType+" where requestid IN (select requestid from automation_requests where pr_mailroute = '"+ remoteSite.globalSearch + "' and createdby = '"+ AutomationProfile.getProfile().userName +"')");
				
		for (HashMap<String, Object> dbrow : list) {
			
				DatabaseUtil.deleteData("DELETE FROM "+containerType+" WHERE "+colname+" ='"+dbrow.get(""+colname+"").toString()+"'");
			
		}
	}
	
	public void automationReqClearance(RemoteSiteRequest remoteSite) {
		
		List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult("select * from automation_requests where pr_proj_id = '"+remoteSite.projectId+"' and pr_mailroute = '"+remoteSite.mailRoute+"'");
				
		for (HashMap<String, Object> dbrow : list) {
				DatabaseUtil.deleteData("DELETE FROM automation_requests WHERE requestid ='"+dbrow.get("requestid").toString()+"'");
		}
	}
	
	
	public void shelfContainerupdation(RemoteSiteRequest remoteSite) {
		
		waitsleep(1000);
		List<HashMap<String, Object>> list = DatabaseUtil.getSelectResult("select * from containerconfig;");
		for (HashMap<String, Object> dbrow : list) {
			
			DatabaseUtil.updateData("update containerconfig set allocatedStatus='NO', sitecode=null, projId=null where sitecode='"+remoteSite.mailRoute+"' and projId='"+remoteSite.projectId+"';");
		}
	}
	
	
	
	public void logoutapp() {

		waitForElementToAppear(logout_application);
		clickElement(logout_application);

	}


	

}
