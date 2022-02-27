package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.util.ElementUtil;

public class ContainerTypePage {
	WebDriver driver;
	ElementUtil elementUtil;
//String s1="SharanLTL";
	// 1. By locators

	By headerContainerTypePage = By.xpath("//h5[contains(text(),'Container Types')]");
	By ctpAddBtn = By.xpath("//div[contains(text(),'Add')]");
	By addTitleCtp = By.xpath("//h5[contains(text(),'Add')]");

	By addCTCode = By.xpath("//label[text()='Code*']/..//input[@type='text']");
	By addBOLPieces = By.xpath("//label[contains(text(),' BOL #/Pieces')]/..//input[@type='text']");
	By addType = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=1]");
	By addLength = By.xpath("//label[contains(text(),'Length')]/..//input");
	By addWidth = By.xpath("//label[contains(text(),'Width')]/..//input");
	By addHeight = By.xpath("//label[contains(text(),'Height')]/..//input");
	By addTareWeight = By.xpath("//label[contains(text(),'Tare Weight')]/..//input");
	By selectChkBxAssigned = By
			.xpath("(//table//tr//td[contains(text(),'SharanLTL')]//following::input)[position()=1]");
	By selectChkBxDefault = By.xpath("(//table//tr//td[contains(text(),'MfgSys')]//following::input)[position()=2]");
	By addSaveBtn = By.xpath("//*[@type='button']/div[text()=' Save']");
	By addCancelBtn = By.xpath("//*[@type='button']/div[text()='Cancel']");

	// Update xpath
	By editCTRecord = By
			.xpath("(//div[text()='2']/parent::span/../following-sibling::td)[4]//span[contains(@class,'pencil')]");
	By editSaveBtn = By.xpath("//*[@type='button']/div[contains(text(),'Save')]");
	By deleteCTRecord = By
			.xpath("(//div[text()='2']/parent::span/../following-sibling::td)[4]//span[contains(@class,'delete')]");

	By deleteCTRecordYes = By.xpath("//button[contains(text(),'Yes')]");
	By deleteCTRecordNo = By.xpath("//button[contains(text(),'No')]");
	
	// 2. Page constructor
	public ContainerTypePage(WebDriver driver) {

		elementUtil = new ElementUtil(driver);
		this.driver = driver;

	}

	// 3. Page actions
	public String getContainerTypePageHeader() {
		return elementUtil.doGetText(headerContainerTypePage);
	}

	// Add data> Code BOLPieces Type Length Width Height TareWeight Assigned Default

	public void addContainrTypeRecord(String Code, String BOLPieces, String Type, String Length, String Width,
			String Height, String TareWeight, String Assigned, String Default) throws InterruptedException {

		elementUtil.clickWhenReady(ctpAddBtn, 15);

		elementUtil.doSendKeys(this.addCTCode, Code);
		elementUtil.doSendKeys(this.addBOLPieces, BOLPieces);
		elementUtil.doSendKeys(this.addType, Type);

		elementUtil.doSendKeys(this.addLength, Length);
		elementUtil.doSendKeys(this.addWidth, Width);
		elementUtil.doSendKeys(this.addHeight, Height);

		elementUtil.doSendKeys(this.addTareWeight, TareWeight);
		// elementUtil.doSendKeys(this.selectChkBxAssigned, Assigned);
		// elementUtil.doSendKeys(this.selectChkBxDefault, Default);

		if (Assigned.equals("yes")) {

			elementUtil.doActionsClick(this.selectChkBxAssigned);
		}

		if (Default.equals("yes")) {

			elementUtil.doActionsClick(this.selectChkBxDefault);

		}

		elementUtil.clickWhenReady(addSaveBtn, 15);
		Thread.sleep(5000);
		// elementUtil.clickWhenReady(tariffCodeAddBtn, 15);
	}

	/**
	 * Update data
	 */
	public void updateContainerTypeData() {
		elementUtil.clickWhenReady(editCTRecord, 15);
	}

	public void updateContainerTypeDataConfirm() {
		elementUtil.clickWhenReady(editSaveBtn, 15);
	}
	
	/**
	 * Delete user profile
	 */
	public void deleteContainerTypeData() {
		elementUtil.clickWhenReady(deleteCTRecord, 15);
	}

	public void deleteContainerTypeDataConfirm() {
		elementUtil.clickWhenReady(deleteCTRecordYes, 15);
	}

}
