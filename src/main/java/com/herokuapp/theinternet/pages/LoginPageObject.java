package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject{
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.tagName("button");
	private By errorMessage = By.id("flash");

	
	// Execute Login
	public SecureAreaPageObject login(String username, String password) {
		log.info("Executing login with username [" + 
				username + "] and password [" + 
				password + "]");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
		return new SecureAreaPageObject(driver, log);
	}
	
	public void waitForErrorMessage() {
		waitForVisibility(errorMessage, 5);
	}
	
	public String getErrorMessageText() {
		return find(errorMessage).getText();
	}
	
	// Constructor
	public LoginPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
