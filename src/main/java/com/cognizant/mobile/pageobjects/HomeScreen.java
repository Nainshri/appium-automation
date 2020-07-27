package com.cognizant.mobile.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	public HomeScreen(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public WebElement searchField;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login']")
	public WebElement signInSubmit;
	
}
