package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NotSuchElementException {

	// Variable of type WebDriver
	private WebDriver driver;

	// Create Driver Method
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	private void setUp(@Optional("chrome") String browser) {

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

		// Open URL
		String url = "https://the-internet.herokuapp.com/dynamic_loading/2";
		driver.get(url);
		System.out.println("URL open");

		// Maximize window
		driver.manage().window().maximize();
		System.out.println("Window maximized");
	}

	// Ending session
	@AfterMethod(alwaysRun = true)
	private void endSession() {
		// End session
		driver.quit();
		System.out.println("Session ended.");
	}

	@Test
	public void notSuchElementException() {

		// Identify start button
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));

		// Click button
		startButton.click();

		// Validation

		// Expected message
		String expectedMessage = "Hello World!";

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

//		// Getting current message
//		WebElement currentMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.id("finish")));
//
//		// Cast WebElement into String
//		String actualMessage = currentMessage.getText();
//
//		// Comparison
//		Assert.assertTrue(actualMessage.contains(expectedMessage));

		Assert.assertTrue(
				wait.until(ExpectedConditions.textToBePresentInElementLocated(
						By.id("finish"), expectedMessage)));
	}

	private void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
