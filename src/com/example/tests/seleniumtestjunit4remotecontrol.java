package com.example.tests;

import com.thoughtworks.selenium.*;
import org.apache.commons.lang3.ArrayUtils;
import com.unitedinternet.portal.selenium.utils.*;
import com.unitedinternet.portal.selenium.utils.logging.HtmlResultFormatter;
import com.unitedinternet.portal.selenium.utils.logging.LoggingCommandProcessor;
import com.unitedinternet.portal.selenium.utils.logging.LoggingDefaultSelenium;
import com.unitedinternet.portal.selenium.utils.logging.LoggingResultsFormatter;
import com.unitedinternet.portal.selenium.utils.logging.LoggingUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class seleniumtestjunit4remotecontrol {
	private Selenium selenium;
	private BufferedWriter loggingWriter;
	

	@Before
	public void setUp() throws Exception {
		java.util.Date date= new java.util.Date();
		  final String resultPath = "/home/sandra/Documents/AutomationTest/workspace-selenium/selenium-test/results";
		    final String resultHtmlFileName = resultPath + File.separator + "result"+date.getTime()+".html";
		    final String resultEncoding = "UTF-8";
		    loggingWriter = LoggingUtils.createWriter(resultHtmlFileName, resultEncoding);

		    LoggingResultsFormatter htmlFormatter = new HtmlResultFormatter(loggingWriter, resultEncoding);
		    htmlFormatter.setScreenShotBaseUri("screenshots"); // this is for linking to the screenshots
		    htmlFormatter.setAutomaticScreenshotPath(resultPath);
		    // wrap HttpCommandProcessor from remote-control
		    LoggingCommandProcessor myProcessor = new LoggingCommandProcessor(new HttpCommandProcessor("localhost", 4444, "*firefox", "https://www.google.com.ua/"), htmlFormatter);
		    selenium = new LoggingDefaultSelenium(myProcessor);
		    selenium.start();
//		selenium.windowFocus();
//		selenium.windowMaximize();
		    
	}
 
	
	@Test
	public void testGoogleJunit4RC() throws Exception {
		selenium.waitForPageToLoad("3");
		selenium.open("");
		selenium.waitForPageToLoad("3");
		selenium.type("id=lst-ib", "обучение собак");
		selenium.click("name=btnG");
		
	}

	@After
	public void tearDown() {
	    selenium.stop();
	    try {
	        if (null != loggingWriter) {
	            loggingWriter.close();
	        }
	    } catch (IOException e) {
	        // do nothing
	    }
	}
}