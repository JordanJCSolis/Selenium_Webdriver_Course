package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeTest extends TestUtilities {

	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })
	public void NegativeUsernameTest() {
		System.out.println("Starting Negative Username Test\n\n");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("URL open");

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("Username text box located successfully");

		// Type incorrect username
		String wrongUsernameString = "invalidUsername";
		usernameField.sendKeys(wrongUsernameString);
		System.out.println("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("Password text box located successfully");

		// Type correct password
		String correctPassword = "SuperSecretPassword!";
		passwordField.sendKeys(correctPassword);
		System.out.println("Password typed");

		sleep(2000);

		// locate Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Login button located successfully");

		// Clicking button
		loginButton.click();
		System.out.println("Click successfully");

		sleep(2000);

		// Validation

		// Expected Message
		String expectedMessage = "Your username is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		System.out.println("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

	@Test(priority = 2, enabled = true, groups = { "negativeTest" })
	public void NegativePasswordTest() {
		System.out.println("Starting Negative Username Test\n\n");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("URL open");

		sleep(1000);

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("Username text box located successfully");

		// Type correct username
		String wrongUsernameString = "tomsmith";
		usernameField.sendKeys(wrongUsernameString);
		System.out.println("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("Password text box located successfully");

		// Type incorrect password
		String correctPassword = "incorrectpassword";
		passwordField.sendKeys(correctPassword);
		System.out.println("Password typed");

		sleep(2000);

		// locate Login button
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println("Login button located successfully");

		// Clicking button
		loginButton.click();
		System.out.println("Click successfully");

		sleep(2000);

		// Validation

		// Expected Message
		String expectedMessage = "Your password is invalid!";

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		System.out.println("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

}
