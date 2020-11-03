package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NotSuchElementException extends TestUtilities {

	@Test
	public void notSuchElementException() {

		// Open URL
		String url = "https://the-internet.herokuapp.com/dynamic_loading/2";
		driver.get(url);
		System.out.println("URL open");

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
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), expectedMessage)));
	}
}
