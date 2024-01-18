package com.ui.pages;

import org.joda.time.field.DecoratedDateTimeField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.github.javafaker.PhoneNumber;
import com.ui.pojo.CreatejobPojo;
import com.utility.BrowserUtil;

public class CreateJobPage extends BrowserUtil {


//    private static final By OEM_LOCATOR = By.xpath("//span[contains(text(),\"Select OEM\")]/../../..");
//	private static final By PRODUCT_NAME_DROPDOWN = By.xpath("//mat-select[@placeholder=\"Select Product name\"]");
//	private static final By MODAL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Model name\"]/..");
//	private static final By SELECT_PLATFORM_LOCATOR = By.xpath("//input[@data-placeholder = \"Select Platform\"]");
//	private static final By SELECT_ALTERNATE_EMILID_LOCATOR = By.xpath("//input[@data-placeholder=\"Alternate Email Id.\"]")
//	private static final By SELECT_SERVICE_LOCATION_LOCATOR= By.xpath("//input[@data-placeholder=\"serviceLocation\"]");
//	private static final By SELECT_CLEAR_LOCATOR= By.xpath("//span[contains(text(),\"Clear\")]/..");
	private static final By OEM_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select OEM\"]/..");
	private static final By PRODUCT_NAME_DROPDOWN = By.xpath("//span[contains(text(),\"Select Product name\")]/../../../..");
	private static final By MODAL_NAME_DROPDOWN_LOCATOR = By.xpath("//mat-select[contains(@placeholder,'Select Model name')]");
	private static final By IMEI_NUMBER_LOCAATOR = By.xpath("//input[@data-placeholder=\"0123456789\"]");
	private static final By DATE_OF_PURCHASE_LOCATOR = By.xpath("//input[@data-placeholder=\"dd/mm/yyyy\"]");
	private static final By WARRANTY_STATUS_LOCATOR = By.xpath("//mat-select[@placeholder = \"Select Warranty Status\"]");
	private static final By SELECT_PROBLEM_LOCATOR = By.xpath("//mat-select[@placeholder=\"Select Problem\"]");
	private static final By SELECT_REMARKS_LOCATOR = By.xpath("//input[@data-placeholder=\"Remarks\"]");
	private static final By SELECT_FIRST_NAME_LOCATOR = By.xpath("//input[@data-placeholder=\"First Name\"]");
	private static final By SELECT_LAST_NAME_LOCATOR = By.xpath("//input[@data-placeholder=\"Last Name]\"]");	
	private static final By SELECT_CONTACT_NUMBER_LOCATOR = By.xpath("//input[@data-placeholder=\"Contact No.\"]");
	private static final By SELECT_EMAIL_ADDRESS_LOCATOR = By.xpath("//input[@data-placeholder=\"Email Id.\"]");
	private static final By SELECT_FLAT_SOCIETY_LOCATOR = By.xpath("//input[@data-placeholder=\"Flat/Society No.\"]");
	private static final By SELECT_APARTMENT_NAME_LOCATOR = By.xpath("//input[@data-placeholder=\"Apartment Name\"]");
	private static final By SELECT_LANDMARK_LOCATOR = By.xpath("//input[@data-placeholder=\"Choose a Landmark\"]");
	private static final By SELECT_STREET_LOCATOR = By.xpath("//input[@data-placeholder=\"Street Name.\"]");
	private static final By SELECT_AREA_LOCATOR = By.xpath("//input[@data-placeholder=\"Area\"]");
	private static final By SELECT_COUNTRY_LOCTOR = By.xpath("//input[@data-placeholder=\"Country\"]");
	private static final By SELECT_SELECT_STATE_LOCTOR= By.xpath("//input[@data-placeholder=\"Select State\"]");
    private static final By SELECT_PINCODE_LOCATOR= By.xpath("//input[@data-placeholder=\"Pincode\"]");
	private static final By SELECT_SUBMIT_LOCATOR= By.xpath("//span[contains(text(),\"Submit\")]/..");
	private static final By JOB_TOAST_LOCATOR =By.xpath("//span[contains(text(),\"Job created successfully\")]");

	public CreateJobPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		super(wd);
	}

//	public void createJob(String OemName, String productName, String modal,String firstname) {
//		System.out.println("Create Job Code....");
//		selectFromdropDown(OEM_LOCATOR, OemName);
//		selectFromdropDown(PRODUCT_NAME_DROPDOWN, productName);
//		selectFromdropDown(MODAL_NAME_DROPDOWN_LOCATOR, modal);
//		selectFromdropDown(SELECT_FIRST_NAME_LOCATOR,firstname);
//	}
	
	public void createJob(CreatejobPojo data) {
		System.out.println("Create Job Code....");
		selectFromdropDown(OEM_LOCATOR, data.getOemName());
		selectFromdropDown(PRODUCT_NAME_DROPDOWN, data.getProductName());
     	selectFromdropDown(MODAL_NAME_DROPDOWN_LOCATOR, data.getModelName());
    	selectFromdropDown(IMEI_NUMBER_LOCAATOR,data.getImeiNumber());
    	selectFromdropDown(DATE_OF_PURCHASE_LOCATOR,data.getDateofPurchase());
    	selectFromdropDown(WARRANTY_STATUS_LOCATOR,data.getWarrantyStatus());
    	selectFromdropDown(SELECT_PROBLEM_LOCATOR,data.getSelectProblem());
    	selectFromdropDown(SELECT_REMARKS_LOCATOR,data.getRemarks());
    	selectFromdropDown(SELECT_FIRST_NAME_LOCATOR,data.getFirstname());
    	selectFromdropDown(SELECT_LAST_NAME_LOCATOR,data.getLastname());
    	selectFromdropDown(SELECT_CONTACT_NUMBER_LOCATOR ,data.getContactNumber());
    	selectFromdropDown(SELECT_EMAIL_ADDRESS_LOCATOR,data.getEmailid());
    	selectFromdropDown(SELECT_FLAT_SOCIETY_LOCATOR,data.getFlat());
    	selectFromdropDown(SELECT_APARTMENT_NAME_LOCATOR,data.getApartmentName());
    	selectFromdropDown(SELECT_LANDMARK_LOCATOR,data.getLandmark());
    	selectFromdropDown(SELECT_STREET_LOCATOR ,data.getStreetName());
    	selectFromdropDown(SELECT_AREA_LOCATOR ,data.getArea());
    	selectFromdropDown(SELECT_COUNTRY_LOCTOR ,data.getCountry());
    	selectFromdropDown(SELECT_SELECT_STATE_LOCTOR,data.getState());
    	selectFromdropDown(SELECT_PINCODE_LOCATOR,data.getPincode());
    	selectFromdropDown(SELECT_SUBMIT_LOCATOR,data.getSubmit());  	
    	selectFromdropDown(JOB_TOAST_LOCATOR,data.getJobtoast());
    	
	}

}
