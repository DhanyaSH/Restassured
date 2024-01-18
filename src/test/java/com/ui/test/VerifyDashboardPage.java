package com.ui.test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.Loginpage;
import com.ui.pojo.DashboardTablePojo;

public class VerifyDashboardPage {
	
	
  
   private WebDriver wd;
   private Loginpage page;
   private DashboardTablePojo requestedData;
   
   @BeforeMethod(description = "Verify Dashboard page")
   public void SetUp() {
	   
	   wd = new ChromeDriver();
	   page = new Loginpage(wd);
	 requestedData = new  DashboardTablePojo("Apple","JOB_28245","6190193150352503","IPhone","Iphone 11","In Warrenty","Pending For Job Assignment");
//	 requestedData = new DashboardTablePojo("JOB_28245");
	   
   }
@Test()
public void VerifyDashboardPageTableTest() {
//boolean status = page.doLogin("iamfd", "password").verifyIfTableEnteriesArePresent(requestedData);
//System.out.println(status);
	
	
	Assert.assertEquals(page.doLogin("iamfd", "password").verifyIfTableEnteriesArePresent(requestedData),true);

}

}








