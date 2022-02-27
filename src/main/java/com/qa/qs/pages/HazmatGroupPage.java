package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.qs.util.ElementUtil;

public class HazmatGroupPage {
	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators

	By headerHazmatGroupPage = By.xpath("//h1[contains(text(),'Hazmat Group')]");
	By hzAddBtn = By.xpath("//div[contains(text(),'Add Hazmat Group')]");
	By addTitleHz = By.xpath("//h5[contains(text(),'Add')]");

	By hzDescription = By.xpath("//label[text()='Description *']/parent::kendo-textbox-container/textarea");
	By hzProperShippingName = By
			.xpath("//label[contains(text(),'Proper Shipping Name')]/parent::kendo-textbox-container//input");
	By hzTechName = By.xpath("//label[contains(text(),'TechnicalName')]/parent::kendo-textbox-container/textarea");
	By hzPackingInstructions = By
			.xpath("//label[contains(text(),'Packaging Instructions')]/parent::kendo-textbox-container/input");
	By hzLabelingInstructions = By
			.xpath("//label[contains(text(),'Labeling Instructions')]/parent::kendo-textbox-container/textarea");
	By hzIATA = By.xpath("//label[contains(text(),'IATA # *')]/parent::kendo-textbox-container/input");
	By hzClass = By.xpath("//label[contains(text(),'Class *')]/parent::kendo-textbox-container/input");
	By hzSubClass = By.xpath("//label[contains(text(),'Sub Class')]/parent::kendo-textbox-container/input");
	By hzPackingGroup = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=1]");
	By hzUM = By.xpath("//label[contains(text(),'U/M *')]/parent::kendo-textbox-container/input");
	By hzERR = By
			.xpath("//label[contains(text(),'Emergency Response Registrant')]/parent::kendo-textbox-container/input");
	By hzERP = By.xpath("//label[contains(text(),'Emergency Response Phone')]/parent::kendo-textbox-container/input");

	By hzPiSuffix = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=2]");

	By hzAlwaysShippedAsExceptedQty = By.xpath("//span[text()='Always Ship As Excepted Quantity']/parent::div/../i");
	By hzReportAsGrossWeight = By.xpath("(//input[@type='checkbox'])[position()=2]/..//i");
	By hzIsAtaSpec300 = By.xpath("(//input[@type='checkbox'])[position()=3]/..//i");

	By addHzAddBtn = By.xpath("(//*[@type='button']/div[contains(text(),'Add')])[position()=2]");
	By addHzCloseBtn = By.xpath("//*[@type='button']/div[contains(text(),'Close')]");

	// 2. Page constructor
	public HazmatGroupPage(WebDriver driver) {

		elementUtil = new ElementUtil(driver);
		this.driver = driver;

	}

	// 3. Page actions
	public String getHazmatGroupPageHeader() {
		return elementUtil.doGetText(headerHazmatGroupPage);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void createHazmatRecord(String hzDescription, String hzProperShippingName, String hzTechName,
			String hzPackingInstructions, String hzLabelingInstructions, String hzIATA, String hzClass,
			String hzSubClass, String hzPackingGroup, String hzUM, String hzERR, String hzERP, String hzPiSuffix,
			String hzAlwaysShippedAsExceptedQty, String hzReportAsGrossWeight, String hzIsAtaSpec300) {

		// elementUtil.waitForElementToBeVisible(header, 5);
		// elementUtil.waitForElementToBeVisible(custAddBtn, 15);
		// elementUtil.doClick(custAddBtn);
		elementUtil.clickWhenReady(hzAddBtn, 5);
		// elementUtil.waitForElementToBeLocated(custKey, 5);
		elementUtil.doSendKeys(this.hzDescription, hzDescription);
		elementUtil.doSendKeys(this.hzProperShippingName, hzProperShippingName);
		elementUtil.doSendKeys(this.hzTechName, hzTechName);
		elementUtil.doSendKeys(this.hzPackingInstructions, hzPackingInstructions);
		elementUtil.doSendKeys(this.hzLabelingInstructions, hzLabelingInstructions);
		elementUtil.doSendKeys(this.hzIATA, hzIATA);

		elementUtil.doSendKeys(this.hzClass, hzClass);
		elementUtil.doSendKeys(this.hzSubClass, hzSubClass);
		elementUtil.doSendKeys(this.hzPackingGroup, hzPackingGroup);
		elementUtil.clickSendKeyTab(this.hzPackingGroup);

		elementUtil.doSendKeys(this.hzUM, hzUM);
		elementUtil.doSendKeys(this.hzERR, hzERR);
		elementUtil.doSendKeys(this.hzERP, hzERP);

		elementUtil.doSendKeys(this.hzPiSuffix, hzPiSuffix);
		elementUtil.clickSendKeyTab(this.hzPiSuffix);
		/*
		 * elementUtil.doActionsClick(this.hzAlwaysShippedAsExceptedQty);
		 * elementUtil.doActionsClick(this.hzReportAsGrossWeight);
		 * elementUtil.doActionsClick(this.hzIsAtaSpec300);
		 */

		if (hzAlwaysShippedAsExceptedQty.equals("yes")) {

			elementUtil.doActionsClick(this.hzAlwaysShippedAsExceptedQty);
		}

		if (hzReportAsGrossWeight.equals("yes")) {

			elementUtil.doActionsClick(this.hzReportAsGrossWeight);

		}

		if (hzIsAtaSpec300.equals("yes")) {

			elementUtil.doActionsClick(this.hzIsAtaSpec300);

		}

		elementUtil.clickWhenReady(addHzAddBtn, 15);

	}

}
