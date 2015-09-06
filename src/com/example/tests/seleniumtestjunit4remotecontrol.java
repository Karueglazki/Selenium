package com.example.tests;

import com.thoughtworks.selenium.*;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumtestjunit4remotecontrol {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver wd = new FirefoxDriver();
		selenium = new WebDriverBackedSelenium(wd, "https://www.google.com.ua/");
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