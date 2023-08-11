package sampleTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newsvalidator.utilities.FrameworkUtilities;

import org.apache.commons.text.similarity.JaccardSimilarity;
import org.junit.Assert;

public class TestFile {

	public static void main(String[] args) {
		String guardianDomain = "www.theguardian.com";
		System.setProperty("webdriver.chrome.driver", FrameworkUtilities.ConfigFileReader().getProperty(guardianDomain));
		String expectedGuardainPageTitle = "News | The Guardian";
		String expectedGooglePageTitle = "Google";
		String expectedsearchResultsPageTitle= "Google Search";
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
//		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.theguardian.com/tone/news");
		driver.manage().window().maximize();
		String actualGuardainPageTitle = driver.getTitle();
		System.out.println("**************actualGuardainPageTitle****************************"+actualGuardainPageTitle);

		Assert.assertEquals("", expectedGuardainPageTitle, actualGuardainPageTitle);
		
//		WebElement framePath = driver.findElement(By.xpath("//iframe[@title='The Guardian consent message']"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//iframe[@title='The Guardian consent message']"))));

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='The Guardian consent message']")));
		
		WebElement acceptCookies = driver.findElement(By.xpath("//button[@title='Yes, I’m happy']"));
		wait.until(ExpectedConditions.visibilityOf(acceptCookies));
		acceptCookies.click();
		driver.switchTo().defaultContent();

		
		WebElement news = driver.findElement(By.xpath("(//span[@class='js-headline-text'])[1]"));
		String newsString = news.getText();
		System.out.println("**********************new to be validated********************"+newsString);

		
		driver.get("https://www.google.com/");
		String actualGooglePageTitle = driver.getTitle();
		System.out.println("**********************actualGooglePageTitle********************"+actualGooglePageTitle);

		Assert.assertEquals("", expectedGooglePageTitle, actualGooglePageTitle);

		WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
        searchBox.sendKeys(newsString);
        searchBox.submit();
        
		String actualSearchResultsPageTitle= driver.getTitle();
		System.out.println("**********************actualSearchResultsPageTitle********************"+actualSearchResultsPageTitle);

		Assert.assertTrue("", actualSearchResultsPageTitle.contains(actualSearchResultsPageTitle));
		List<WebElement> searchResults= driver.findElements(By.cssSelector("div.g"));
		Set<String> domains = new HashSet<String>();
		int checker = 0;
		Map<String,Double> domainSimilarity = new HashMap<String,Double>();
		for (WebElement searchResult: searchResults) {
//            WebElement result = searchResults.get(i);
            WebElement title = searchResult.findElement(By.cssSelector("h3"));
            String linkText = title.getText();
            String linkUrl = searchResult.findElement(By.cssSelector("a")).getAttribute("href");
            
            String domain = linkUrl.substring(8, linkUrl.indexOf('/', 9));
            
            if(domains.add(domain) && !linkText.isEmpty() && !domain.equals(guardianDomain)) {
            double similarity = calculateSemanticSimilarity(newsString, linkText);

            System.out.println("Semantic Similarity: " + similarity);

            if(similarity>0.6) {
            	checker++;
            }
            System.out.println("Result " + searchResults.indexOf(searchResult) + ": " + linkText);
            System.out.println("URL: " + linkUrl);
            System.out.println("domain " + domain);

            System.out.println("--------------------------");

//            if(checker>=2) {
//            	break;
//            }
            
            }
        }
		
	//		for (int i = 0; i < searchResults.size(); i++) {
	//            WebElement result = searchResults.get(i);
	//            WebElement title = result.findElement(By.cssSelector("h3"));
	//            String linkText = title.getText();
	//            String linkUrl = result.findElement(By.cssSelector("a")).getAttribute("href");
	//            
	//            double similarity = calculateSemanticSimilarity(newsString, linkText);
	//
	//            System.out.println("Semantic Similarity: " + similarity);
	//
	//            System.out.println("Result " + (i + 1) + ": " + linkText);
	//            System.out.println("URL: " + linkUrl);
	//            System.out.println("--------------------------");
	//        }
		

	}
	
	
	   public static double calculateSemanticSimilarity(String text1, String text2) {
	        JaccardSimilarity jaccard = new JaccardSimilarity();

	        CharSequence charSequence1 = new StringBuilder(text1.toLowerCase().replace(" ", ""));
	        CharSequence charSequence2 = new StringBuilder(text2.toLowerCase().replace(" ", ""));

	        return jaccard.apply(charSequence1, charSequence2);
	    }

}
