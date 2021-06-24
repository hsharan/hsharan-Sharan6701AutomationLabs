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
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;


public class SetUpPageTest {
	
		WebDriver driver;
		BasePage basePage;
		Properties prop;
		LoginPage loginPage;
		HomePage homePage;
		SetUpPage setUpPage;
				

		@BeforeTest
		public void SetUp() {

			basePage = new BasePage();
			prop = basePage.init_prop();
			driver = basePage.init_driver(prop);
			loginPage = new LoginPage(driver);
			
			homePage = loginPage.doLogin(prop.getProperty("regcode").trim(),
						prop.getProperty("username").trim(),
						prop.getProperty("password").trim());
			setUpPage = homePage.goToSetUpPage();

		}
	
		@Test(priority = 1)
		public void setUpPageTitleTest() {
			String title = setUpPage.getsetUpPagePageTitle();
			System.out.println("Setup Page Title is : " + title);
			Assert.assertEquals(title, Constants.SETUP_PAGE_TITLE);
			
				
		}
		@Test(priority = 2)
		public void setUpPageHeaderTest() {
			String header = setUpPage.getsetUpPagePageHeader();
			System.out.println("Setup Page Header is : " + header);
			Assert.assertEquals(header, Constants.SETUP_PAGE_HEADER);
			
				
		}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
	
	
	

}
