package com.cognizant.mobile.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailsScreen {
	AndroidDriver<AndroidElement> driver;

	public ProductDetailsScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "//android.view.View[@resource-id='title_feature_div']/android.view.View")
	public WebElement productDetails;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add to Cart']")
	public WebElement addToCartButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed to checkout']")
	public WebElement proceedToCheckoutButton;

	/**
	 * Method scrolls through the screen to search for add to cart button. Returns
	 * true if found else returns false.
	 * 
	 * @return
	 */
	public boolean isAddToCartButtonPresent() {
		try {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add to Cart\"));").click();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
