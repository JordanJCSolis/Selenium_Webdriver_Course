package com.herokuapp.theinternet.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


@Listeners(com.herokuapp.theinternet.base.TestListener.class)
public class BaseTest {

	// Variable of type WebDriver
	protected WebDriver driver;
	// Variable of type Logger
	protected Logger log;

	//
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	// Create Driver Method
	@Parameters({"browser", "chromeProfile", "deviceName"})
	@BeforeMethod(alwaysRun = true)
	public void setup(Method method, @Optional("chrome") String browser, 
			@Optional String profile, @Optional String deviceName, ITestContext ctx) {

		// Getting current XML test name
		String testName = ctx.getCurrentXmlTest().getName();

		log = LogManager.getLogger(testName);

		BrowserDriverFactory facftory = new BrowserDriverFactory(browser, log);
		if (profile != null) {
			driver = facftory.createChromeWithProfile(profile);
		} else if (deviceName != null){
			driver = facftory.createChrimeWithMobileEmulation(deviceName);
		} else {
			driver = facftory.createDriver();
		}

		// Maximize window
		driver.manage().window().maximize();
		log.info("Window maximized");

		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	// Ending session
	@AfterMethod(alwaysRun = true)
	public void endSession() {
		// End session
		driver.quit();
		log.info("Session ended.");
	}

}