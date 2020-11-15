package com.herokuapp.theinternet.multiplewindowstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import com.herokuapp.theinternet.pages.WindowsPageObject;

public class NewWindowsTest extends TestUtilities {
	
	@Test
	public void multipleWindowsTest() {
		
		// Open Main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Click on Multiple Windows link
		WindowsPageObject windowsPage = welcomePage.clickingMultipleWindowsLink();
		
		// Click on 'Click Here" Link
		windowsPage.clickOnLink();
		
		// Switch into New Window Page
		NewWindowPageObject newWinwowPage = windowsPage.switchToNewWindowPage();
		
		// Verification that new page contains expected text in source
		String newWindowPageSource = newWinwowPage.getCurrentPageSource();
		Assert.assertTrue(newWindowPageSource.contains("New Window"));
		
		// Switch back into origin window
		newWinwowPage.switchToWindowWithTitle("The Internet");
	}

}
