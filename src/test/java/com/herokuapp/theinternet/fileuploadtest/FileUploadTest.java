package com.herokuapp.theinternet.fileuploadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploadPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class FileUploadTest extends TestUtilities {
	
	@Test
	public void imageUploadFileTest() {
		log.info("Starting imageUploadTest");
		
		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Open File Upload page
		FileUploadPageObject fileUpload = welcomePage.clickngFileUploadLink();
		
		// Select file
		String fileName = "IEEE Univrse.jpg";
		fileUpload.selectFile(fileName);
		
		// Puh upload button
		fileUpload.pushUploadButton();
		
		// Get upload files
		String fileUploadedName = fileUpload.getUploadedFileName();
		
		//Validation
		Assert.assertEquals(fileUploadedName, fileName,"Error");
	}

}
