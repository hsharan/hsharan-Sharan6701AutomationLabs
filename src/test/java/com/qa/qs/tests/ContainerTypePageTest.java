package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.ContainerTypePage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class ContainerTypePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	ContainerTypePage containerTypePage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		containerTypePage = setUpPage.goToContainerTypePage();
	}

	@Test(priority = 1)
	public void verifyCTPageHeader() {
		String ctpHeader = containerTypePage.getContainerTypePageHeader();
		System.out.println("Container Type Page Header is : " + ctpHeader);
		Assert.assertEquals(ctpHeader, Constants.CONTAINER_TYPE_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getContainerTypeAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTAINER_TYPE_DATA_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getContainerTypeAddRecordTestData")
	public void verifyAddContainerTypeRecordTest(String Code, String BOLPieces, String Type, String Length,
			String Width, String Height, String TareWeight, String Assigned, String Default)
			throws InterruptedException {

		containerTypePage.addContainrTypeRecord(Code, BOLPieces, Type, Length, Width, Height, TareWeight, Assigned,
				Default);

	}

	@Test(priority = 3)
	public void verifyUpdateUserProfileDataTest() {
		containerTypePage.updateContainerTypeData();
		System.out.println("Update - Container type screen: ");

	}

	@Test(priority = 4)
	public void verifyUpdateUserProfileDataConfirmTest() throws InterruptedException {

		containerTypePage.updateContainerTypeDataConfirm();

		System.out.println("Update - YES; updated data is Saved successfully: ");
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void verifyDeleteUserProfileTest() throws InterruptedException {
		containerTypePage.deleteContainerTypeData();
		containerTypePage.deleteContainerTypeDataConfirm();
		System.out.println("Delete - Selected User data is Saved successfully: ");
		Thread.sleep(1000);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
