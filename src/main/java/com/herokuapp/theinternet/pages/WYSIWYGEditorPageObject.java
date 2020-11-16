package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPageObject extends BasePageObject {

	// Fields
	private By tinyMCETextLocator = By.id("tinymce");
	private By frame = By.tagName("iframe");
	
	// Get text from TinyMCE WYSIWYG Editor
	public String getTinyMCEText() {
		switchToFrame(frame);
		String text = find(tinyMCETextLocator).getText();
		log.info("Text found in TinyMCE WYSIWYG Editor: " + text);
		return text;
	}
	
	// Constructor
	public WYSIWYGEditorPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
}
