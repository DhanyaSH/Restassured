package com.ui.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchScript4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver wd = new ChromeDriver();
		Loginpage page = new Loginpage(wd);

		page.doLogin("iamfd", "password").goTocreateJobPage().createJob();
		// TAKE SCREEN SHORT
		TakesScreenshot takeScreenshot = (TakesScreenshot) wd; // typecasting .your webdriver got convertd to takescreenshort(convert the session which we have and have webdriver refrence created)
		//
		File screenShotData = takeScreenshot .getScreenshotAs(OutputType.FILE);	 //dumb this data to file
        File myFile = new File(System.getProperty("user.dir")+"//abc.png");
        myFile.createNewFile();
        FileUtils.copyFile(screenShotData, myFile); //apache common
		
	}

}
