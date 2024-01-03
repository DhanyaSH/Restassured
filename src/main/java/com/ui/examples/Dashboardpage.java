package com.ui.examples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboardpage extends BrowserUtil {

	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(),\"Create Job\")]/../../..");
	private static final By USERNAME_ICON_LOCATOR = By
			.xpath("//mat-icon[@data-mat-icon-name=\"user-circle\"]/../../..");
	private static final By USERNAME_TEXT_LOCATOR = By.xpath("//span[contains(text(),\"Signed in as\")]/../span[2]");
	private WebDriver wd;

	public Dashboardpage(WebDriver wd) {
		super(wd);
		this.wd = wd;
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		clickOn(USERNAME_ICON_LOCATOR);
		String username = getVisibleText(USERNAME_TEXT_LOCATOR);
		return username;
	}

	public CreateJobPage goTocreateJobPage() {

		clickOn(CREATE_JOB_LINK_LOCATOR);
		CreateJobPage createJobPage = new CreateJobPage(wd);
		return createJobPage;
	}

}
