package com.newsvalidator.pojo;

import java.util.List;

public class TestFlowJson {

	private String news;
	private int count;
    private String domain;
	private List<SearchResult> searchResults;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SearchResult> searchResults) {
		this.searchResults = searchResults;
	}

}
