package com.newsvalidator.module.stepdefinitions;

import java.io.IOException;

import com.newsvalidator.module.step.GoogleClient;
import com.newsvalidator.module.step.GoogleSearchResultsClient;

import io.cucumber.java.en.Then;

public class GoogleSearchResultsSteps {
	
	GoogleSearchResultsClient googleSearchResultsClient = new GoogleSearchResultsClient();

	
	@Then("I should see at least {string} similar articles")
	    public void verifySimilarArticleCount(String expectedCount) throws NumberFormatException, IOException {
		 googleSearchResultsClient.searchResultsEvaluator(Integer.parseInt(expectedCount));
	    }

}
