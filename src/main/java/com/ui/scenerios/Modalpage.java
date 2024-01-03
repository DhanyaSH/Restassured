package com.ui.scenerios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Modalpage extends BrowserUtil {

	By modalTextBoxLocator = By.xpath("//div[@class=\"modal-body\"]/p/input");
	By modalOkLocator = By.xpath("//button[contains(text(),\"Ok\")]");
	By modalCancelLocator = By.xpath("//button[contains(text(),\"Cancel\")]");
	private WebDriver wd;

	public Modalpage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public Promptpage enterText(String text) {
		enterText(modalTextBoxLocator, text);
		sleepFor(5);
		clickOn(modalCancelLocator);		
		return new Promptpage(wd);

	}
}
