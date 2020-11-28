package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

	protected void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// Take screenshots
	protected void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")
				+ File.separator + "test-output"
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate()
				+ File.separator + testSuiteName
				+ File.separator + testName
				+ File.separator + testMethodName
				+ File.separator + getSystemTime()
				+ " " + fileName + ".png";
		
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// Getting todays date in yyyy/mm/dd format
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	}
	
	// Getting current time in HH:mm:ss:SSS
	public String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	// Gets logs from Browser console
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
	

	@DataProvider(name = "files")
	protected static Object[][] files() {
		return new Object[][] { 
			{ 1, "index.html" }, 
			{ 2, "file.txt" }, 
			{ 3, "IEEE Univrse.jpg" } 
		};
	}

}
