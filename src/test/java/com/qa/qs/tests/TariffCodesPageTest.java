package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.pages.TariffCodesPage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class TariffCodesPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	TariffCodesPage tariffCodesPage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		tariffCodesPage = setUpPage.goToTariffCodePage();

	}

	@Test(priority = 1)
	public void verifyTariffCodePageHeaderTest() {
		String header = tariffCodesPage.getTariffCodePageHeader();
		System.out.println("Tariff Code Page Header is : " + header);
		Assert.assertEquals(header, Constants.TARIFF_CODE_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getTariffCodeAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.TARIFF_CODE_DATA_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getTariffCodeAddRecordTestData")
	public void verifyCreateTariffCodeTest(String tariffCode, String tariffDesc, String tariffUM) throws InterruptedException {

		tariffCodesPage.createTariffCodeRecord(tariffCode, tariffDesc, tariffUM);

	}
	@Test(priority = 3)
	public void verifyGetUpdateTariffDataTest() {
		tariffCodesPage.getUpdateTariffData();
		
		String tariffUpdateMsg = tariffCodesPage.getUpdateTariffDataSave();
		System.out.println("Update - User: "+tariffUpdateMsg);
		Assert.assertEquals(tariffUpdateMsg, Constants.TARIFF_SAVE_MESG);
	}

	@Test(priority = 4)
	public void verifyDeleteTariffDataNoTest() throws InterruptedException {
		tariffCodesPage.getDeleteTariffData();
		tariffCodesPage.getDeleteTariffDataMsg();
		
		tariffCodesPage.clickDeleteTariffDataNo();
		System.out.println("Delete - CLICK NO: ");
		Thread.sleep(1000);

	}
	@Test(priority = 5)
	public void verifyDeleteTariffDataYesTest() throws InterruptedException  {
		Thread.sleep(1000);
		tariffCodesPage.getDeleteTariffData();
		tariffCodesPage.getDeleteTariffDataMsg();
		
		tariffCodesPage.clickDeleteTariffDataYes();
		System.out.println("Delete - CLICK YES: ");
		

	}
	
	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}