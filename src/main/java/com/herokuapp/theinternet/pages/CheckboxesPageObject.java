package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CheckboxesPageObject extends BasePageObject{
	
	//fields
	private By checkbox = By.xpath("//input[@type='checkbox']");
	
	
	// Get list of all checkboxes and check them if they are not checked.
	public void selectAllCheckboxes() {
		log.info("Checking all unselected checkboxes");
		List<WebElement> checkboxes = findAll(checkbox);
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	
	// Verify all checkboxes are selected
	public boolean areAllCheckboxesChecked() {
		log.info("Verifying that all checkboxes are checked");
		List<WebElement> checkboxes = findAll(checkbox);
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				return false;
			}
		}
		
		return true;
	}
	
	// Constructor
	public CheckboxesPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
