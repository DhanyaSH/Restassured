package com.ui.scenerios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingModelAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();
		wd.get("http://139.59.91.96:5001/selenium-workbook/popups.html");

		By modalButtonLocator = By.linkText("Modal");
		WebElement modlButton = wd.findElement(modalButtonLocator);
		modlButton.click();

		By modalTextBoxLocator = By.xpath("//div[@class=\"modal-body\"]/p/input");
		WebElement modalTextBox = wd.findElement(modalTextBoxLocator);
		modalTextBox.sendKeys("Hello i am here");
		
		//button[contains(text(),"ok")]
		//button[contains(text(),"cancel")]
		
		

		By modalOkLocator  = By.xpath("//button[contains(text(),\"Ok\")]");
		WebElement okButton = wd.findElement(modalOkLocator);
		okButton.click();
		
		

		By modalCancelLocator  = By.xpath("//button[contains(text(),\"Cancel\")]");
		WebElement cancelButton = wd.findElement(modalCancelLocator);
		cancelButton.click();
		

	}

}
