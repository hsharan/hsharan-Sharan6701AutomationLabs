package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.util.Constants;

public class LoginPageTest {

	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
	    driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		
		
		
		
		//driver.get("http://sharantest6701/dist/#/login");

	}

	@Test(priority = 1)
	public void verifyLoginPageTitle() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is : " + titleLoginPage);
		Assert.assertEquals(titleLoginPage,Constants.LOGIN_PAGE_TITLE, Constants.LOGIN_PAGE_TITLE_ERROR_MESG);

	}

	@Test(priority = 2)
	public void loginTest() {
		//loginPage.doLogin(prop.getProperty(regcode,username,password));
		HomePage homePage = loginPage.doLogin(prop.getProperty("regcode").trim(),prop.getProperty("username").trim(),prop.getProperty("password").trim());
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is  : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
