package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })

	public void negativeLoginTest(String username, String password, String expectedMessage) {
		log.info("Starting Negative Login Test");

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click Form Authentication
		LoginPageObject loginPage = welcomePage.clickFormAuthenticationLink();

		// Fill Username, password and click on Login
		loginPage.login(username, password);

		// Wait for error message
		loginPage.waitForErrorMessage();
		
		// Get error message
		String currentMessage = loginPage.getErrorMessageText();

		// Validation
		Assert.assertTrue(currentMessage.contains(expectedMessage));

	}
}
