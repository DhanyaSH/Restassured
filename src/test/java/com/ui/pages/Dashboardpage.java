package com.ui.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.DashboardTablePojo;
import com.utility.BrowserUtil;
import com.utility.TestUtility;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public class Dashboardpage extends BrowserUtil {

	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(),\"Create Job\")]/../../..");
	private static final By USERNAME_ICON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name=\"user-circle\"]/../../..");
	private static final By USERNAME_TEXT_LOCATOR = By.xpath("//span[contains(text(),\"Signed in as\")]/../span[2]");
	private static final By CREATED_JOB_LOCATOR = By.xpath("//div[contains(text(),\"Created today\")]/../div/button");
	private static final By TABLE_LOCATOR = By.tagName("mat-table"); // only onetable so you can use tagname
	private static final By TABLE_ROW_LOCATOR = By.xpath(".//mat-row"); //for chaninng we need to use xpath
	private static final By TABLE_CELL_LOCATOR = By.xpath(".//mat-cell");

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

//	public List<DashboardTablePojo> getDetailsFromtheTable() {
//		clickOn(CREATED_JOB_LOCATOR);
//		List<DashboardTablePojo> dataList = getListOfElements(TABLE_LOCATOR, TABLE_ROW_LOCATOR, TABLE_CELL_LOCATOR);
//		Iterator<DashboardTablePojo> dataIterator = dataList.iterator();
//		while (dataIterator.hasNext()) {
//			System.out.println(dataIterator.next());
//
//		}
//		return dataList;
//	}

	public boolean verifyIfTableEnteriesArePresent (DashboardTablePojo data) {
		clickOn(CREATED_JOB_LOCATOR);
		List<DashboardTablePojo> dataList = getListOfElements(TABLE_LOCATOR, TABLE_ROW_LOCATOR, TABLE_CELL_LOCATOR);
		return TestUtility.searchEntryInList(dataList, data);
	}
}
