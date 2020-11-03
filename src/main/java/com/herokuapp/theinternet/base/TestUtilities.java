package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest {

	protected void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
