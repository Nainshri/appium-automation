package com.cognizant.mobile.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.mobile.global.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DeliveryOptionsScreen extends Base {
	public DeliveryOptionsScreen(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView")
	public WebElement productDetailsCheckout;

	@AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Choose your delivery options')]")
	public WebElement deliveryOptionsHeading;

	public boolean verifyTextPresent(String text) {
		return driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + text + "')]")).isDisplayed();
	}
}
