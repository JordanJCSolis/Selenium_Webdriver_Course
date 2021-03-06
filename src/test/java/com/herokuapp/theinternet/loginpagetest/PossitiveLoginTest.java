package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
//import org.junit.Test;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.SecureAreaPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PossitiveLoginTest extends TestUtilities {

	@Test(priority = 1, enabled = true, groups = { "positiveTest" })
	public void positiveLogingTest() {

		// Open Main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
//		takeScreenshot("WelcomePage opened");

		// Click Form Authentication Link
		LoginPageObject loginPage = welcomePage.clickFormAuthenticationLink();
//		takeScreenshot("loginPage opened");
		
		// Create new cookie
		Cookie ck = new Cookie("Username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		
		// Add Cookie
		loginPage.setCookie(ck);

		// Enter user name, password and click login button
		SecureAreaPageObject secureArea = loginPage.login("tomsmith", "SuperSecretPassword!");
//		takeScreenshot("secureAreaPage opened");
		
		// Get cookies
		String usernameCookie = secureArea.getCookie("Username");
		log.info("Username cookie: " + usernameCookie);
		
		String sessionCookie = secureArea.getCookie("rack.session");
		log.info("rack.session cookie: " + sessionCookie);

		// verification

		// New URL
		Assert.assertEquals(secureArea.getCurrentUrl(), secureArea.getPageUrl());

		// Logout button is visible
		Assert.assertTrue(secureArea.isLogOutButtonVisible());

		// successful login message
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = secureArea.getSuccessMessageText();

		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
}
