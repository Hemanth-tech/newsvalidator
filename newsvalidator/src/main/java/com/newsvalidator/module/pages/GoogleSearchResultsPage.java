package com.newsvalidator.module.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchResultsPage {
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(css = "div.g")
	private List<WebElement> searchResults;


	public  GoogleSearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getSearchResults() {
	 return searchResults;
	}

}
