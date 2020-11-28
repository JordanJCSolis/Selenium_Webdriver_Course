package com.herokuapp.theinternet.jserrortest;

import java.util.List;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class JSErrorTest extends TestUtilities {

	@Test
	public void JsErrorTest() {

		log.info("Starting JsErrorTest");

		// Creating SoftAssert instance
		SoftAssert softAssert = new SoftAssert();

		// Open Welcome page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Open JsErrorPage
		welcomePage.clickJSErrorLink();

		// Get logs
		List<LogEntry> logs = getBrowserLogs();

		// Verifying there are no JavaScript errors in console
		for (LogEntry logEntry : logs) {
			if (logEntry.getLevel().toString().equals("SEVERE")) {
				softAssert.fail("Severe error found: " + logEntry.getMessage());
			}
		}
		softAssert.assertAll();
	}
}
