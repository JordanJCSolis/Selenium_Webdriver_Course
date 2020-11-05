package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	protected WebDriver driver;
	protected Logger log;
	
	
	// Open page with given URL
	protected void openURL(String url) {
		driver.get(url);
	}
	
	// Find element using given locator
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	// Click on element with given locator when it is visible
	protected void click(By locator) {
		waitForVisibility(locator, 5);
		find(locator).click();
	}
	
	// Type given text into element
	protected void type(String text, By locator) {
		waitForVisibility(locator, 5);
		find(locator).sendKeys(text);
	}
	
	// Get current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	// Wait for visibility
	protected void waitForVisibility(By locator, Integer... timeOutInSecondsIntegers) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
				(timeOutInSecondsIntegers.length > 0 ? timeOutInSecondsIntegers[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			
			attempts++;
		}
	}
	
	
	// Wait for specific ExpectedCondition for the given amount of time in seconds
	private void waitFor(ExpectedCondition<WebElement> condition,
			Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	// Constructor
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

}
