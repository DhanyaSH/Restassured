package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunTest implements IRetryAnalyzer{ //Dynamic
//	100 test executed,5 test passed
public static final int MAX_COUNT = 3;
public static  int count = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		while(count<=MAX_COUNT) {
			count= count+1;
					return true;
		}
		return false; 
	}
}


