package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.ElementUtil;

public class CustomerPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1. By locators
	By header = By.xpath("//h5[text()='Customers']");
	By custAddBtn = By.xpath("//div[text()=' Add ']");
	By custKey = By.xpath("//label[text()='Key*']/..//input");
	By custCompany = By.xpath("//label[text()='Company*']/..//input");
	By custContactName = By.xpath("//label[text()='Contact Name']/..//input");
	By custPhoneNum = By.xpath("//label[text()='Phone Number']/..//input");
	By custAddress1 = By.xpath("//label[text()='Address Line 1']/..//input");
	By custAddress2 = By.xpath("//label[text()='Address Line 2']/..//input");
	By custAddress3 = By.xpath("//label[text()='Address Line 3']/..//input");
	By custEmailId = By.xpath("//label[text()='Email']/..//input");
	By custTaxId = By.xpath("//label[text()='Tax Id']/..//input");
	By custCity = By.xpath("//label[text()='City']/..//input");
	By custPostCode = By.xpath("//label[text()='Postal Code']/..//input");
	By custAddressType = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=2]");
	By custCountryType = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=3]");
	By custDistrictType = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=4]");
	By custSaveBtn = By.xpath("//*[@type='button']/div[text()='Save ']");
	By custCancelBtn = By.xpath("//*[@type='button']/div[text()='Cancel']");
	
	
	
	// 2. Page constructor
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	//3. Page actions
	public String getCustomerPageHeader() {
		return elementUtil.doGetText(header);
	}
		
	public void createCustomerRecord(
			String custKey, 
			String custCompany, 
			String custContactName, 
			String custPhoneNum,
			String custEmailId,
			String custTaxId,
			String custAddressType,
			String custAddress1,
			String custCountryType,
			String custDistrictType,
			String custCity,
			String custPostCode
			
			){
		elementUtil.waitForElementToBeVisible(header, 5);
	//	elementUtil.waitForElementToBeVisible(custAddBtn, 15);
		elementUtil.doClick(custAddBtn);
		//elementUtil.waitForElementToBeLocated(custKey, 5);
		elementUtil.doSendKeys(this.custKey,custKey );
		elementUtil.doSendKeys(this.custCompany,custCompany );
		elementUtil.doSendKeys(this.custContactName,custContactName );
		elementUtil.doSendKeys(this.custPhoneNum,custPhoneNum );
		elementUtil.doSendKeys(this.custEmailId,custEmailId );
		elementUtil.doSendKeys(this.custTaxId,custTaxId );
		elementUtil.doSendKeys(this.custAddressType,custAddressType );
		elementUtil.clickSendKeyTab(this.custAddressType);
		elementUtil.doSendKeys(this.custAddress1,custAddress1 );
		elementUtil.doSendKeys(this.custCountryType,custCountryType );
		elementUtil.clickSendKeyTab(this.custCountryType);
		elementUtil.doSendKeys(this.custDistrictType,custDistrictType );
		elementUtil.clickSendKeyTab(this.custDistrictType);
		elementUtil.doSendKeys(this.custCity,custCity );		
		elementUtil.doSendKeys(this.custPostCode,custPostCode );
		elementUtil.clickWhenReady(custSaveBtn, 5);
	}
}