package com.newsvalidator.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.newsvalidator.module.stepdefinitions.GuardianSteps;
import com.newsvalidator.utilities.JsonUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	String browser = System.getProperty("browser", "chrome");
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setup() throws IOException {
		/*
		 * To Setup Driver
		 */
		logger.info("Launching browser " + browser);
		TestDriver.setUpDriver(browser);
		/*
		 * To clear old data from json
		 */
		JsonUtilities.clearExistingData();

	}

	@After
	public void teardown() throws FileNotFoundException {
		// To close the existing browser sessions
		TestDriver.tearDown();
		logger.info("End of the scenario");

	}
}
