package com.herokuapp.theinternet.checkboxespagetest;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class CheckboxesTest  extends TestUtilities{

	@Test
	public void selectingTwoCheckboxesTest() {
		
		log.info("Starting selectingTwoCheckboxesTest");
		
		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Click on checkboxes link
		CheckboxesPageObject checkboxesPage = welcomePage.clickingCheckboxesLink();
		
		// Select all checkboes
		checkboxesPage.selectAllCheckboxes();
		
		// Verify all checkboxes are checked.
		checkboxesPage.areAllCheckboxesChecked();
	}
}
