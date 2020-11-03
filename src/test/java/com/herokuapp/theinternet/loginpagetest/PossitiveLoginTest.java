package com.herokuapp.theinternet.loginpagetest;

//import org.junit.Test;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PossitiveLoginTest extends BaseTest {

	@Test(priority = 1, enabled = true, groups = {"positiveTest"})
	public void positiveLogingTest() {
		
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page was open");

		// enter user name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		
		// click login button
		WebElement loginButton = driver.findElement(By.tagName("Button"));
		loginButton.click();

		// verification

		// new URL
		String expectedURL = "https://the-internet.herokuapp.com/secure";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);

		// Logout button is visible
		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
//		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius' invalid_text]"));
		Assert.assertTrue(logoutButton.isDisplayed(),"Log Out button is not visible");

		// successful login message
//		WebElement loginMessage = driver.findElement(By.cssSelector("#flash"));
//		WebElement loginMessage = driver.findElement(By.className("success"));
		
		WebElement loginMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = loginMessage.getText();
//		Assert.assertEquals(actualMessage,expectedMessage);
		Assert.assertTrue(actualMessage.contains(expectedMessage));

	}

}
