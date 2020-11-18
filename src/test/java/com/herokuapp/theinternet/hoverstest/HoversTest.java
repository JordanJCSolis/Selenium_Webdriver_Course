package com.herokuapp.theinternet.hoverstest;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class HoversTest extends TestUtilities {
	
	
	@Parameters("userProfile")
	@Test
	public void hoverTest(@Optional("2") int profile) {
		
		// Open Welcome Page
		WelcomePageObject welcomePageVariable = new WelcomePageObject(driver, log);
		welcomePageVariable.openPage();
		
		// Open page under test
		HoversPageObject hoverPageVariable = welcomePageVariable.clickingHoversLink();
		
		// Open user Profile
		hoverPageVariable.openProfile(profile);
		
		// Verification
		Assert.assertTrue(hoverPageVariable.getCurrentUrl().contains("/users/" + profile),"Error");
		
	}

}
