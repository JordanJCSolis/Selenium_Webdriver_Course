package com.herokuapp.theinternet.loginpagetest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class,
			priority = 1, enabled = true, groups = { "negativeTest", "smokeTest" })

	public void negativeLoginTest(Map<String, String> testData) {
		
		// Data
		String testNumber = testData.get("testNumber");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedMessage = testData.get("expectedMessage");
		String testDescription = testData.get("testDescription");
		
		
		log.info("Starting Negative Login Test # " + testNumber + 
				" for " + testDescription);

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
