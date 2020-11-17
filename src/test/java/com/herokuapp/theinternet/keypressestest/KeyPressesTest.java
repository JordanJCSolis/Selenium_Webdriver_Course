package com.herokuapp.theinternet.keypressestest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class KeyPressesTest extends TestUtilities {

	@Test
	public void keyPressesTestWithLocator() {

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Key Presses Link
		KeyPressesPageObject keyPresses = welcomePage.clickingKeyPressesLink();

		// Push Keyboard Key
		keyPresses.pressKey(Keys.ENTER);

		// Get result Text
		String resultText = keyPresses.getResultText();

		// Verification
		Assert.assertEquals(resultText, "You entered: ENTER");
	}

	@Test
	public void keyPressesTestWithoutLocator() {

		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();

		// Click on Key Presses Link
		KeyPressesPageObject keyPresses = welcomePage.clickingKeyPressesLink();

		// Push Keyboard Key
		keyPresses.pressKeywithActions(Keys.ENTER);

		// Get result Text
		String resultText = keyPresses.getResultText();

		// Verification
		Assert.assertEquals(resultText, "You entered: ENTER");
	}

}
