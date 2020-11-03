package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	// Variable of type WebDriver
	protected WebDriver driver;
	//Variable of type Logger
	protected Logger log;

	// Create Driver Method
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browser, ITestContext ctx) {
		
		// Getting current XML test name
		String testName = ctx.getCurrentXmlTest().getName();
		
		log = LogManager.getLogger(testName);
		
		BrowserDriverFactory facftory = new BrowserDriverFactory(browser,log);
		driver = facftory.createDriver();

		// Maximize window
		driver.manage().window().maximize();
		log.info("Window maximized");
	}

	// Ending session
	@AfterMethod(alwaysRun = true)
	public void endSession() {
		// End session
		driver.quit();
		log.info("Session ended.");
	}

}