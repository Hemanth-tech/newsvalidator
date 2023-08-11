package com.newsvalidator.module.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[@name='q']")
	private WebElement search;


	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void submitSearch(String news) {
		search.sendKeys(news);
		search.submit();
	}

}
