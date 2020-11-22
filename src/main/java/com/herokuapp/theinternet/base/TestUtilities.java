package com.herokuapp.theinternet.base;

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

	@DataProvider(name = "files")
	protected static Object[][] files() {
		return new Object[][] { 
			{ 1, "index.html" }, 
			{ 2, "file.txt" }, 
			{ 3, "IEEE Univrse.jpg" } 
		};
	}

}
