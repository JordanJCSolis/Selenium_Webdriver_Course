package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class StaleElementReferenceException extends BaseTest{

	@Test
	public void staleElementTest() {

		// Open URL
		String url = "http://the-internet.herokuapp.com/dynamic_controls";
		driver.get(url);
		System.out.println("URL open");

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
