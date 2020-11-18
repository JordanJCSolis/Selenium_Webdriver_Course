package com.herokuapp.theinternet.draganddroptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPageObject;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class DragAndDropTest extends TestUtilities {
	
	
	@Test
	public void dragAndDropTest() {
	
		// Open Welcome page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		// Open Drag and Drop page
		DragAndDropPageObject dragAndDropPage = welcomePage.clickingDragAndDropLink();
		
		// Drag and Drop element A into element B
		dragAndDropPage.dragAintoB();
		
		// Verify correct header is in correct correct column (box)
		
		String columnAText = dragAndDropPage.getColumnAText();
		String columnBText = dragAndDropPage.getColumnBText();
		
		Assert.assertTrue(columnAText.contentEquals("B"),"Error in column A");
		Assert.assertTrue(columnBText.contentEquals("A"),"Error in column B");
		
	}

}
