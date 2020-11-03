package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeTest extends TestUtilities {

	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })
	public void NegativeUsernameTest() {
		log.info("Starting Negative Username Test");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		log.info("URL open");

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		log.info("Username text box located successfully");

		// Type incorrect username
		String wrongUsernameString = "invalidUsername";
		usernameField.sendKeys(wrongUsernameString);
		log.info("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		log.info("Password text box located successfully");

		// Type correct password
		String correctPassword = "SuperSecretPassword!";
		passwordField.sendKeys(correctPassword);
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

		// Expected Message
		String expectedMessage = "Your username is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		log.info("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

	@Test(priority = 2, enabled = true, groups = { "negativeTest" })
	public void NegativePasswordTest() {
		log.info("Starting Negative Password Test");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		log.info("URL open");

		sleep(1000);

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		log.info("Username text box located successfully");

		// Type correct username
		String wrongUsernameString = "tomsmith";
		usernameField.sendKeys(wrongUsernameString);
		log.info("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		log.info("Password text box located successfully");

		// Type incorrect password
		String correctPassword = "incorrectpassword";
		passwordField.sendKeys(correctPassword);
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

		// Expected Message
		String expectedMessage = "Your password is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		log.info("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

}
