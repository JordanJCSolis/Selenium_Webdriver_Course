package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })

	public void negativeLoginTest(String username, String password, String expectedMessage) {
		log.info("Starting Negative Login Test");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		log.info("URL open");

		sleep(1000);

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		log.info("Username text box located successfully");

		// Type incorrect username
		usernameField.sendKeys(username);
		log.info("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		log.info("Password text box located successfully");

		// Type correct password
		passwordField.sendKeys(password);
		log.info("Password typed");

		sleep(2000);

		// locate Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		log.info("Login button located successfully");

		// Clicking button
		loginButton.click();
		log.info("Click successfully");

		sleep(2000);

		// Validation

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		log.info("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

}
