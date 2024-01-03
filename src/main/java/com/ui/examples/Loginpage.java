package com.ui.examples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Loginpage extends BrowserUtil { // all page class extend browser utility

	private static final By USER_NAME_TEXTBOX_LOCATOR = By.id("username");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("password");
	private static final By SIGN_BUTTON_LOCATOR = By.xpath("//span[contains(text(),\"Sign in \")]/../..");
	private WebDriver wd;

	public Loginpage(WebDriver wd) { // child class constructor going to cal parent class(browser utility) constructor and does it with the help of super keyword)
		super(wd);
		this.wd = wd;
	    getToWebSite("http://phoenix.testautomationacademy.in/sign-in");
	    viewInFullScreen() ;
		// TODO Auto-generated constructor stub
	}

	public Dashboardpage doLogin(String username, String password) { // functionality//inside page you r going to have your test
														// steps
		// login page needs to access browser utility method without creating an object
	
		enterText(USER_NAME_TEXTBOX_LOCATOR, username); //enter the text in username text box and valu going to be username.
		enterText(PASSWORD_TEXTBOX_LOCATOR, password); 
		clickOn(SIGN_BUTTON_LOCATOR);
		Dashboardpage dashboardpage = new Dashboardpage(wd);
		
          return dashboardpage;
	}
}
