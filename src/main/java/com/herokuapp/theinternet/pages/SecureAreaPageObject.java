package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageObject extends BasePageObject{
	
	private String pageUrl = "http://the-internet.herokuapp.com/secure";
	private By logOutButton = By.xpath("//a[@class='button secondary radius']");
	private By message = By.id("flash");
	
	// Get URL from Page
	public String getPageUrl() {
		return pageUrl;
	}
	
	// Verify if Loo Out button is visible
	public boolean isLogOutButtonVisible() {
		return find(logOutButton).isDisplayed();
	}
	
	// Return text from success message
	public String getSuccessMessageText() {
		return find(message).getText();
	}
	
	// Constructor
	public SecureAreaPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
