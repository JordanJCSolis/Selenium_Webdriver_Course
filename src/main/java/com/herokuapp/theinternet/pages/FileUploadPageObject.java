package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPageObject extends BasePageObject {

	// Fields
	private By chooseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");

	// Methods

	// Push upload button
	public void pushUploadButton() {
		log.info("Clicking on Upload button");
		click(uploadButtonLocator);
	}

	// Push Choose File button
	public void selectFile(String fileName) {
		log.info("Selecting '" + fileName + "' file");
//		String filePath = "C:\\Users\\jorda\\Downloads\\Otro\\IEEE Univrse.jpg";
		String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
		type(filePath, chooseFileFieldLocator);
		log.info("File selected");
	}

	// Get name of uploaded file
	public String getUploadedFileName() {
		String name = find(uploadedFilesLocator).getText();
		log.info(name + "file uploaded");
		return name;
	}

	// Constructor
	public FileUploadPageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
