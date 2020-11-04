package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageObject {

	private WebDriver driver;
	private Logger log;

	
	// Constructor
	public SecureAreaPageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

}
