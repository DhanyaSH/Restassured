package com.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.utility.TestUtility;

public class LogindataProvider {
	
	
	@DataProvider(name="LoginData")
	public Iterator<String[]> loginDP() {
		return TestUtility.readCSVFile("loginData.csv");
	
	}
	
}
