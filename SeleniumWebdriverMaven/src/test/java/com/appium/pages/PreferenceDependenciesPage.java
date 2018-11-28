package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class PreferenceDependenciesPage extends PageBase{

	AppiumDriver<?> driver;
	@FindBy(id = "android:id/checkbox")
	private WebElement wifiCheckbox;

	@FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.RelativeLayout")
	private WebElement wifiSettingsButton;
	
	public PreferenceDependenciesPage(AppiumDriver<?> driver) {
		super(driver);
		this.driver = driver;
	}
	
	public PreferenceDependenciesPage clickOnWifiCheckbox() {
		waitForVisibilityOf(wifiCheckbox);
		wifiCheckbox.click();
		return new PreferenceDependenciesPage(driver);
	}
	
	public void clickOnWifiSettings() {
		waitForVisibilityOf(wifiSettingsButton);
		wifiSettingsButton.click();
	}
}
