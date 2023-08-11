package com.newsvalidator.module.step;

import java.io.IOException;
import com.newsvalidator.module.pages.GuardianPage;
import com.newsvalidator.utilities.JsonUtilities;

public class GuardianClient extends BaseClient {

	GuardianPage guardianPage = new GuardianPage(driver);

	public void acceptCookies() {
		guardianPage.getIframeElement().click();
		guardianPage.clickAcceptCookies();
		logger.info("accepted cookies");

	}

	public String getHeadingOfFirstNewsArticle() {
		acceptCookies();
		String newsHeadline = guardianPage.getFirstNews();
		logger.info("first news headline from Guardian "+newsHeadline);
		return newsHeadline;
	}

	public void uploadFirstNewsToJson(String news) throws IOException {
		JsonUtilities.getTestFlowData().setNews(news);
		JsonUtilities.updateTestFlowData();
		logger.info("Uploaded newsHeadline to Json ");

	}

}
