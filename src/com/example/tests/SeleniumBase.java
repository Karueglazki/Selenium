package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumBase {

	protected static Selenium selenium;

	@BeforeSuite
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.google.com.ua/");
		selenium.start();
	}

	@AfterSuite
	public void tearDown() throws Exception {
		selenium.stop();
	}

	}
