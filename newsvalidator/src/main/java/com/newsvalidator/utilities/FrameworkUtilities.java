package com.newsvalidator.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.newsvalidator.module.step.BaseClient;

public class FrameworkUtilities {
	protected static final Logger logger = LogManager.getLogger(FrameworkUtilities.class);

	private static Properties properties;
	private static Properties envProperties;
	private static final String propertyFilePath = "configs/Configuration.properties";
	public static String envToTest = System.getProperty("envToTest", "QA");

	
	public static Properties environmnetProperties() {
		String filePath = "configs/qa.properties";
      logger.info("Test environment "+envToTest);
		if (envToTest.equals("QA")) {
			filePath = "configs/qa.properties";
		}
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			envProperties = new Properties();
			try {
				envProperties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("envProperties not found at "+envToTest+" "+ filePath);
		}

		return envProperties;
	}

	public static Properties ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

		return properties;
	}


}
