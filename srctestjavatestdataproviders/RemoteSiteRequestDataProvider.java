package com.optum.remoteSite.testDataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import com.optum.automation.coreframework.dataprovider.TestData;
import com.optum.remoteSite.databeans.RemoteSiteRequest;

public class RemoteSiteRequestDataProvider {

	@DataProvider(name = "InvalidData")
	public static Iterator<Object[]> InValidData() {

		return TestData.getData(RemoteSiteRequest.class, "InvalidData");
	}

	@DataProvider(name = "InvalidObjectExistanceVerification")
	public static Iterator<Object[]> InvalidObjectExistanceVerification() {

		return TestData.getData(RemoteSiteRequest.class, "InvalidObjectExistanceVerification");
	}
	
	
	@DataProvider(name = "NoProjectFound")
	public static Iterator<Object[]> NoProjectFound() {

		return TestData.getData(RemoteSiteRequest.class, "NoProjectFound");
	}

	
	@DataProvider(name = "VerifySubnetsCreationwithoutselectingSiteType")
	public static Iterator<Object[]> SelectsiteTypeCheckForSubnet() {
		return TestData.getData(RemoteSiteRequest.class, "VerifySubnetsCreationwithoutselectingSiteType");
	}
	
	@DataProvider(name = "VerifyContainersAvailability")
	public static Iterator<Object[]> VerifyavailabilityofContainers() {
		return TestData.getData(RemoteSiteRequest.class, "VerifyContainersAvailability");
	}	
	
	
	@DataProvider(name = "CreatesOnlySubnets")
	public static Iterator<Object[]> CreateSubnet() {

		return TestData.getData(RemoteSiteRequest.class, "CreatesOnlySubnets");
	}
		

	
	@DataProvider(name = "VerifySubnetsCreationwhenConatinerisEmpty")
	public static Iterator<Object[]> SubnetCheckwhenContainerisEmpty() {
		return TestData.getData(RemoteSiteRequest.class, "VerifySubnetsCreationwhenConatinerisEmpty");
	}

	@DataProvider(name = "CreateSubnetsWithDHCP")
	public static Iterator<Object[]> SubnetscreationwithDHCP() {
		return TestData.getData(RemoteSiteRequest.class, "CreateSubnetsWithDHCP");
	}

	@DataProvider(name = "CreateSubnetsWithDNS")
	public static Iterator<Object[]> SubnetscreationwithDNS() {
		return TestData.getData(RemoteSiteRequest.class, "CreateSubnetsWithDNS");
	}


	@DataProvider(name = "VerifyDecomNotificationMessage")
	public static Iterator<Object[]> VerificationOfDecomNotification() {
		return TestData.getData(RemoteSiteRequest.class, "VerifyDecomNotificationMessage");
	}
	
	
	@DataProvider(name = "VerifyAllocatedStatusAfterDecom")
	public static Iterator<Object[]> VerifyAllocatedStatusAfterDecom() {
		return TestData.getData(RemoteSiteRequest.class, "VerifyAllocatedStatusAfterDecom");
	}
	
	@DataProvider(name = "VerifyParallelDecom")
	public static Iterator<Object[]> VerifyParallelDecom() {
		return TestData.getData(RemoteSiteRequest.class, "VerifyParallelDecom");
	}
	
	
	@DataProvider(name = "Containersclearance")
	public static Iterator<Object[]> Containersclearance() {
		return TestData.getData(RemoteSiteRequest.class, "Containersclearance");
	}
	
	
	
	

//	@DataProvider(name = "ValidateaAndClearContainers")
//	public static Iterator<Object[]> InvalidCase() {
//
//		return TestData.getData(RemoteSiteRequest.class, "ValidateaAndClearContainers");
//
//	}

	// @DataProvider(name = "sampletest")
	// public static Iterator<Object[]>Testcase () {
	//
	// return TestData.getData(RemoteSiteRequest.class, "sampletest");
	//
	// }

	 
	 
}