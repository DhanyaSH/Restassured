package com.ui.test;
import com.utility.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pages.*;
@Listeners(com.listeners.MyUITestListener.class)

public class LoginTest {
	private WebDriver wd;
	private Loginpage page;

	@BeforeMethod(description = "Setup the Browser and load the page")
	public void setup() {
		wd = new ChromeDriver();
		page = new Loginpage(wd);
	}

	@Test(description = "login api request",groups = {"sanity"})
	public void testLoginForWebSite() {
//    page.doLogin("iamfd", "password").goTocreateJobPage().createJob(null, null);
//		String UserName = page.doLogin("iamfd", "password").getUserName();
//		System.out.println(UserName);
		
		Assert.assertEquals(page.doLogin("iamfd","password").getUserName(),"iamfd");
    
    

	}
}
