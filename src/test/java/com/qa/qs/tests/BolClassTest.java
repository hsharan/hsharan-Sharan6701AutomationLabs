package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.BolClassPage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class BolClassTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	BolClassPage bolClassPage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		bolClassPage = setUpPage.goToBOLClassPage();

	}

	@Test(priority = 1)
	public void verifyBolClassPageHeader() {
		String header = bolClassPage.getBolClassPageHeader();
		System.out.println("BOL Class Page Header is : " + header);
		Assert.assertEquals(header, Constants.BOL_CLASS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getBOLClassAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.BOL_CLASS_DATA_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getBOLClassAddRecordTestData")
	public void verifyCreateBOLCalssTest(String Key, String Description, String FreightClass, String NMFCNumber,
			String SubClass) throws InterruptedException {

		bolClassPage.createBolClassRecord(Key, Description, FreightClass, NMFCNumber, SubClass);

	}

	@Test(priority = 3)
	public void verifyUpdateBOLClassDataTest() {
		bolClassPage.getUpdateBOLClassData();
		//bolClassPage.getUpdateBOLClassSaveData();
		System.out.println("Update - User: ");

	}

	@Test(priority = 4)
	public void verifyUpdateBOLClassSaveDataTest() throws InterruptedException {
		bolClassPage.getUpdateBOLClassSaveData();
		System.out.println("Update - YES; updated data is Saved successfully: ");
		Thread.sleep(1000);

	}
	
	@Test(priority = 5)
	public void getDeleteBolClassDataNoTest() {
		bolClassPage.getDeleteBolClassData();
		System.out.println("Popup message with Yes & No Button ");
		bolClassPage.getDeleteUserNo();
		System.out.println("No record is deleted with No button");
		}
	@Test(priority = 6, invocationCount=2)
	public void getDeleteBolClassDataYesTest() throws InterruptedException {
		bolClassPage.getDeleteBolClassData();
		System.out.println("Popup message with Yes & No Button ");
		bolClassPage.getDeleteUserYes();
		System.out.println("Click Yes, deleted the selected record is successfull ");
		Thread.sleep(800);
		}
	
	


	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
