package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ElementUtil;

public class SetUpPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page locator: By Locator
	By header = By.xpath("//h1[text()='Setup']");
	By customerPageLink = By.xpath("//h4[text()='Customers']");

	// 2. create constructor
	public SetUpPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions / page methods

	public String getsetUpPagePageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.SETUP_PAGE_TITLE, 10);
	}

	public String getsetUpPagePageHeader() {
		return elementUtil.doGetText(header);
	}
	public CustomerPage goToCustomerPage() {
		clickOnCustomerPageLink();
		return new CustomerPage(driver);
	}

		
	public void clickOnCustomerPageLink() {
		//elementUtil.waitForElementToBeLocated(customerPageLink, 5);
		elementUtil.doClick(customerPageLink);
	}

	
	

	
	
	

}
