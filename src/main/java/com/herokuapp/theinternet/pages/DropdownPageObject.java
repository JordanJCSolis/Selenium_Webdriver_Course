package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends BasePageObject{
	
	// Fields
	private By dropdown = By.xpath("//Select[@id='dropdown']");
	
	// Select option
	public void selectOption(int option) {
		log.info("Selectiong option " + option + " from dropdown");
		WebElement dropdownElement = find(this.dropdown);
		Select dropdown = new Select(dropdownElement);
		
		// Option 1 - Select by index
//		dropdown.selectByIndex(option);
		
		//Option 2 - Select by value
		dropdown.selectByValue(Integer.toString(option));
		
		// Option 3 - Select by visible text
//		dropdown.selectByVisibleText("Option " + option);
	}
	
	
	// Return selected option in dropdown
	public String getSelectedOption() {
		WebElement dropdownElement = find(this.dropdown);
		Select dropdown = new Select(dropdownElement);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		log.info(selectedOption + " is selected in dropdown");
		return selectedOption;
	}

	
	//Constructor
	public DropdownPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
