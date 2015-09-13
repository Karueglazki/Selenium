package com.example.tests;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.*;

public class SeleniumtestNG extends SeleniumBase {
//	@Test(groups = { "fast" })
	@Test
	public void testpresentain() throws Exception {
		 selenium.open("http://www.presentain.com");
		 System.out.println("Fast test");
	}
}