package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.Loginpage;
import com.ui.pages.*;

public class CreatejobPageTest {
	public class LoginTest {
		private WebDriver wd;
		private Loginpage page;

		@BeforeMethod(description = "Setup the Browser and load the page")
		public void setup() {
			wd = new ChromeDriver();
			page = new Loginpage(wd);
		}

		@Test()
		public void testLoginForWebSite() {

		page.doLogin("iamfd", "password").goTocreateJobPage().createJob("Google","Nexus 2");

	
		}
	}
}
	

