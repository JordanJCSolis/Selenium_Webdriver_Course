package com.herokuapp.theinternet;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NegativeTest{

	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })
	public void NegativeUsernameTest() {
		System.out.println("Starting Negative Username Test\n\n");
		
		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("URL open");

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("Username text box located successfully");

		// Type incorrect username
		String wrongUsernameString = "invalidUsername";
		usernameField.sendKeys(wrongUsernameString);
		System.out.println("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("Password text box located successfully");

		// Type correct password
		String correctPassword = "SuperSecretPassword!";
		passwordField.sendKeys(correctPassword);
		System.out.println("Password typed");

		sleep(2000);

		// locate Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Login button located successfully");

		// Clicking button
		loginButton.click();
		System.out.println("Click successfully");

		sleep(2000);

		// Validation

		// Expected Message
		String expectedMessage = "Your username is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		System.out.println("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

	@Test(priority = 2, enabled = true, groups = { "negativeTest" })
	public void NegativePasswordTest() {
		System.out.println("Starting Negative Username Test\n\n");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("URL open");

//		// Maximize window
//		driver.manage().window().maximize();
//		System.out.println("Window maximized");

		sleep(1000);

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("Username text box located successfully");

		// Type correct username
		String wrongUsernameString = "tomsmith";
		usernameField.sendKeys(wrongUsernameString);
		System.out.println("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("Password text box located successfully");

		// Type incorrect password
		String correctPassword = "incorrectpassword";
		passwordField.sendKeys(correctPassword);
		System.out.println("Password typed");

		sleep(2000);

		// locate Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Login button located successfully");

		// Clicking button
		loginButton.click();
		System.out.println("Click successfully");

		sleep(2000);

		// Validation

		// Expected Message
		String expectedMessage = "Your password is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		System.out.println("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

	private void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Variable of type WebDriver
	private WebDriver driver;

	// Create Driver Method
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	private void createDriver(@Optional("chrome") String browser) {

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
		String url = "https://the-internet.herokuapp.com/login";
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

}
