package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class DisabledElement extends TestUtilities {

	@Test
	public void disabledElementTest() {

		// Open URL
		String url = "http://the-internet.herokuapp.com/dynamic_controls";
		driver.get(url);
		log.info("URL open");

		// Create two WebElements (button enable and text field.

		// Locate Enable button
		WebElement enabledButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));

		// Locate textbox
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
