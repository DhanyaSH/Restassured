package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utility.BrowserUtil;



public class CreateJobPage extends BrowserUtil {

    private static final By OEM_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select OEM\"]/..");
//    private static final By OEM_LOCATOR = By.xpath("//span[contains(text(),\"Select OEM\")]/../../..");
//	private static final By PRODUCT_NAME_DROPDOWN = By.xpath("//span[contains(text(),\"Select Product name\")]/../../..");
   private static final By  PRODUCT_NAME_DROPDOWN = By.xpath("//mat-select[@placeholder=\"Select Product name\"]");

   public CreateJobPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		super(wd);
	}

	public void createJob(String OemName,String productName) {
		System.out.println("Create Job Code....");
		selectFromdropDown( OEM_LOCATOR ,OemName);
		selectFromdropDown( PRODUCT_NAME_DROPDOWN, productName);

	}

}
