package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

		switch (browser.toLowerCase()) {

		case "chrome":
			// Create Chrome Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Google Chrome Webdriver Created.");
			break;

		case "firefox":
			// Create Firefox Driver
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox Webdriver Created.");
			break;

		default:
			// Create Chrome Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Google Chrome Webdriver Created.");
			break;
		}


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