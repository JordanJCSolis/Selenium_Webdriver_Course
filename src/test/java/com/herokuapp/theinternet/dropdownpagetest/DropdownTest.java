package com.herokuapp.theinternet.dropdownpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DropdownTest extends TestUtilities{
	
	@Parameters("option")
	@Test
	public void dropdownTest(int option) {
		
		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Click on dropdown link
		DropdownPageObject dropdownPage = welcomePage.clickingDropdownLink();
		
		// Select one option
		dropdownPage.selectOption(option);
		
		// Verify option selected matches with desired one
		Assert.assertEquals(dropdownPage.getSelectedOption(), "Option " + option);
	}

}
