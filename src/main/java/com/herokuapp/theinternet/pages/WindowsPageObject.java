package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPageObject extends BasePageObject {

	// Fields
	private By clickHereLinkLocator = By.linkText("Click Here");
	
	// Click on link
	public void clickOnLink() {
		log.info("Clicking on Click Here link");
		click(clickHereLinkLocator);
	}
	
	// Find page with title New window and swith to it
	public NewWindowPageObject switchToNewWindowPage() {
		log.info("Lookin for 'New Window' page");
		switchToWindowWithTitle("New Window");
		return new NewWindowPageObject(driver,log);
	}
	
	// Constructor
	public WindowsPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
