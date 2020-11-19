package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPageObject extends BasePageObject {
	
	// Fields
	private By horizontalSliderLocator = By.xpath("//input[@type='range']");
	private By rangeValueLocator = By.id("range");
	
	// Methods
	
	// Set slider value
	public void setSliderTo(double sliderValue) {
		// Not working - moves slider to a different value
//		Actions action = new Actions(driver);
//		action.dragAndDropBy(find(horizontalSliderLocator), (int) sliderValue, 0).perform();
		
		// calculate number of steps
		int steps = (int) (sliderValue / 0.5);
		if(sliderValue%0.5 == 0) {
			log.info("Moving slider to: " + sliderValue);
		} else {
			log.info(sliderValue + " is an invalid entrance. Adjusting value to " + steps*0.5);
		}
		//perform steps
		pressKey(horizontalSliderLocator, Keys.ENTER);
		for(int i = 0 ; i < steps ; i++) {
			pressKey(horizontalSliderLocator, Keys.ARROW_RIGHT);
		}
	}
	
	// Getting slider value
	public double getSliderValue() {
		String stringValue = find(rangeValueLocator).getText();
		double value = Double.parseDouble(stringValue);
		log.info("Horizontal slider value: " + value);
		return value;
	}

	// Constructor
	public HorizontalSliderPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
