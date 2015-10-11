package com.example.tests;

import org.testng.annotations.Test;

import com.thoughtworks.selenium.*;

public class Conexio extends SeleniumBase {
	@Test(dataProvider =  "uploaddatauser")
	public void testpresentain(String username, String email) throws Exception {
		 selenium.open("https://conexio.netw.fr/");
		 System.out.println("conexio test");
		 
	}
}