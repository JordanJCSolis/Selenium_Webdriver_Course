package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class DynamicLoading extends TestUtilities {

	@Test
	public void notVisibleTest() {

		// Open URL
		String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(url);
		System.out.println("URL open");

		// Identify start button
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));

		// Click button
		startButton.click();

		// Validation

		// Expected message
		String expectedMessage = "Hello World!";

		// Current message
		WebElement currentMessage = driver.findElement(By.id("finish"));

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Try - catch
		try {
			wait.until(ExpectedConditions.visibilityOf(currentMessage));
		} catch (TimeoutException exeption) {
			System.out.println("Exception catch: " + exeption.getMessage());
			sleep(3000);
		}
		System.out.println("process continues here");

		// Cast WebElement into String
		String actualMessage = currentMessage.getText();

		// Comparison
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		startButton.click();
	}

}