package com.qa.qs.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qs.base.BasePage;
import com.qa.qs.pages.CustomerPage;
import com.qa.qs.pages.HomePage;
import com.qa.qs.pages.LoginPage;
import com.qa.qs.pages.ProductPage;
import com.qa.qs.pages.SetUpPage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class ProductPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	ProductPage productPage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		productPage = setUpPage.goToProductPage();

	}

	@Test(priority = 1)
	public void verifyProductPageHeaderTest() {
		String header = productPage.getPorductPageHeader();
		System.out.println("Product Page Header is : " + header);
		Assert.assertEquals(header, Constants.PRODUCT_PAGE_HEADER);
	}

	
	
	@DataProvider
	public Object[][] getProductAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.PRODUCT_DATA_SHEET_NAME);
		return data;
		
	}
	//														

	@Test(priority = 2, dataProvider = "getProductAddRecordTestData")
	public void verifyProductAddRecordTest(
			String prodName, String prodDescription, String prodUM,
			String prodHZGroup, String prodBOLClass, String prodUnitWeight, String prodHZMass,
			String prodTariffCode,String prodCountry,
			String prodNetCostMethod, String naftaPreference, String prodProducer, 
			String prodFairMarketValue,String prodECCN, String prodOriginProvince) throws InterruptedException {
		
		productPage.addProductRecord(prodName, prodDescription, prodUM, prodHZGroup, prodBOLClass, prodUnitWeight, prodHZMass, prodTariffCode, prodCountry, prodNetCostMethod, naftaPreference, prodProducer, prodFairMarketValue, prodECCN, prodOriginProvince);
		
	}
	
	
	
//	  @Test(priority = 2) public void verifyProductAddRecordTest2() throws InterruptedException {
//		  productPage.addProductRecord("s2g", "s2h", "EA", "NULL", "FAK", "1", "0", "1111.12.2312", "United States", "NC", "B", "Yes", "1", "EAR99", "US"); }
//	 
	


	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
