package com.example.tests;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.*;

public class SeleniumtestNG1 extends SeleniumBase {
	@Test
	public void testGoogle() throws Exception {
		selenium.open("");
		selenium.type("id=lst-ib", "обучение собак");
		selenium.click("name=btnG");
		
	}
}