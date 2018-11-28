package com.nopcommerce.demo.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	static WebDriver driver = new ChromeDriver();
	
	@BeforeSuite
	public void setUp() {
		String chromePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver";
		String geckoPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "geckodriver";
		System.setProperty("webdriver.chrome.driver", chromePath);
		System.setProperty("webdriver.gecko.driver", geckoPath);
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + File.separator +"screenshots/" + result.getName() +".png"));
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
