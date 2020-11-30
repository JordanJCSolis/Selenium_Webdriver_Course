package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
	

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	// Constructor
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;	
	}
	
	
	public WebDriver createDriver() {

		log.info(browser + " driver created");
		
		switch (browser) {

		case "chrome":
			// Create Chrome Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			// Create Firefox Driver
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;

		default:
			// Create Chrome Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
	
	// Create Chrome Driver with profile
	public WebDriver createChromeWithProfile(String profile) {
		log.info("Starting Chrome driver with profile: " + profile);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("user-data-dir=src/main/resources/Profiles/" + profile);
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}
}
