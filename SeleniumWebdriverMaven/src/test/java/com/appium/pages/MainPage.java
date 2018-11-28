package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class MainPage extends PageBase {

	AppiumDriver<?> driver;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	@FindBy(xpath = "//android.widget.TextView[@text='Preference']")
	private WebElement preferenceListItem;
	
	@iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Alert Views\"]")
	private WebElement alertViewsItem;
	
	public MainPage (AppiumDriver<?> driver) {
        super(driver);
        this.driver = driver;
	}
	
	public PreferencesPage clickOnPreferenceItem() {
		(preferenceListItem).click();
		return new PreferencesPage(this.driver);
	}
	
	
	public void clickAlertViewsItem() {
		alertViewsItem.click();
	}
}
