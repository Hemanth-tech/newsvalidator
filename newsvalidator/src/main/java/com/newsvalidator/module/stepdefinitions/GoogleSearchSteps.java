package com.newsvalidator.module.stepdefinitions;

import org.junit.Assert;

import com.newsvalidator.constants.ErrorCodes;
import com.newsvalidator.module.step.GoogleClient;
import com.newsvalidator.module.step.GuardianClient;
import com.newsvalidator.utilities.FrameworkUtilities;

import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	GoogleClient googleClient = new GoogleClient();
	String url = FrameworkUtilities.environmnetProperties().getProperty("google");
	String expectedPageTitle = "Google";

	@When("I search for similar article using Google")
    public void searchForSimilarArticle() {
    	googleClient.navigateTo(url);
		Assert.assertEquals(ErrorCodes.GOOGLE_TITLE_MISMATCH.getMessage(), googleClient.getClientTitle(), expectedPageTitle);
    	googleClient.submitSearch();
    }

}
