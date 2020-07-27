package com.cognizant.mobile.global;

import com.cognizant.mobile.pageobjects.DeliveryOptionsScreen;
import com.cognizant.mobile.pageobjects.HomeScreen;
import com.cognizant.mobile.pageobjects.LoginScreen;
import com.cognizant.mobile.pageobjects.ProductDetailsScreen;
import com.cognizant.mobile.pageobjects.SearchResultsScreen;
import com.cognizant.mobile.pageobjects.SelectAddressScreen;
import com.cognizant.mobile.pageobjects.SignInPromptScreen;
import com.cognizant.mobile.pageobjects.WelcomeScreen;

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
