package com.qa.qs.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.qs.util.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to launch the browser and initialize the web driver
	 * 
	 * @param browserName
	 * @return
	 */
	// public WebDriver init_driver(String browserName) {
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		System.out.println("Browser Name is : " + browserName);
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver(browserName);
			} else {
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}

			// driver = new ChromeDriver(optionsManager.getChromeOptions());

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver(browserName);
			} else {
				tlDriver.set(new FirefoxDriver(optionsManager.getfirefoxOptions()));
			}
			// driver = new FirefoxDriver(optionsManager.getfirefoxOptions());

		} else if (browserName.equals("safari")) {
			// driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please provide correct browser to launch the application : " + browserName);
		}
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	/**
	 * This method will define the desired capabilities and will initialize the
	 * driver with capabilities. This method will send the request to the GRID - HUB
	 * 
	 * @param browserName
	 */
	public void init_remoteDriver(String browserName) {

		if (browserName.equals("chrome")) {
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());

			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		}

		if (browserName.equals("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getfirefoxOptions());

			try {
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		}

	}

	// Thread local method

	/**
	 * getDriver() using thread local
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

	/**
	 * This method is used to initialize the properties from the config file
	 * 
	 * @return Properties prop object
	 */

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".//src//main//java//com//qa//qs//config//config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 */
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
