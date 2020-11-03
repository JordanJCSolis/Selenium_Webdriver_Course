package com.herokuapp.theinternet.loginpagetest;

//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PossitiveLoginTest {

	@Test(priority = 1, enabled = true, groups = {"positiveTest"})
	public void positiveLogingTest() {

		// Create Driver
		
//		First, lets create the path
//		System.setProperty(key, value)
		
//		Key: "Webdriver.chrome.driver"	
//		value: path of the web Driver. to get it right click on the driver
//		       and choose properties
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		
		//Instance Web Driver
		WebDriver driver = new ChromeDriver();
		
		// Open test page
//		driver.get(url);
		
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page was open");
		
		//Maximize browser window
		driver.manage().window().maximize();
		System.out.println("Page maximized");

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
		
		
		//Close Browser
		driver.quit();

	}

}
