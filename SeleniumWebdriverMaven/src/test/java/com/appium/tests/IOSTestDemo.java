package com.appium.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.pages.MainPage;


public class IOSTestDemo extends TestBase {
	
	MainPage mainPage;
	
	@BeforeClass
	public void setUp() {
		mainPage = new MainPage(driver);
	}
	
	@Test
	public void openApp() {
		mainPage.clickAlertViewsItem();
	}
}
