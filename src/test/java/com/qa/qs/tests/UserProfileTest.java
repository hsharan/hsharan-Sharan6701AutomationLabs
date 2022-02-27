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
import com.qa.qs.pages.UserProfilePage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ExcelUtil;

public class UserProfileTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	SetUpPage setUpPage;
	UserProfilePage userProfilePage;

	@BeforeTest
	public void SetUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		homePage = loginPage.doLogin(prop.getProperty("regcode").trim(), prop.getProperty("username").trim(),
				prop.getProperty("password").trim());
		setUpPage = homePage.goToSetUpPage();
		userProfilePage = setUpPage.goToUserProfilePage();

	}

	@Test(priority = 1)
	public void verifyUserPageHeaderTest() {
		String header = userProfilePage.getUserProfilePageHeader();
		System.out.println("User Page Header is : " + header);
		Assert.assertEquals(header, Constants.USER_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getUserRoleAddRecordTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.USER_ROLE_DATA_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getUserRoleAddRecordTestData")
	public void verifyCreateUserRoleTest(String Name, String UserName, String Password, String ConfirmPassword,
			String emailId, String Role) throws InterruptedException {

		userProfilePage.createUserRoleRecord(Name, UserName, Password, ConfirmPassword, emailId, Role);

	}

	@Test(priority = 3)
	public void verifyUpdateUserProfileDataTest() {
		userProfilePage.updateUserProfileData();
		System.out.println("Update - User: ");

	}

	@Test(priority = 4)
	public void verifyUpdateUserProfileDataConfirmTest() throws InterruptedException {
		userProfilePage.updateUserProfileDataConfirm();
		System.out.println("Update - YES; updated data is Saved successfully: ");
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void verifyDeleteUserProfile1Test() throws InterruptedException {
		userProfilePage.deleteUserProfile();
		userProfilePage.deleteUserProfileSuccess();
		System.out.println("Delete - Selected User data is Saved successfully: ");
		Thread.sleep(1000);

	}
	@Test(priority = 6)
	public void verifyDeleteUserProfile2Test() throws InterruptedException {
		userProfilePage.deleteUserProfile();
		userProfilePage.deleteUserProfileSuccess();
		System.out.println("Delete - Selected User data is Saved successfully: ");
		Thread.sleep(1000);

	}

	@Test(priority = 7)
	public void verifyUserProfileResetPWDTest() {
		userProfilePage.getUserProfileResetPWD();
		System.out.println("Reset password - Popup message with Yes & No Button ");
		userProfilePage.getUserProfileResetPWDNo();
		System.out.println("Reset password - Click No, no changes in password ");
		userProfilePage.getUserProfileResetPWD();
		System.out.println("Reset password - Popup message with Yes & No Button ");
		userProfilePage.getUserProfileResetPWDYes();
		System.out.println("Reset password - Click Yes, password reset is successfull ");

	}

	@Test(priority =8)
	public void verifygetInactiveUserProfileTest() throws InterruptedException {
		userProfilePage.getInactiveUserProfile();
		//System.out.println("7 : ");

	}

	@Test(priority = 9)
	public void verifygetInactiveUserProfileTitleTest() throws InterruptedException {
		//userProfilePage.getInactiveUserProfile();
		String title = userProfilePage.getInactiveUserProfileTitle();
		System.out.println("In Active User Page Title is : " + title);
		Assert.assertEquals(title, Constants.USER_INACTIVE_PAGE_TITLE);
		//System.out.println("8 : ");
	}

	@Test(priority = 10)
	public void verifygetReActiceUserProfileTest() throws InterruptedException {

		//userProfilePage.getInactiveUserProfile();
		//Thread.sleep(500);

		userProfilePage.getReActiceUserProfile();

		//System.out.println("9 ");
	}

	@Test(priority = 11)
	public void verifygetAllReActiceUserProfileTest() throws InterruptedException {

		userProfilePage.getInactiveUserProfile();
		Thread.sleep(500);
		userProfilePage.getAllReActiceUserProfile();
		//System.out.println("11 ");
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}