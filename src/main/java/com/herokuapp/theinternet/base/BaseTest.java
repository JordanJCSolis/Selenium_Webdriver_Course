package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	// Variable of type WebDriver
	protected WebDriver driver;

	// Create Driver Method
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browser) {
		
		BrowserDriverFactory facftory = new BrowserDriverFactory(browser);
		driver = facftory.createDriver();

		// Maximize window
		driver.manage().window().maximize();
		System.out.println("Window maximized");
	}

	// Ending session
	@AfterMethod(alwaysRun = true)
	public void endSession() {
		// End session
		driver.quit();
		System.out.println("Session ended.");
	}

}