package com.framework.mobile.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.mobile.global.PageFactory;
import com.framework.mobile.testdata.TestDataProvider;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestProductPurchase extends PageFactory {

	@BeforeTest
	public void setUp() throws IOException {
		super.setUp();
	}

	/**
	 * Test to verify the product information on Product details screen matches that
	 * displayed on the later screens
	 * 
	 * @param username   Username for logging in
	 * @param password   Password for the given username
	 * @param searchText Product name to search
	 * @throws Exception
	 */
	@Test(dataProvider = "Product Purchase", dataProviderClass = TestDataProvider.class)
	public void productPurchaseTest(String username, String password, String searchText) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SignInPromptScreen().signInButton));
		SignInPromptScreen().signInButton.click();
		wait.until(ExpectedConditions.visibilityOf(WelcomeScreen().emailField));
		WelcomeScreen().emailField.sendKeys(username);
		WelcomeScreen().continueButton.click();
		wait.until(ExpectedConditions.visibilityOf(LoginScreen().passwordField));
		LoginScreen().passwordField.sendKeys(password);
		LoginScreen().signInSubmit.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(HomeScreen().searchField));
		} catch (NoSuchElementException e) {

		}
		HomeScreen().searchField.click();
		try {
			SearchResultsScreen().searchField.sendKeys(searchText);
		} catch (StaleElementReferenceException e) {
			SearchResultsScreen().searchField.sendKeys(searchText);
		}
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Boolean isAvailable = false;
		String productDetailsText = "";
		// Handling scenario where selected product is unavailable
		while (!isAvailable) {
			SearchResultsScreen().selectRandomSearchResult();
			productDetailsText = ProductDetailsScreen().productDetails.getText();
			if (ProductDetailsScreen().isAddToCartButtonPresent()) {
				break;
			} else {
				//Go Back to the search results
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
		}
		ProductDetailsScreen().proceedToCheckoutButton.click();
		SelectAddressScreen().useThisAddressButton.click();
		wait.until(ExpectedConditions.visibilityOf(DeliveryOptionsScreen().deliveryOptionsHeading));
		assertTrue(DeliveryOptionsScreen().verifyTextPresent(productDetailsText));
		// Changing rotation and checking for product info text
		driver.rotate(ScreenOrientation.LANDSCAPE);
		assertTrue(DeliveryOptionsScreen().verifyTextPresent(productDetailsText));
	}
}