package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class NegativeLoginTests extends BaseTest{
	
	
	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })
	
	public void negativeLoginTest(String username, String password, String expectedMessage) {
		System.out.println("Starting Negative Username Test\n\n");

		// Open URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("URL open");

		sleep(1000);

		// Locate username textbox
		WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println("Username text box located successfully");

		// Type incorrect username
		usernameField.sendKeys(username);
		System.out.println("Username typed");

		sleep(2000);

		// Locate password textbox
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println("Password text box located successfully");

		// Type correct password
		passwordField.sendKeys(password);
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

		// Current Message
		WebElement invalidUsernameMessage = driver.findElement(By.id("flash"));
		System.out.println("Invalid message found");
		String actualMessage = invalidUsernameMessage.getText();

		// Comparing Strings
		Assert.assertTrue(actualMessage.contains(expectedMessage));

		sleep(2000);
	}

	private void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
