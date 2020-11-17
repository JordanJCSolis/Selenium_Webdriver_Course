package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	// Find all elements that use same locator
	protected List<WebElement> findAll(By locator){
		return driver.findElements(locator);
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
	
	// Get current page title
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	// Get current page source
	public String getCurrentPageSource() {
		return driver.getPageSource();
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
	
	
	// Wait for alert to be present and then switch WebDriver driver into Alert
	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	// Switch to window
	public void switchToWindowWithTitle(String expectedTitle) {
		String firstwindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIteratior = allWindows.iterator();
		
		while(windowsIteratior.hasNext()){
			String windowHandle = windowsIteratior.next().toString();
			if(!windowHandle.equals(firstwindow)) {
				driver.switchTo().window(windowHandle);
				if(getCurrentPageTitle().equals(expectedTitle)) {
					break;
				}
			}
		}
	}
	
	
	// Switch to frame
	protected void switchToFrame(By frameLocator) {
		driver.switchTo().frame(find(frameLocator));
	}
	
	// Press key on locator
	protected void pressKey(By locator, Keys key) {
		find(locator).sendKeys(key);
	}
	
	// Press key without locator
	public void pressKeywithActions(Keys key) {
		log.info("Pressing: " + key.name() + " using Actions class");
		Actions action = new Actions(driver);
//		action.sendKeys(key).build().perform();
		action.sendKeys(key).perform();
	}

	// Constructor
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

}
