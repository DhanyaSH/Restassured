package com.ui.scenerios;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJsAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		WebDriver wd = new ChromeDriver();
		wd.get("http://139.59.91.96:5001/selenium-workbook/popups.html");
		By alertButtonLocator = By.id("alert");
		WebElement alertElementButton = wd.findElement(alertButtonLocator);
		alertElementButton.click();

		// how to handle alerts in Wd

		Thread.sleep(2000);
		Alert myAlert = wd.switchTo().alert();
		String data = myAlert.getText();

		System.out.println(data);

		// click on ok button in thr alert pop up
		Thread.sleep(2000);
		myAlert.accept();

	}

}
