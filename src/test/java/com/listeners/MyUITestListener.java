package com.listeners;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtil;
import com.utility.TestUtility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Arrays.*;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyUITestListener implements ITestListener {
	private ExtentReports extentReports;
	private ExtentTest  extentTest;
	private ExtentSparkReporter extentSparkReporter;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
      System.out.println("*****************"+result.getMethod().getMethodName()+"TestStarted**************");
      System.out.println("*****************"+result.getMethod().getDescription ()+"**************");
      System.out.println("*****************"+Arrays.toString(result.getMethod().getGroups())+"**************");
       
       extentTest = extentReports.createTest(result.getMethod().getMethodName()) ;     
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    System.out.println("******************Sucess*****************");
        extentTest.pass("test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("******************Failure****************");
		  extentTest.fail("test failed");
		  extentTest.addScreenCaptureFromPath(BrowserUtil.takeScreenShot(result.getMethod().getMethodName()));
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("***********************skipped******************");
		  extentTest.pass("test skipped"); 
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("*****************TestSuite Started******************");
	File reportsDirectory = new File(System.getProperty("user.dir")+"/report");
		try {
			FileUtils.forceMkdir(reportsDirectory );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//where we want to create a directory as a file object
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/report/report"+ TestUtility.gettime()+".html" );//WHERE HTML REPORT NEED TO BE CREATED
	extentReports = new ExtentReports();//to this object attaching the reporter
	extentReports.attachReporter(extentSparkReporter);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("******************TestSuite finished*********************");
		extentReports.flush();
	}
	

}
