package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePageObject{
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.tagName("button");

	
	// Execute Login
	public SecureAreaPageObject login(String username, String password) {
		log.info("Executing login with username [" + 
				username + "] and password [" + 
				password + "]");
//		driver.findElement(usernameLocator).sendKeys(username);
		type(username, usernameLocator);
//		driver.findElement(passwordLocator).sendKeys(password);
		type(password, passwordLocator);
//		driver.findElement(loginButtonLocator).click();
		click(loginButtonLocator);
		return new SecureAreaPageObject(driver, log);
	}
	
	// Constructor
	public LoginPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
