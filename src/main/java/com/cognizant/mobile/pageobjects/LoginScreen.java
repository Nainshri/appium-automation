package com.cognizant.mobile.pageobjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen {
	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'password')]")
	public WebElement passwordField;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	public WebElement signInSubmit;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/apspinner_progressbar")
	public WebElement progressBar;

}
