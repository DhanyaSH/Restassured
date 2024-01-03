package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.pojo.DashboardTablePojo;
import com.ui.pojo.DashboardTablePojo.*;

public abstract class BrowserUtil {
	private WebDriver wd;
	private static WebDriver screenshotWd;
	private WebDriverWait wait;

	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd;
		screenshotWd = wd;
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}

	public void getToWebSite(String url) { // wrapper method
		wd.get(url);
	}

	public void viewInFullScreen() {
		wd.manage().window().maximize();
	}

	public void enterText(By locator, String texttoEnter) {
//		sleepFor(4);
//		WebElement element = wd.findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(texttoEnter);

	}

	public void clickOn(By locator) {
//		sleepFor(4);
//		WebElement element = wd.findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}

	public String getVisibleText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String visibleData = element.getText();
		return visibleData;

	}

	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String takeScreenShot(String testName) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) screenshotWd; // TC
		File screenShotData = takesScreenshot.getScreenshotAs(OutputType.FILE); // 1010111 111111
		File reportDirectory = new File(System.getProperty("user.dir") + "/screenshots");
		try {
			FileUtils.forceMkdir(reportDirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathname = System.getProperty("user.dir") + "/screenshots//" + testName + ".png";
		File myFile = new File(pathname);
		try {
			myFile.createNewFile();
			FileUtils.copyFile(screenShotData, myFile); // APACHE COMMON
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pathname;
	}

	public void acceptAlert() {
		Alert myAlert = wd.switchTo().alert(); // alert is handle by switching into alertmode .from webdriver we switch
												// to alert.
		myAlert.accept();

	}

	public void dissmissAlert() {
		Alert myAlert = wd.switchTo().alert();

		myAlert.dismiss();

	}

	public String getTextFromAlert() {
		Alert myAlert = wd.switchTo().alert();
		String data = myAlert.getText();
		return data;

	}

	public void switchToFrames(String frameidOrName) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameidOrName));
		wd.switchTo().frame("editor_ifr");// switch to frames

	}

	public void switchToFrames(int frameindex) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
		wd.switchTo().frame("editor_ifr");// switch to frames
	}

	public void selectFromdropDown(By dropDownlocator, String value) {
		sleepFor(5);
		clickOn(dropDownlocator);
		By oem_data_locator = By.xpath("//span[contains(text(),\"" + value + "\")]/..");// dynamic
		clickOn(oem_data_locator);
	}

	public List<DashboardTablePojo> getListOfElements(By tableLocator, By rowLocator, By cellLocator) {
		WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));
		WebElement rowElementtemp = wait.until(ExpectedConditions.visibilityOfElementLocated(rowLocator));
//		sleepFor(4);
		List<WebElement> rowList = tableElement.findElements(rowLocator);
		System.out.println(rowList.size());
		Iterator<WebElement> rowIterator = rowList.iterator();
		WebElement rowElement;
		List<WebElement> cellList;
		List<DashboardTablePojo> tableList = new ArrayList<DashboardTablePojo>();
		while (rowIterator.hasNext()) {
			rowElement = rowIterator.next();
			cellList = rowElement.findElements(cellLocator);

			tableList.add(new DashboardTablePojo(cellList.get(0).getText(), cellList.get(1).getText(),
					cellList.get(2).getText(), cellList.get(3).getText(), cellList.get(4).getText(),
					cellList.get(5).getText(), cellList.get(6).getText()));

		}
       return tableList;
	}
}
