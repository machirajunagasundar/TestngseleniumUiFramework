package com.optum.remoteSite.testDataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import com.optum.automation.coreframework.dataprovider.TestData;
import com.optum.remoteSite.databeans.CircuitOrder;
import com.optum.remoteSite.databeans.RemoteSiteRequest;

public class CircuitOrderDataProvider {

	@DataProvider(name = "VerifyCircuitOrderCreation")
	public static Iterator<Object[]> VerifyCircuitOrderCreation() {

		return TestData.getData(CircuitOrder.class, "VerifyCircuitOrderCreation");
	}

	@DataProvider(name = "VerifyAuditTable")
	public static Iterator<Object[]> VerifyAuditTable() {

		return TestData.getData(CircuitOrder.class, "VerifyAuditTable");
	}

	@DataProvider(name = "VerifyColumnwithDropdownElements")
	public static Iterator<Object[]> VerifyColumnwithDropdownElements() {

		return TestData.getData(CircuitOrder.class, "VerifyColumnwithDropdownElements");
	}

	@DataProvider(name = "VerifyGlobalSearchFunctionality")
	public static Iterator<Object[]> VerifyGlobalSearchFunctionality() {

		return TestData.getData(CircuitOrder.class, "VerifyGlobalSearchFunctionality");
	}	
	
	@DataProvider(name = "VerifyNormalSearchFunctionality")
	public static Iterator<Object[]> VerifyNormalSearchFunctionality() {

		return TestData.getData(CircuitOrder.class, "VerifyNormalSearchFunctionality");
	}	
	
	@DataProvider(name = "UploadCarrierStatusSpreadsheet")
	public static Iterator<Object[]> UploadCarrierStatusSpreadsheet() {

		return TestData.getData(CircuitOrder.class, "UploadCarrierStatusSpreadsheet");
	}	
	
	@DataProvider(name = "VerifyFieldlevelValidation")
	public static Iterator<Object[]> VerifyFieldLevelValdation() {

		return TestData.getData(CircuitOrder.class, "VerifyFieldlevelValidation");
	}
	
	@DataProvider(name = "VerifyTheRequestCategory")
	public static Iterator<Object[]> VerifyTheRequestCategory() {

		return TestData.getData(CircuitOrder.class, "VerifyTheRequestCategory");
	}
	
	
}