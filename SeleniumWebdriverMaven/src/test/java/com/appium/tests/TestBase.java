package com.appium.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	static AppiumDriver<?> driver;
	static URL connectionLinkToServer;
	static String appName;

	public enum OS {
		ANDROID("Android"), IOS("IOS");

		private final String osName;

		private OS(final String osName) {
			this.osName = osName;
		}

		public String getOsName() {
			return osName;
		}

	}
	
	public enum APP {
		ANDROID("ApiDemos-debug.apk"), IOS("UICatalog.app");
		private final String appName;
		
		private APP(final String appName) {
			this.appName = appName;
		}

		public String getAppName() {
			return appName;
		}
	}

	@Parameters({ "deviceName", "serverUrl", "appName", "os"})
	@BeforeSuite (alwaysRun = true) 
	public void startDriver(@Optional("iPhone 8") String deviceName, @Optional("http://0.0.0.0:4723/wd/hub") String serverUrl, @Optional("UICatalog.app") String appName, @Optional("IOS") String os) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		connectionLinkToServer = new URL(serverUrl);
		if (os.contains(OS.ANDROID.getOsName())) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ File.separator + "resources" + File.separator + appName);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
			driver = new AndroidDriver<MobileElement> (connectionLinkToServer, capabilities);

		} else if(os.contains(OS.IOS.getOsName())) {
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ File.separator + "resources" + File.separator + appName);
			driver = new IOSDriver<MobileElement> (connectionLinkToServer, capabilities);
		}
	}

	@AfterSuite (alwaysRun = true) 
	public void tearDown() {
		driver.quit();

	}
}
