package com.newsvalidator.module.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.newsvalidator.driver.TestDriver;

public class BaseClient {
	
	WebDriver driver = TestDriver.getDriver();
	protected static final Logger logger = LogManager.getLogger(BaseClient.class);

	
	public void navigateTo(String Url) {
		logger.info("navigating to url "+Url);
		driver.get(Url);
	}

	public String getClientTitle() {
		String title = driver.getTitle();
		logger.info("Title of current page "+title);
		return driver.getTitle();
	}

}
