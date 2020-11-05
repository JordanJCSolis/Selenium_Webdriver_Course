package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{
	
	private String pageUrl = "http://the-internet.herokuapp.com/";
	private By formAutenticationLinkLocator = By.linkText("Form Authentication");
	
	
	// Open Welcome Page
	public void openPage() {
		log.info("page " + pageUrl + " opened");
//		driver.get(pageUrl);
		openURL(pageUrl);
		log.info("Page opened!");
	}
	
	// Open Form Authentication (Login Page) by clicking on Form Authentication link
	public LoginPageObject clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
//		driver.findElement(formAutenticationLinkLocator).click();
		click(formAutenticationLinkLocator);
		return new LoginPageObject(driver, log);
	}

	// Constructor
	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
