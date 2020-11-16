package com.herokuapp.theinternet.wysiwygeditortest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WYSIWYGEditorPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class WYSIWYGEditorTest extends TestUtilities {
	
	@Test
	public void iframeTest() {
		
		// Open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Click on WYSIWYG Editor Link
		WYSIWYGEditorPageObject tinyMCE = welcomePage.clickingWYSIWYGEditorLink();
		
		// Get default text on editor
		String editorText = tinyMCE.getTinyMCEText();
		
		// Verification
		Assert.assertTrue(editorText.contentEquals("Your content goes here."), "Error 1");
	}

}
