package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPageObject extends BasePageObject {

	// Fields
	private By avatarLocator = By.xpath("//div[@class='figure']");
	
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");
	
	// Methods
	
	// Open specified user profile.
	public void openProfile(int profileNumber) {
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specifiedUserAvatar = avatars.get(profileNumber - 1);
		hoverOverElement(specifiedUserAvatar);
		log.info("Hover over profile " + profileNumber);
		specifiedUserAvatar.findElement(viewProfileLinkLocator).click();
		log.info("Clicking on view profile");
	}
	
	// Constructor
	public HoversPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
