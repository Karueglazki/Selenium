package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumBase {

	protected static Selenium selenium;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, browser, "http://www.google.com.ua/");
		selenium.start();
	}

	@AfterClass
	public void tearDown() throws Exception {
		selenium.stop();
	}

	}
