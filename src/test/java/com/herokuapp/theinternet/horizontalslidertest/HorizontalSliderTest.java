package com.herokuapp.theinternet.horizontalslidertest;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class HorizontalSliderTest extends TestUtilities {
	
	
	@Parameters("sliderValue")
	@Test
	public void sliderTest(@Optional("3.5") double value) {
		log.info("Starting sliderTest");
		
		// Open welcome page
		WelcomePageObject welcomePageVariable = new WelcomePageObject(driver, log);
		welcomePageVariable.openPage();
		
		// Open Horizontal Slider page
		HorizontalSliderPageObject horizontalSliderVariable = welcomePageVariable.clickingHorizontalSliderLink();
		
		// Move slider
		horizontalSliderVariable.setSliderTo(value);
		
		// Getting slide value
		double sliderValue = horizontalSliderVariable.getSliderValue();
		
		// Getting real number of steps
		double realSliderValue = value % 0.5 == 0 ? value : ((int) (value / 0.5)) * 0.5;
		
		// Verification
		Assert.assertTrue(sliderValue == realSliderValue, "Error");
	}

}
