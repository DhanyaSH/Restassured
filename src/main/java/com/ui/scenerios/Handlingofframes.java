package com.ui.scenerios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingofframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();
		wd.get("http://139.59.91.96:5001/selenium-workbook/wyswyg-editor.html");

	By modalButtonLocator = By.tagName("h1");
		
	WebElement headingElement = wd.findElement(modalButtonLocator);
	System.out.println( headingElement.getText());
	wd.switchTo().frame("editor_ifr");//switch to frames
	
	By bodyLocator = By.id("tinymce");
	WebElement body =   wd.findElement(bodyLocator);
	body.sendKeys("abc");
	wd.switchTo().parentFrame(); //exit from child page it will switch to parent page
	System.out.println(headingElement.getText());
	
	
	
	
	}

}
