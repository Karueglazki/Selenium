package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class seleniumtestjunit4remotecontrol {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.com.ua/");
		selenium.start();
		selenium.windowFocus();
		selenium.windowMaximize();
	}

	@Test
	public void testGoogleJunit4RC() throws Exception {
		selenium.open("");
		selenium.type("id=lst-ib", "обучение собак");
		selenium.click("name=btnG");
		selenium.waitForPageToLoad("3");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}