package SeleniumMaven.Maven;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDemo {

	WebDriver chromeDriver = new ChromeDriver();
	WebDriver ffDriver = new FirefoxDriver();

	@BeforeClass
	public void init() {
		String chromePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "chromedriver";
		String geckoPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "geckodriver";
		System.setProperty("webdriver.chrome.driver", chromePath);
		System.setProperty("webdriver.gecko.driver", geckoPath);	
	}

	@Test(groups= {"testGroup"})
	public void openURL() {
		System.out.println("The website url will open here");
		chromeDriver.get("http://www.google.com");
		Assert.assertTrue(chromeDriver.getCurrentUrl().contains("google.com"));
		ffDriver.get("http://www.amazon.com");
		Assert.assertTrue(ffDriver.getCurrentUrl().contains("amazon.com"));
	}

	@Test
	public void userCanLogin() {
		System.out.println("User login method");
	}

	@Test
	public void userCanBuyFromWebsite() {
		System.out.println("User can buy products from website");
	}

	@AfterTest
	public void closeWebsite() {
		System.out.println("Closing website");
		chromeDriver.quit();
		ffDriver.quit();
	}

}
