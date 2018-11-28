package SeleniumMaven.Maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenshotDemo {


	WebDriver chromeDriver = new ChromeDriver();
	WebDriver ffDriver = new FirefoxDriver();

	@BeforeClass
	public void init() {
		String chromePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver";
		String geckoPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "geckodriver";
		System.setProperty("webdriver.chrome.driver", chromePath);
		System.setProperty("webdriver.gecko.driver", geckoPath);	
	}
	
	@Test
	public void openURL() {
		System.out.println("The website url will open here");
		chromeDriver.get("http://www.google.com");
		Assert.assertTrue(chromeDriver.getCurrentUrl().contains("google.com"));
		ffDriver.get("http://www.amazon.com");
		Assert.assertTrue(ffDriver.getCurrentUrl().contains("amazon.com"));
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) ffDriver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + File.separator +"screenshots/" + result.getName() +".png"));
		}
	}
	
	@AfterClass
	public void tearDown() {
		chromeDriver.quit();
		ffDriver.quit();
	}
}
