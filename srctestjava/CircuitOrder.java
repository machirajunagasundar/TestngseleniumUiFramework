package com.optum.remoteSite.databeans;

public class CircuitOrder {

	public String testCaseID;
	public String testDescription;
	public String order_number;
	public String vendor;
	public String domestic_international;
	public String city;
	public String requestor1_mailid;
	public String new_change;
	public String mail_code;
	public String business;
	public String state;
	public String connection_type;
	public String circuit_type;
	public String access_carrier;
	public String lec_circuitId;
	public String carrier_circuitId;
	public String same_access_carrier;
	public String ip_config_info;	
	public String nspg_received;
	public String lec_install_date;
	public String ixc_due;
	public String uhg_turnup;
	public String cancel_date;
	public String date_sent_to_vendor;
	public String lec_delivered;
	public String ixc_complete;
	public String ready_for_activation;
	public String add_Notes;
	public String file_Path;
	public String alert_message;

	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",testCaseID,testDescription,order_number,vendor,domestic_international,city,requestor1_mailid,new_change,mail_code,business,state,connection_type,circuit_type,access_carrier,lec_circuitId,carrier_circuitId,same_access_carrier,ip_config_info,nspg_received,lec_install_date,ixc_due,uhg_turnup,cancel_date,date_sent_to_vendor,lec_delivered,ixc_complete,ready_for_activation,add_Notes,file_Path,alert_message);
	}
}
