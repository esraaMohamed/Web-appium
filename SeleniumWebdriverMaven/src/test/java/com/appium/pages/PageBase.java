package com.appium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageBase {

	final WebDriverWait wait;
	public int timeInMillis = 50;
	public int timeInSecs = 10;
	
	public PageBase(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, timeInSecs, timeInMillis);
	}
	
	public void waitForVisibilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
