package com.newsvalidator.module.stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.newsvalidator.constants.ErrorCodes;
import com.newsvalidator.module.step.GuardianClient;
import com.newsvalidator.utilities.FrameworkUtilities;

import io.cucumber.java.en.Given;

public class GuardianSteps {
	private static final Logger logger = LogManager.getLogger(GuardianSteps.class);

	GuardianClient guardianClient = new GuardianClient();
	String url = FrameworkUtilities.environmnetProperties().getProperty("guardianUrl");
	String expectedPageTitle = "News | The Guardian";

	@Given("I am on The Guardian news article page")
	public void navigateToGuardianArticlePage() {
		guardianClient.navigateTo(url);
		String actualPageTitle = guardianClient.getClientTitle();
		Assert.assertEquals(ErrorCodes.GUARDIAN_TITLE_MISMATCH.getMessage(), actualPageTitle, expectedPageTitle);
	}

	@Given("I get the first news article")
	public void getFirstNewsArticle() throws IOException {
		String news = guardianClient.getHeadingOfFirstNewsArticle();
		guardianClient.uploadFirstNewsToJson(news);

	}

}
