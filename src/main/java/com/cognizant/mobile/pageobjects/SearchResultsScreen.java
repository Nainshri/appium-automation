package com.cognizant.mobile.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchResultsScreen {
	public SearchResultsScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchField;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/list_product_linear_layout")
	public List<WebElement> searchResults;

	/**
	 * Method selects a random product from the search results list
	 */
	public void selectRandomSearchResult() {
		int searchResultSize = searchResults.size();
		Random random = new Random();
		int randomIndex = random.nextInt(searchResultSize);
		searchResults.get(randomIndex).click();
	}
}
