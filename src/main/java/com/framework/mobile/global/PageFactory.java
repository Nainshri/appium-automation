package com.framework.mobile.global;

import com.framework.mobile.pageobjects.DeliveryOptionsScreen;
import com.framework.mobile.pageobjects.HomeScreen;
import com.framework.mobile.pageobjects.LoginScreen;
import com.framework.mobile.pageobjects.ProductDetailsScreen;
import com.framework.mobile.pageobjects.SearchResultsScreen;
import com.framework.mobile.pageobjects.SelectAddressScreen;
import com.framework.mobile.pageobjects.SignInPromptScreen;
import com.framework.mobile.pageobjects.WelcomeScreen;

public class PageFactory extends Base {

	public SignInPromptScreen SignInPromptScreen() {
		return new SignInPromptScreen(driver);
	}

	public WelcomeScreen WelcomeScreen() {
		return new WelcomeScreen(driver);
	}

	public LoginScreen LoginScreen() {
		return new LoginScreen(driver);
	}

	public HomeScreen HomeScreen() {
		return new HomeScreen(driver);
	}

	public SearchResultsScreen SearchResultsScreen() {
		return new SearchResultsScreen(driver);
	}

	public ProductDetailsScreen ProductDetailsScreen() {
		return new ProductDetailsScreen(driver);
	}

	public SelectAddressScreen SelectAddressScreen() {
		return new SelectAddressScreen(driver);
	}

	public DeliveryOptionsScreen DeliveryOptionsScreen() {
		return new DeliveryOptionsScreen(driver);
	}

}
