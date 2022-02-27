package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.ElementUtil;

public class BolClassPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators
	By headerBOL = By.xpath("//div//h1[contains(text(),'BOL Class')]");
	By bolClassAddBtn = By.xpath("//button[@type='button']/div[contains(text(),'Add BOL Class')]");

	By addBolClassTitle = By.xpath("//div/h5[contains(text(),'Add')]");
	By addBolClassKey = By.xpath("//label[text()='Key*']/..//input[@type='text']");
	By addBolClassDesc = By.xpath("//label[text()='Description']/..//input[@type='text']");
	By addBolClassFRClass = By.xpath("//input[@aria-haspopup='listbox']");
	By addBolClassNMFCNumber = By.xpath("//label[text()='NMFC Number']/..//input[@type='text']");
	By addBolClassSubClass = By.xpath("//label[text()='Sub Class']/..//input[@type='text']");
	By addBolClassCloseBtn = By.xpath("//button[@type='button']/div[contains(text(),'Close')]");
	By addBolClassSaveBtn = By.xpath("//button[@type='button']/div[contains(text(),'Save')]");

	By updateBolClassData = By.xpath(
			"(//table[@class='k-grid-table']//tr/td[@aria-colindex='5']//div[@name='actionsDiv']//span)[position()=1]");
	By deleteBolClassBtn = By.xpath(
			"(//table[@class='k-grid-table']//tr/td[@aria-colindex='5']//div[@name='actionsDiv']//span)[position()=2]");

	By deleteBolClassDataPopUpMsg = By.xpath("//div[contains(text(),'Are you sure you want to delete ?')]");
	By deleteBolClassDataYes = By.xpath("//button[contains(text(),'Yes')]");
	By deleteBolClassDataNo = By.xpath("//button[contains(text(),'No')]");

	// 2. Page constructor
	public BolClassPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page actions

	public String getBolClassPageHeader() {
		return elementUtil.doGetText(headerBOL);
	}

	public String getBolClassAddPageTitle() {

		elementUtil.clickWhenReady(bolClassAddBtn, 15);
		return elementUtil.doGetText(addBolClassTitle);
	}
//Key	Description	FreightClass	NMFCNumber	SubClass

	public void createBolClassRecord(String Key, String Description, String FreightClass, String NMFCNumber,
			String SubClass) throws InterruptedException {

		elementUtil.clickWhenReady(bolClassAddBtn, 15);

		elementUtil.doSendKeys(this.addBolClassKey, Key);
		elementUtil.doSendKeys(this.addBolClassDesc, Description);
		elementUtil.doSendKeys(this.addBolClassFRClass, FreightClass);
		elementUtil.doSendKeys(this.addBolClassNMFCNumber, NMFCNumber);
		elementUtil.doSendKeys(this.addBolClassSubClass, SubClass);
		elementUtil.clickWhenReady(addBolClassSaveBtn, 15);
		Thread.sleep(5000);

	}

	/**
	 * Update data
	 */
	public void getUpdateBOLClassData() {
		elementUtil.clickWhenReady(updateBolClassData, 15);
		elementUtil.doSendKeys(addBolClassDesc, "Updated");
	}

	public void getUpdateBOLClassSaveData() {
		elementUtil.clickWhenReady(addBolClassSaveBtn, 15);
	}

	/**
	 * Delete user profile
	 */
	public String getBolClassPopUpMsg() {
		return elementUtil.doGetText(deleteBolClassDataPopUpMsg);

	}
	public void getDeleteBolClassData() {
		elementUtil.clickWhenReady(deleteBolClassBtn, 15);
		getBolClassPopUpMsg();
	}
	
	public void getDeleteUserNo() {
		elementUtil.clickWhenReady(deleteBolClassDataNo, 15);
	}

	public void getDeleteUserYes() {
		elementUtil.clickWhenReady(deleteBolClassDataYes, 15);
	}
	

}
