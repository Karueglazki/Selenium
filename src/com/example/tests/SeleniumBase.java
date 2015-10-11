package com.example.tests;

import static org.junit.Assert.fail;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SeleniumBase {

	protected static Selenium selenium;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void setUp(String browser) throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, browser, "http://www.google.com.ua/");
		selenium.start();
	}
		@AfterSuite
	public void tearDown() throws Exception {
		selenium.stop();
	}


	@DataProvider (name="uploadDataUser")
	public Iterator<Object[]> uploadDataUser() throws Exception {
		List<Object[]> users = new ArrayList<Object[]>();
		Reader r = new BufferedReader(new FileReader("testdata.csv"));
		String line = r.readLine();
		while (line!=null) {
			String[] parts =line.split(";");
			User user = new User();
			user.username = parts[0];
			user.email = parts[1];
			line =r.readLine();
			users.add(new Object()(user));
				
		}
		
	return  users.iterator;
	}

	}
