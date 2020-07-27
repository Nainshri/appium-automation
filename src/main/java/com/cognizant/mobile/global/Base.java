package com.cognizant.mobile.global;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;

	public void setUp() throws IOException {
		service = startServer();
		driver = capabilities(LoadProperties.APP_NAME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public AppiumDriverLocalService startServer() {
		boolean flag = isServerRunning(Integer.parseInt(LoadProperties.PORT_NUM));
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean isServerRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
		File appDir = new File(LoadProperties.APP_DIR_NAME);
		File app = new File(appDir, LoadProperties.APP_NAME);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, LoadProperties.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, LoadProperties.AUTOMATION_NAME);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + LoadProperties.PORT_NUM + "/wd/hub"), capabilities);
		return driver;
	}

}
