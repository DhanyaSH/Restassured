package com.ui.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchScript3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver wd= new ChromeDriver(); //created webdriver object to lauch the browser
     
     Loginpage page = new Loginpage(wd); //after that crate login page ka object(then browser util object is created first ).then webdriver is intialited.
                                          
     page.doLogin("iamsup","password");
     
	}}
     
     