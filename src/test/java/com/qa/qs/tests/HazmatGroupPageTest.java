package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;

import com.qa.qs.pages.HazmatGroupPage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class HazmatGroupPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	HazmatGroupPage hazmatGroupPage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		hazmatGroupPage = setUpPage.goToHazmatGroupPage();

	}

	@Test(priority = 1)
	public void verifyHzGroupPageHeader() {
		String HzGroupHeader = hazmatGroupPage.getHazmatGroupPageHeader();
		System.out.println("Hazmat Group Page Header is : " + HzGroupHeader);
		Assert.assertEquals(HzGroupHeader, Constants.HAZMAT_GROUP_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getHzGroupPageAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.HAZMAT_GROUP_DATA_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getHzGroupPageAddRecordTestData")
	public void verifyCreateHzGroupPageTest(String hzDescription, String hzProperShippingName, String hzTechName,
			String hzPackingInstructions, String hzLabelingInstructions, String hzIATA, String hzClass,
			String hzSubClass, String hzPackingGroup, String hzUM, String hzERR, String hzERP, String hzPiSuffix,
			String hzAlwaysShippedAsExceptedQty, String hzReportAsGrossWeight, String hzIsAtaSpec300)
			throws InterruptedException {

		hazmatGroupPage.createHazmatRecord(hzDescription, hzProperShippingName, hzTechName, hzPackingInstructions,
				hzLabelingInstructions, hzIATA, hzClass, hzSubClass, hzPackingGroup, hzUM, hzERR, hzERP, hzPiSuffix,
				hzAlwaysShippedAsExceptedQty, hzReportAsGrossWeight, hzIsAtaSpec300);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}