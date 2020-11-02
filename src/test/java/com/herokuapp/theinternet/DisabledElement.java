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

public class DisabledElement {
	
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
  public void disabledElementTest() {
	  
	  // Create two WebElements (button enable and text field.
	  
	  // Locate Enable button
	  WebElement enabledButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
	  
	  // Locate	textbox
	  WebElement inputTextBox = driver.findElement(By.xpath("//input[@type='text']"));
	  
	  // Note: There are few elements with xpath //button and //input,
	  // Use element text "//tag[contains(text(),'text')]" field
	  
	  // Click on button to enable input field
	  enabledButton.click();
	  
	  // Create WebDriverWait
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  
	  // Wait until inputTextBox gets activated
	  wait.until(ExpectedConditions.elementToBeClickable(inputTextBox));
	  
	  // Type text into field
	  String text = "Disabled Element Test";
	  inputTextBox.sendKeys(text);
	  
	  // Assertion
	  Assert.assertEquals(inputTextBox.getAttribute("value"), text);
	  
  }
  
}
