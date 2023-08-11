package com.newsvalidator.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.newsvalidator.utilities.FrameworkUtilities;

public class TestDriver {

	private static TestDriver testDriver;

	private static WebDriver driver;
	public final static int TIMEOUT = 10;


	private TestDriver(String browser) {

		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", FrameworkUtilities.ConfigFileReader().getProperty("chromeDriver"));
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--incognito");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver(String browser) {

		if (testDriver == null) {
			testDriver = new TestDriver(browser);
		}
	}

	public static void tearDown() {

		if (driver != null) {
			driver.close();
			driver.quit();
		}

		testDriver = null;
	}

}
