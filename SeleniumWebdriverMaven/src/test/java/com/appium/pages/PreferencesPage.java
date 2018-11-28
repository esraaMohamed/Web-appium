package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class PreferencesPage extends PageBase{
	
	AppiumDriver<?> driver;
	TouchAction<?> touchAction;
	TapOptions tapOption;
	
	@FindBy(xpath = "//android.widget.TextView[3]")
	private WebElement preferenceDependenciesListItem;
	
	@FindBy(xpath ="//android.widget.TextView[@text='Views']")
	private WebElement viewsItem;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Expandable Lists'")
	private WebElement expandableListsItem;
	
	public PreferencesPage(AppiumDriver<?> driver) {
        super(driver);
        this.driver = driver;
        touchAction = new TouchAction<>(driver);
        tapOption = new TapOptions();
	}
	
	public PreferenceDependenciesPage clickOnPreferenceDependenciesItem() {
		waitForVisibilityOf(preferenceDependenciesListItem);	
		preferenceDependenciesListItem.click();
		return new PreferenceDependenciesPage(this.driver);
	}
	
	public void clickOnViewsItem() {
		waitForVisibilityOf(viewsItem);
		viewsItem.click();
	}
	
	public void tapElement() {
		touchAction.tap(tapOption.withElement(ElementOption.element(expandableListsItem))).perform();
	}
}
