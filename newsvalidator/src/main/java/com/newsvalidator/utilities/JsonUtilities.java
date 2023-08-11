
package com.newsvalidator.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newsvalidator.pojo.SearchResult;
import com.newsvalidator.pojo.TestFlowJson;

public class JsonUtilities {
	protected static final Logger logger = LogManager.getLogger(JsonUtilities.class);

	private static TestFlowJson testFlowJson;
	public static String testDataPath = FrameworkUtilities.ConfigFileReader().getProperty("testData");


	public static TestFlowJson getTestFlowData() {

		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(testDataPath));
			testFlowJson = gson.fromJson(bufferReader, TestFlowJson.class);
			return testFlowJson;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Test data Json file not found at path : " + testDataPath);
		}
	}

	public static void clearExistingData() throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(testDataPath));

		JsonObject jsonObject = new Gson().fromJson(bufferReader, JsonObject.class);
		jsonObject.remove("searchResults");
		testFlowJson = new Gson().fromJson(jsonObject, TestFlowJson.class);

		updateTestFlowData();

	}

	public static void updateTestFlowData() throws IOException {
		Gson gson = new Gson();
		try {
			File jsonFile = new File(testDataPath);
			OutputStream outputStream = new FileOutputStream(jsonFile);
			outputStream.write(gson.toJson(testFlowJson).getBytes());
			outputStream.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Test data Json file not found at updating : " + testDataPath);
		}
	}
	
	public static void setValues(int index, String domain, String newsHeadline, double similarity) throws IOException {
		List<SearchResult> searchResultsList = getTestFlowData().getSearchResults();

		if (searchResultsList == null)
			searchResultsList = new ArrayList<SearchResult>();

		SearchResult searchResult = new SearchResult();
		searchResult.setDomain(domain);
		searchResult.setDomainNews(newsHeadline);
		searchResult.setSimilarity(similarity);
		searchResultsList.add(searchResult);
		getTestFlowData().setSearchResults(searchResultsList);
		updateTestFlowData();

	}

}
