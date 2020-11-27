package com.herokuapp.theinternet.jsalertpagetest;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class JSAlertTest extends TestUtilities {

	@Test
	public void jsAlertTest() {
		
		// SoftAssert instance
		SoftAssert softAssert = new SoftAssert();

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Select JavaScript Alerts link
		JavaScriptAlertsPageObject jsAlert = welcomePage.clickingJavaScriptAlertsLink();

		// Click on JS Alert button
		jsAlert.clickJSAlertButton();

		// Get text alert
		String jsAlertText = jsAlert.getAlertText() + "[FAIL]";

		// Click on "Aceptar" option
		jsAlert.acceptAlert();

		// Get result text
		String jsAlertResultText = jsAlert.getResultText() + "[FAIL]";

		// Verifications

		// First verification - Alert text is the expected
		softAssert.assertEquals(jsAlertText, "I am a JS Alert", "Error 1");

		// Second verification - Result text is the expected
//		Assert.assertEquals(jsAlertResultText, "You successfuly clicked an alert");
		softAssert.assertTrue(jsAlertResultText.equals("You successfuly clicked an alert"), "Error 2");
		
		softAssert.assertAll();
	}

	@Parameters("decision")
	@Test
	public void JSConfirm(@Optional("accept") String decision) {

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Select JavaScript Alerts link
		JavaScriptAlertsPageObject jsAlert = welcomePage.clickingJavaScriptAlertsLink();

		// Click on JS Confirm button
		jsAlert.clickJSConfirmButton();

		// Get text alert
		String jsAlertText = jsAlert.getAlertText();

		// Take a decision
		if (decision.equalsIgnoreCase("Accept")) {
			jsAlert.acceptAlert();
		} else if (decision.equalsIgnoreCase("cancel")) {
			jsAlert.dismissAlert();
		} else {
			log.info(decision + " is an invalid option. Accepting alert");
			jsAlert.acceptAlert();
		}

		// Get result text
		String jsAlertResultText = jsAlert.getResultText();

		// Verifications

		// First verification - Alert text is the expected
		Assert.assertEquals(jsAlertText, "I am a JS Confirm", "Error 1");

		// Second verification - Result text is the expected
		String jsConfirmExpectedMessage = decision.equalsIgnoreCase("accept") ? "You clicked: Ok"
				: "You clicked: Cancel";
		Assert.assertTrue(jsAlertResultText.contains(jsConfirmExpectedMessage), "error2");

	}

	@Parameters({ "jsPromptString", "decision" })
	@Test
	public void jsPrompt(@Optional("This is an automated test") String jsPromptString, @Optional("accept") String decision) {

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Select JavaScript Alerts link
		JavaScriptAlertsPageObject jsAlert = welcomePage.clickingJavaScriptAlertsLink();

		// Click on JS Prompt button
		jsAlert.clickJSPromptButton();

		//
		String jsAlertText = jsAlert.getAlertText();

		// Type text on alert
		jsAlert.typeTextIntoAlert(jsPromptString);

		// Take a decision
		if (decision.equalsIgnoreCase("Accept")) {
			jsAlert.acceptAlert();
		} else if (decision.equalsIgnoreCase("cancel")) {
			jsAlert.dismissAlert();
		} else {
			log.info(decision + " is an invalid option. Accepting alert");
			jsAlert.acceptAlert();
		}
		
		// Get result text
		String jsResultText = jsAlert.getResultText();

		// Verifications
		
		// First verification - Alert text is the expected
		Assert.assertEquals(jsAlertText, "I am a JS prompt");
		
		// Second verification - Result is the expected
		String jsAlertExpectedMessage = decision.equalsIgnoreCase("Accept") ? "You entered: " + jsPromptString : "You entered: null";
		Assert.assertTrue(jsResultText.contains(jsAlertExpectedMessage),"Error 2");

	}
}
