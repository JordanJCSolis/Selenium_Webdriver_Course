package com.herokuapp.theinternet;

import org.openqa.selenium.By;
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

public class StaleElementReferenceException {
	
	// Variable of type WebDriver
		private WebDriver driver;

		// Create Driver Method
		@Parameters({"browser"})
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
			String url = "http://the-internet.herokuapp.com/dynamic_controls";
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
  public void staleElementTest() {
	  
	  
	  // Find Checkbox
	  WebElement checkbox = driver.findElement(By.id("checkbox"));
	  
	  // Locate remove button
	  WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
	  
	  // Click remove button
	  removeButton.click();
	  
	  // Create WebDriverWait
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
//	  // Wait until checkbox is invisible
//	  wait.until(ExpectedConditions.invisibilityOfAllElements(checkbox));
//	  
//	  // Assert
//	  Assert.assertFalse(checkbox.isDisplayed()); 
	  
//	  Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkbox)));
	  
	  Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkbox)));
	  
	  // Identify Add button
	  WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
	  
	  // Click Add button
	  addButton.click();
	  
	  // Wait for checkbox visibility
	  checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));	  

	  // Assert
	  Assert.assertTrue(checkbox.isDisplayed());
	  
  }
  
}
