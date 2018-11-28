package com.appium.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.pages.MainPage;
import com.appium.pages.PreferenceDependenciesPage;
import com.appium.pages.PreferencesPage;


public class AndroidTestDemo extends TestBase{
	
	MainPage mainpage;
	PreferencesPage preferencePage;
	PreferenceDependenciesPage preferenceDependenciesPage;
	
	@BeforeClass
	public void setUp() {
		mainpage = new MainPage(driver);
		preferencePage = new PreferencesPage(driver);
		preferenceDependenciesPage = new PreferenceDependenciesPage(driver);
	}
	
	@Test
	public void testClickOnElement() throws InterruptedException {
		this.mainpage.clickOnPreferenceItem()
		.clickOnPreferenceDependenciesItem()
		.clickOnWifiCheckbox()
		.clickOnWifiSettings();
	}
}
