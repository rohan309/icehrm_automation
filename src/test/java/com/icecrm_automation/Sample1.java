package com.icecrm_automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample1 {

	@Test
	public void sample1test1() {
		System.out.println("This is test1 method from sample class");
		Object[][] obj = new Object[][] { { 1, 2 }, { 3, 4 } };
		System.out.println(obj[0][0]);
		System.out.println(obj[0][1]);
		System.out.println(obj[1][0]);
		System.out.println(obj[1][1]);
	}

	@DataProvider
	public Object[][] credentials() {
		return new Object[][] { 
			{ "username1", "password1" }, 
			{ "username2", 123 }, 
			{ "username3", "" },
			{ "username4", null }, 
			{ "username5", false } };
	}
@Test(dataProvider = "credentials")
	public void sample1test2(String username, Object password) {
		System.out.println("UN :"+username +" PWD :"+password);
	}
}








