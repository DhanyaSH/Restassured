package com.ui.scenerios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Promptpage extends BrowserUtil {
	

private static final By modalButtonLocator = By.linkText("Modal");
private static final By alertButtonLocator = By.id("alert");

private WebDriver wd;

public Promptpage(WebDriver wd) {
	super(wd);
this.wd = wd;

}
public Modalpage clickOnModal() {
clickOn(modalButtonLocator);
return new Modalpage(wd);

}
}
