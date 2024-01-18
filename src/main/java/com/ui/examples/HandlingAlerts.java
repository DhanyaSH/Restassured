package com.ui.examples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver wd = new ChromeDriver();
		Thread.sleep(2000);
		wd.get("http://139.59.91.96:5001/selenium-workbook/popups.html");
		By alertButtonLocator = By.id("alert");
		WebElement alertButtonElement = wd.findElement(alertButtonLocator);
		alertButtonElement.click();
		
		//how to handle alerts in webdriver
		Thread.sleep(2000);
	
//		Alert alert =  wd.switchTo().alert();
//		String dataString = alert.getText();
//		System.out.println(dataString);
//		
//		//click on ok button
//		alert.accept();
//		
		
		

}
}
