package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPageObject extends BasePageObject {

	// Fields
	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");

	// Methods

	// Drag and Drop
	public void dragAintoB() {
		log.info("Drag and drop element A into element B");
		performDragAndDrop(columnA, columnB);
	}

	// Get column A text
	public String getColumnAText() {
		String text = find(columnA).getText();
		log.info("Column A text: " + text);
		return text;
	}

	// Get column B text
	public String getColumnBText() {
		String text = find(columnB).getText();
		log.info("Column B text: " + text);
		return text;
	}

	// Constructor
	public DragAndDropPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
