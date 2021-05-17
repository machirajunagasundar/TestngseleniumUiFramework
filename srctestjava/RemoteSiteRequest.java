package com.optum.remoteSite.databeans;

public class RemoteSiteRequest {

	
	public String testCaseID;
	public String testDescription;
	public String globalSearch;
	public String siteDetails;
	public String status;
	public String legalmailroute;
	public String address;
	public String city;
	public String state;
	public String zipCode;
	public String country;
	public String projectId;
	public String mailRoute;
	public String statusColumn;
	public String mailRouteheader;
	public String siteSize;
	
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",testCaseID,testDescription,globalSearch,siteDetails,status,legalmailroute,address,state,city,zipCode,country,statusColumn,projectId,mailRoute,mailRouteheader,siteSize);
	}
}
