package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPageObject extends BasePageObject{

	// Fields
	private By jsAlertButtonLocator = By.xpath("//button[(text()='Click for JS Alert')]");
	private By jsConfirmButtonLocator = By.xpath("//button[(text()='Click for JS Confirm')]");
	private By jsPromptButtonLocator = By.xpath("//button[(text()='Click for JS Prompt')]");
	private By resultLocator = By.id("result");
	
	
	// Clicking on Click for JS Alert button
	public void clickJSAlertButton() {
		log.info("Clicking on Click for JS Alert button");
		click(jsAlertButtonLocator);
	}
	
	// Clicking on Click for JS Confirm button
	public void clickJSConfirmButton() {
		log.info("Clicking on Click for JS Confirm button");
		click(jsConfirmButtonLocator);
	}
	// Clicking on Click for JS Prompt button
	public void clickJSPromptButton() {
		log.info("Clicking on Click for JS Prompt button");
		click(jsPromptButtonLocator);
	}
	
	
	// Get Alert text
	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says " + alertText);
		return alertText;
	}
	
	// Accept Alert
	public void acceptAlert() {
		log.info("Alert was accepted");
		Alert alert = switchToAlert();
		alert.accept();
	}
	
	// Dismiss Alert
	public void dismissAlert() {
		log.info("Alert was dismissed");
		Alert alert = switchToAlert();
		alert.dismiss();
	}
	
	// Typing text into Alert textbox
	public void typeTextIntoAlert(String text) {
		log.info("Typing " + text + " into Alert text");
		Alert alert = switchToAlert();
		alert.sendKeys(text);
	}
	
	// Getting result text
	public String getResultText() {
		String result = find(resultLocator).getText();
		log.info("Result text: " + result);
		return result;
	}
	
	
	// Constructor
	public JavaScriptAlertsPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
