package SeleniumMaven.Maven;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverHandler {
	
	WebDriver driver = new ChromeDriver();
	WebDriver ff = new FirefoxDriver();
	
	@BeforeClass
	public void init() {
		String chromePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver";
		String geckoPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "geckodriver";
		System.setProperty("webdriver.chrome.driver", chromePath);
		System.setProperty("webdriver.gecko.driver", geckoPath);	
	}
	
	@Test
	public void firstChromeTest() {
		driver.get("http://www.google.com");
		Assert.assertTrue(driver.getCurrentUrl().contains("google.com"));
	}
	
	@Test
	public void firstFirefoxTest() {
		ff.get("http://www.amazon.com");
		Assert.assertTrue(ff.getCurrentUrl().contains("amazon.com"));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		ff.quit();
	}
	
}
