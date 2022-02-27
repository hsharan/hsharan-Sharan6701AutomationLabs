package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.ElementUtil;

public class TariffCodesPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators
	By header = By.xpath("//div//h1[text()=' Tariff Codes']");
	By tariffCodeAddBtn = By.xpath("//div//button/div[text()=' Add Tariff Code']");
	By addHeader = By.xpath("//div/h5[text()=' Add']");
	By addTariffCode = By.xpath("//label[text()='Tariff Code*']/..//input[@type='text']");
	By addDesc = By.xpath("//label[text()='Description*']/..//input[@type='text']");
	By addUM = By.xpath("//label[text()='U/M*']/..//input[@type='text']");

	By addSaveButton = By.xpath("//*[@type='button']/div[text()=' Save']");
	By addCloseButton = By.xpath("//*[@type='button']/div[text()=' Close ']");

	By updateTariffData = By.xpath("(//table/tbody/tr/td//span[@class='mdi-24px mdi mdi-pencil'])[position()=1]");
	By updateTariffDataSaveMsg = By.xpath("//div[contains(text(),'Saved successfully')]");

	By deleteTariffData = By.xpath("(//table/tbody/tr/td//span[@class='mdi-24px mdi mdi-delete'])[position()=1]");
	By deleteTariffDataMsg = By.xpath("//div[contains(text(),'Are you sure you want to delete ?')]");
	By deleteTariffDataYes = By.xpath("//button[text()=' Yes ']");
	By deleteTariffDataNo = By.xpath("//button[text()=' No ']");

	// 2. Page constructor
	public TariffCodesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page actions
	public String getTariffCodePageHeader() {
		return elementUtil.doGetText(header);
	}

	public void createTariffCodeRecord(String tariffCode, String tariffDesc, String tariffUM)
			throws InterruptedException {

		elementUtil.clickWhenReady(tariffCodeAddBtn, 15);

		elementUtil.doSendKeys(this.addTariffCode, tariffCode);
		elementUtil.doSendKeys(this.addDesc, tariffDesc);
		elementUtil.doSendKeys(this.addUM, tariffUM);
		elementUtil.clickWhenReady(addSaveButton, 15);
		Thread.sleep(5000);
		// elementUtil.clickWhenReady(tariffCodeAddBtn, 15);
	}

	/**
	 * Update data
	 */
	public void getUpdateTariffData() {
		elementUtil.clickWhenReady(updateTariffData, 15);
	}

	public String getUpdateTariffDataSave() {
		elementUtil.clickWhenReady(addSaveButton, 15);
		return elementUtil.doGetText(updateTariffDataSaveMsg);
	}

	/**
	 * Delete user profile
	 */
	public void getDeleteTariffData() {
		elementUtil.clickWhenReady(deleteTariffData, 15);
	}

	public String getDeleteTariffDataMsg() {
		return elementUtil.doGetText(deleteTariffDataMsg);
	}

	public void clickDeleteTariffDataNo() {
		
		elementUtil.doClick(deleteTariffDataNo);
	}

	public void clickDeleteTariffDataYes() {
		
	 elementUtil.doClick(deleteTariffDataYes);
	}

}
