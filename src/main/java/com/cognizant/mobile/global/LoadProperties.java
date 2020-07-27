package com.cognizant.mobile.global;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to load property values from test.properties. Specifies default value
 * in case its missing from the property file.
 * 
 * @author Nayanshri
 *
 */
public class LoadProperties {
	private static Properties parameters;
	public static final String APP_NAME = getProperty("appName", "Amazon_shopping.apk");
	public static final String APP_DIR_NAME = getProperty("appDirName", "app");
	public static final String DEVICE_NAME = getProperty("deviceName", "Pixel2");
	public static final String AUTOMATION_NAME = getProperty("automationName", "uiautomator2");
	public static final String PORT_NUM = getProperty("portNum", "4723");
	public static final String TEST_DATA_PATH = getProperty("testDataPath",
			"src\\main\\java\\com\\cognizant\\mobile\\testdata\\TestData.xlsx");
	public static final String WORKSHEET_NAME = getProperty("worksheetName", "ProductPurchase");

	public static String getProperty(String key, String defaultValue) {
		if (parameters == null) {
			try {
				parameters = new Properties();
				parameters.load(new FileReader("test.properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return parameters.getProperty(key, defaultValue);
	}

	public static String getProperty(String key) {
		return getProperty(key, key);
	}

}
