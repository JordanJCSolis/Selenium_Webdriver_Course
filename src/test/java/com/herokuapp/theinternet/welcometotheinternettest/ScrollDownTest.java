package com.herokuapp.theinternet.welcometotheinternettest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class ScrollDownTest extends TestUtilities {

	
	@Test
	public void scrollDownTest() {
		log.info("Scroll down test");
		
		// Open Welcome Page object
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		sleep(1000);
		
		// Scrolling to bottom
		log.info("Scrolling to the bottom of the page");
		// Create JavascriptExecutor element that cast from driver to JavascriptExecutor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		sleep(1000);
		
	}
}
