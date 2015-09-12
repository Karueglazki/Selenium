package com.example.tests;

import java.io.*;
import java.text.ParseException;
import org.junit.*;
import com.thoughtworks.selenium.*;
import com.unitedinternet.portal.selenium.utils.logging.*;

public class doubt {

protected LoggingSelenium selenium;
private BufferedWriter loggingWriter;
private static final String RESULT_FILE_ENCODING = "UTF-8";
private static final String DEFAULT_TIMEOUT = "30000";
private static final String OPENQA_URL = "http://www.google.co.in";
private static final String SCREENSHOT_PATH = "screenshots";
private final String RESULTS_BASE_PATH = "target" + File.separator + "loggingResults";
private String resultsPath = new File(RESULTS_BASE_PATH).getAbsolutePath();
private String screenshotsResultsPath = new File(RESULTS_BASE_PATH + File.separator + SCREENSHOT_PATH).getAbsolutePath();

@Before

public void setUp() {
if (!new File(screenshotsResultsPath).exists()) {
new File(screenshotsResultsPath).mkdirs();
}

final String resultHtmlFileName = resultsPath + File.separator + "sampleResultSuccess.html";
System.err.println("resultHtmlFileName=" + resultHtmlFileName);

loggingWriter = LoggingUtils.createWriter(resultHtmlFileName, doubt.RESULT_FILE_ENCODING, true);

LoggingResultsFormatter htmlFormatter = new HtmlResultFormatter(loggingWriter,doubt.RESULT_FILE_ENCODING);
htmlFormatter.setScreenShotBaseUri(doubt.SCREENSHOT_PATH + "/"); // has to be "/" as this is a URI
htmlFormatter.setAutomaticScreenshotPath(screenshotsResultsPath);
LoggingCommandProcessor myProcessor = new LoggingCommandProcessor(new HttpCommandProcessor("localhost", 4444, "*firefox",OPENQA_URL), htmlFormatter);
myProcessor.setExcludedCommands(new String[] {});
selenium = new LoggingDefaultSelenium(myProcessor);
selenium.start();
System.out.println("here");
}


@Test
public void loggingSeleniumSuccessSample() throws InterruptedException, ParseException ,IOException{

selenium.open(OPENQA_URL);
selenium.captureScreenshot("D:\\screenshot.png");

for(int i =0; i<4; i++){
selenium.type("q", "Sachin");
selenium.click("btnG");
selenium.waitForPageToLoad("3000");
selenium.open("http://www.google.co.in");
}


System.out.println("end");

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
public static void main(String args[]) throws Exception
{
doubt testTestadmin = new doubt();
testTestadmin.setUp();
testTestadmin.loggingSeleniumSuccessSample();
testTestadmin.tearDown();
}

} 