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



public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		
		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(),
					prop.getProperty("username").trim(),
					prop.getProperty("password").trim());

	}
	
	@Test(priority = 1)
	public void homePageHeaderTest() {
		String header = homePage.getHomePageHeaderValue();
		System.out.println("Home Page Header is : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
			
	}
	@Test(priority = 2)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
			
	}
	
	@Test(priority = 3)
	public void userAccountNameTest() {
		String accountWS = homePage.isExistWSnameTest();
		String accName=  accountWS.trim();
		System.out.println("The loggedIn Workstations  : " + accName);
		Assert.assertEquals(accName, prop.getProperty("workstation").trim());
		
		
	}
	
	
	@Test(priority = 5)
	public void iconMenuExistsTest() {
		Assert.assertTrue(homePage.isExistMenuIcon());
		
	}
	@Test(priority = 4)
	public void iconHomeExistsTest() {
		Assert.assertTrue(homePage.isExistHomeIcon());
		
	}
	
	@Test(priority = 6)
	public void iconHelpExistsTest() {
		Assert.assertTrue(homePage.isExistHelpIcon());
		
	}
	
	@Test(priority = 7)
	public void iconAcountExistsTest() {
		Assert.assertTrue(homePage.isExistAccoutIcon());
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
