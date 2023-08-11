package com.newsvalidator.module.step;

import com.newsvalidator.module.pages.GoogleSearchPage;
import com.newsvalidator.utilities.JsonUtilities;

public class GoogleClient extends BaseClient {

	GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

	public String getNewsfromJson() {
		String news = JsonUtilities.getTestFlowData().getNews();
		logger.info("news headline to verified "+news);
		return news;
	}

	public void submitSearch() {
		googleSearchPage.submitSearch(getNewsfromJson());
		logger.info("submitted search on google");

	}

}
