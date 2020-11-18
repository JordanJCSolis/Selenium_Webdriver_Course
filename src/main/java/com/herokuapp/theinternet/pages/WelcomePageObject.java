package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{
	
	private String pageUrl = "http://the-internet.herokuapp.com/";
	private By formAutenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLinkLocator = By.linkText("Checkboxes");
	private By dropdownLinkLocator = By.linkText("Dropdown");
	private By javaScriptAlertsLocator = By.linkText("JavaScript Alerts");
	private By multipleWindowsLocator = By.linkText("Multiple Windows");
	private By wysiwygEditorLocator = By.linkText("WYSIWYG Editor");
	private By keyPressesLocator = By.linkText("Key Presses");
	private By fileUploadLocator = By.linkText("File Upload");
	private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
	private By hoversLinkLocator = By.linkText("Hovers");
	
	
	// Open Welcome Page
	public void openPage() {
		log.info("page " + pageUrl + " opened");
//		driver.get(pageUrl);
		openURL(pageUrl);
		log.info("Page opened!");
	}
	
	// Open Form Authentication (Login Page) by clicking on Form Authentication link
	public LoginPageObject clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome Page");
//		driver.findElement(formAutenticationLinkLocator).click();
		click(formAutenticationLinkLocator);
		return new LoginPageObject(driver, log);
	}
	
	// Open Checkboxes page by clicking on Checkboxes link
	public CheckboxesPageObject clickingCheckboxesLink() {
		log.info("Clicking Checkboxed link on Welcome page");
		click(checkboxesLinkLocator);
		return new CheckboxesPageObject(driver,log);
	}
	
	// Open Dropdown page by clicking on Dropdown link
	public DropdownPageObject clickingDropdownLink() {
		log.info("Clicking dropdown link on welcome page");
		click(dropdownLinkLocator);
		return new DropdownPageObject(driver,log);
	}
	
	// Open JavaScript Alerts page by clicking on JavaScript Alerts Link
	public JavaScriptAlertsPageObject clickingJavaScriptAlertsLink() {
		log.info("Clicking JavaScript Alerts link on the Welcome Page");
		click(javaScriptAlertsLocator);
		return new JavaScriptAlertsPageObject(driver,log);
	}
	
	// Open Multiple Windoes page by clicking on Multiple Windows link
	public WindowsPageObject clickingMultipleWindowsLink() {
		log.info("Clicking Multiple Windows link on the Welcome Page");
		click(multipleWindowsLocator);
		return new WindowsPageObject(driver, log);
	}
	
	// Open WYSIWYG Editor page by clicking on WYSIWYG Editor Link
	public WYSIWYGEditorPageObject clickingWYSIWYGEditorLink() {
		log.info("clicking WYSIWYG Editor link on Welcome Page");
		click(wysiwygEditorLocator);
		return new WYSIWYGEditorPageObject(driver,log);
	}
	
	// Open Key Presses page by clicking on Key Presses link
	public KeyPressesPageObject clickingKeyPressesLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPressesLocator);
		return new KeyPressesPageObject(driver, log);
	}
	
	// Open File Uploader page by clicking on File Upload link
	public FileUploadPageObject clickngFileUploadLink() {
		log.info("Clicking File Upload link on Welcome Page");
		click(fileUploadLocator);
		return new FileUploadPageObject(driver, log);
	}
	
	// Open Drag and Drop page by clicking Drag and Drop link
	public DragAndDropPageObject clickingDragAndDropLink() {
		log.info("Clicking on Drag and Drop link");
		click(dragAndDropLinkLocator);
		return new DragAndDropPageObject(driver, log);
	}
	
	// Open Hovers page by clicking on Hovers link
	public HoversPageObject clickingHoversLink() {
		log.info("Clicking on Hovers link");
		click(hoversLinkLocator);
		return new	HoversPageObject(driver, log);
	}
	

	// Constructor
	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}

}
