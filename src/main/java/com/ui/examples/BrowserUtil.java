package com.ui.examples;

import java.time.Duration;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtil {
	private WebDriver wd;
    private WebDriverWait wait;
    
    
	public WebDriver getWd() {
		return wd;
	}

	public BrowserUtil(WebDriver wd) {
		super();
		this.wd = wd;
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
		WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(texttoEnter);

	}

	public void clickOn(By locator) {
//		sleepFor(4);
//		WebElement element = wd.findElement(locator);
		WebElement  element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

	}
     public String getVisibleText(By locator) {
 	WebElement  element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	 
  String visibleData = element.getText();
  return visibleData ;
  
  
     }
	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
