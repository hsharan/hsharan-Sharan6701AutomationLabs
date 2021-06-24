package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.CustomerPage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;



public class CustomerPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	CustomerPage customerPage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		customerPage = setUpPage.goToCustomerPage();

	}

	@Test(priority = 1)
	public void verifyCustomerPageHeaderTest() {
		String header = customerPage.getCustomerPageHeader();
		System.out.println("Customer Page Header is : " + header);
		Assert.assertEquals(header, Constants.CUSTOMER_PAGE_HEADER);
	}

	/*
	 * @DataProvider public Object[][] getCustomersAddRecordTestData() { Object
	 * data[][] = ExcelUtil.getTestData(Constants.CUSTOMER_DATA_SHEET_NAME); return
	 * data; }
	 * 
	 * @Test(priority = 2, dataProvider = "getCustomersAddRecordTestData") public
	 * void verifyCreateContactTest(String custKey, String custCompany, String
	 * custContactName, String custPhoneNum, String custEmailId, String custTaxId,
	 * String custAddressType, String custAddress1, String custCountryType, String
	 * custDistrictType, String custCity, String custPostCode) {
	 * customerPage.createCustomerRecord(custKey,custCompany,custContactName,
	 * custPhoneNum,custEmailId,
	 * custTaxId,custAddressType,custAddress1,custCountryType,custDistrictType,
	 * custCity,custCity); }
	 * 
	 */

	@Test(priority = 2)
	public void verifyCreateContactTest() {
		customerPage.createCustomerRecord("DH-04", "DH-company4", "Dhruva4", "7338222206", "dhruva@automationlabs.com",
				"9999999999", "Customer", "67012 - Test Dhruva2", "Canada", "Ontario", "Belleville", "K8N 5W6");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}