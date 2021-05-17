package com.optum.remoteSite.testclasses;

import java.util.HashMap;
import java.util.List;
import com.optum.apiautomation.util.DatabaseUtil;

public class Sample  {

	private DatabaseUtil dbutil;
	
	public List<HashMap<String, Object>> testsample(String query) {
		
		
		System.out.println(DatabaseUtil.getSelectResult("select * from nav_requests"));
		return DatabaseUtil.getSelectResult("select * from nav_requests");
		
		
		
	}
	
	
}
