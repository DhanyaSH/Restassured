package com.ui.examples;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchScript1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.get("http://phoenix.testautomationacademy.in/sign-in");             // get method is the http GET verb(using selenium
																	           // methods directly).
		wd.manage().window().maximize();                                       // chaining of methods //this is how we maximize the browser

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		By userNameTextBoxLocator = By.id("username"); //by.id is a locator//locator is a way to decide webdriver to find the element
		WebElement userNameTextBoxWebElement = wd.findElement(userNameTextBoxLocator); //once element is foundit will return web  element.
		userNameTextBoxWebElement.clear();
		userNameTextBoxWebElement.sendKeys("iamsup"); 

		By passwordTextBoxLocator = By.id("password");
		WebElement passwordTextBoxWebElement = wd.findElement(passwordTextBoxLocator);
		passwordTextBoxWebElement.clear();
		passwordTextBoxWebElement.sendKeys("password");

		By signInButtonLocator = By.xpath("//span[contains(text(),\"Sign in \")]/../..");
		WebElement signButtonWebElement = wd.findElement(signInButtonLocator);
		signButtonWebElement.click();

	}
}