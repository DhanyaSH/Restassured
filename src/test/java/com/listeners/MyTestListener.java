package com.listeners;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.TestUtility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Arrays.*;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
	private ExtentReports extentReports;
	private ExtentTest  extentTest;
	private ExtentSparkReporter extentSparkReporter;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
      System.out.println("*****************"+result.getMethod().getMethodName()+"TestStarted**************");   //+result gives name of the test metod
    
      //
      System.out.println("*****************"+result.getMethod().getDescription ()+"**************"); //+result gives the test description
      System.out.println("*****************"+Arrays.toString(result.getMethod().getGroups())+"**************"); //+result gives the test group describedd in testng test annotation
       
       extentTest = extentReports.createTest(result.getMethod().getMethodName()) ;  
       //new test is getting started attach this information in the reports   
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    System.out.println("******************Sucess*****************");
        extentTest.pass("test passed");
        //if test is pass it will be attached in the reports
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		  System.out.println("******************Failure****************");
		  extentTest.pass("failed"); 
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
		//testsuite start
		// TODO Auto-generated method stub
		System.out.println("*****************TestSuite Started******************");
	File reportsDirectory = new File(System.getProperty("user.dir")+"/report"); 
	//creating report folder automatically  with help of apache commonio. 
			try {
			FileUtils.forceMkdir(reportsDirectory ); 
			//create a directory using file util class
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//where we want to create a directory as a file object
	extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/report/report"+ TestUtility.gettime()+".html" );//WHERE HTML REPORT NEED TO BE CREATED
	extentReports = new ExtentReports();
	//to this object attaching the reporter
	extentReports.attachReporter(extentSparkReporter); 
	}
	
//first create an object of ExtentSparkReporter,wer we are telling wer file will be created
//then create an object of ExtentReports
//to this extentReports we r creating a reporter.(  extentReports is responsible for attaching tests,creating reports,dumping the data all are taken care by  extentReports)
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("******************TestSuite finished*********************");
		extentReports.flush(); //final closure of report
	}
	

}
