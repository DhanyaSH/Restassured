package com.ui.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.Loginpage;
import com.ui.pojo.CreatejobPojo;
import com.utility.TestUtility;
import com.github.javafaker.Faker;
import com.ui.pages.*;
import com.ui.pojo.*;
public class CreatejobPageTest {
	public class LoginTest {
		private WebDriver wd;
		private Loginpage page;
		CreatejobPojo data; 
		@BeforeMethod(description = "Setup the Browser and load the page")
		public void setup() {
			wd = new ChromeDriver();
			page = new Loginpage(wd);
			Faker faker = new Faker();
			String fName = faker.name().name();
//    data= new CreatejobPojo("Google","Nexus 2","Nexus 2 blue","12345678901234","11/10/2023","In Warrenty","Smatphone is running slow","done","Dhanya","chandran","9446423672","dhanyacm25@gmail.com","21","radha","lulu","kannur","kannur","india","india","670741");
			data = TestUtility.createFakeData();
		}

		@Test()
		public void testLoginForWebSite() {

		page.doLogin("iamfd", "password").goTocreateJobPage().createJob(data);

	
		}
	}
}
	

