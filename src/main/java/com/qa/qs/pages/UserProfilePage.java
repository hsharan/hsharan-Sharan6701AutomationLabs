package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ElementUtil;

public class UserProfilePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators
	By header = By.xpath("//div//h2[contains(text(),'User Management')]");
	By userProfileAddBtn = By.xpath("(//div//button[@type='button']/div[contains(text(),'Add')])[position()=1]");
	By addHeader = By.xpath("//div/h1[contains(text(),'Add User')]");
	By addName = By.xpath("//label[text()='Name']/..//input[@type='text']");
	By addUserName = By.xpath("//label[contains(text(),'User Name')]/..//input[@type='text']");
	By addUserPWD = By.xpath("//label[contains(text(),'Password')]/..//input[@type='password' and @tabindex='3']");
	By addUserCnfPWD = By.xpath("//label[contains(text(),'Password')]/..//input[@type='password' and @tabindex='4']");
	By addUserEmailId = By.xpath("//label[contains(text(),'Email Address')]/..//input[@type='text']");
	By addUserRole = By.xpath("(//ep-dropdown//span[@role='listbox' and @aria-haspopup='listbox'])[position()=1]");

	By addUserSaveButton = By.xpath("//*[@type='button']/div[text()=' Add']");
	By addCloseButton = By.xpath("//*[@type='button']/div[text()=' Cancel ']");

	// By userProfile = By.xpath("//h4[text()='Users']");
	By userProfileEdit = By
			.xpath("(//table/tbody/tr/td//span[@class='mat-tooltip-trigger mdi-24px mdi mdi-pencil'])[position()=4]");
	By userProfileEditConfirmSave = By.xpath("//button/div[text()=' Save']");
	By userProfileDelete = By
			.xpath("(//table/tbody/tr/td//span[@class='mat-tooltip-trigger mdi-24px mdi mdi-delete'])[position()=4]");
	By userProfileConfirmDelete = By.xpath("//button/div[text()=' Yes ']");
	By

	userProfileResetPWD = By.xpath(
			"(//table/tbody/tr/td//span[@class='mat-tooltip-trigger mdi-24px mdi mdi-lock-reset'])[position()=4]");

	By userProfileResetPWDMsg = By
			.xpath("//div[contains(text(),'Are you sure you want to reset password for this user?')]");

	By userProfileResetPWDYes = By.xpath("//button[text()=' Yes ']");
	By userProfileResetPWDNo = By.xpath("//button[text()=' No ']");

	// inactive
	By userProfileAccessInActiveUsersBtn = By.xpath("//button/div[contains(text(),'Inactive Users')]");

	By userProfileAccessInActiveUsersTitle = By.xpath("//div//h1[contains(text(),'Inactive Users')]");

	By userProfileReActiceUserProfile = By
			.xpath("(//span//div//ancestor::td//preceding-sibling::td//input[@type='checkbox'])[position()=1]");

	By userProfileReActiveBtn = By.xpath("//button/div[contains(text(),'Reactivate')]");

	By userProfileReActiveMsg = By.xpath("//div[contains(text(),'Selected inactive users successfully reactivated.')]");

	By userProfileReActiceUserProfileSuccessMsgClose = By.xpath("//button/span[text()='×']");

	By userProfileReActiceAllUserProfile = By.xpath(
			"//table//tr//th//span[text()='User Name']//ancestor::th//preceding-sibling::th//input[@type='checkbox']");

	// 2. Page constructor
	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page actions
	public String getUserProfilePageHeader() {
		return elementUtil.doGetText(header);
	}
	// Name UserName Password ConfirmPassword emailId Role

	public void createUserRoleRecord(String Name, String UserName, String Password, String ConfirmPassword,
			String emailId, String Role) throws InterruptedException {

		elementUtil.clickWhenReady(userProfileAddBtn, 15);

		elementUtil.doSendKeys(this.addName, Name);
		elementUtil.doSendKeys(this.addUserName, UserName);
		elementUtil.doSendKeys(this.addUserPWD, Password);
		elementUtil.doSendKeys(this.addUserCnfPWD, ConfirmPassword);
		elementUtil.doSendKeys(this.addUserEmailId, emailId);
		elementUtil.doSendKeys(this.addUserRole, Role);
		elementUtil.clickWhenReady(addUserSaveButton, 15);
		Thread.sleep(5000);

	}

	/**
	 * Update data
	 */
	public void updateUserProfileData() {
		elementUtil.clickWhenReady(userProfileEdit, 15);
	}

	public void updateUserProfileDataConfirm() {
		elementUtil.clickWhenReady(userProfileEditConfirmSave, 15);
	}

	/**
	 * Delete user profile
	 */
	public void deleteUserProfile() {
		elementUtil.clickWhenReady(userProfileDelete, 15);
	}

	public void deleteUserProfileSuccess() {
		elementUtil.clickWhenReady(userProfileConfirmDelete, 15);
	}

	/**
	 * Reactivate user
	 */

	public void getInactiveUserProfile() {
		elementUtil.clickWhenReady(userProfileAccessInActiveUsersBtn, 15);
		// elementUtil.waitForElementWithFluentWait(userProfileAccessInActiveUsersBtn,
		// 20, 2);

	}

	public String getInactiveUserProfileTitle() {
		return elementUtil.doGetText(userProfileAccessInActiveUsersTitle);

		// return
		// elementUtil.waitForPageTitlePresent(Constants.USER_INACTIVE_PAGE_TITLE, 20);

	}

	public String getuserProfileReActiveMsg() {
		return elementUtil.doGetText(userProfileReActiveMsg);

	}

	public void clickReActiceUserProfile() {
		elementUtil.clickWhenReady(userProfileReActiveBtn, 15);
		// elementUtil.waitForElementWithFluentWait(userProfileReActiveBtn, 20, 2);
	}

	public void getUserProfileReActiceUserProfileSuccessMsgClose() {
		// elementUtil.clickWhenReady(userProfileReActiceUserProfileSuccessMsgClose,
		// 15);
		elementUtil.waitForElementWithFluentWait(userProfileReActiceUserProfileSuccessMsgClose, 20, 2);
	}

	// waitForElementWithFluentWait
	public void getReActiceUserProfile() throws InterruptedException {
		elementUtil.clickWhenReady(userProfileReActiceUserProfile, 15);
		// elementUtil.waitForElementWithFluentWait(userProfileReActiceUserProfile, 20,
		// 2);
		clickReActiceUserProfile();
		Thread.sleep(1000);
		getuserProfileReActiveMsg();
		getUserProfileReActiceUserProfileSuccessMsgClose();
	}

	public void getAllReActiceUserProfile() {
		elementUtil.clickWhenReady(userProfileReActiceAllUserProfile, 15);
		// elementUtil.waitForElementWithFluentWait(userProfileReActiceAllUserProfile,
		// 20, 2);
		clickReActiceUserProfile();
		getuserProfileReActiveMsg();
		getUserProfileReActiceUserProfileSuccessMsgClose();
	}

	/**
	 * User Rest
	 */
	public String getUserProfileResetPWDMsg() {
		return elementUtil.doGetText(userProfileResetPWDMsg);

	}

	public void getUserProfileResetPWD() {
		elementUtil.clickWhenReady(userProfileResetPWD, 15);
		getUserProfileResetPWDMsg();
	}

	public void getUserProfileResetPWDNo() {
		elementUtil.clickWhenReady(userProfileResetPWDNo, 15);
	}

	public void getUserProfileResetPWDYes() {
		elementUtil.clickWhenReady(userProfileResetPWDYes, 15);
	}
}
