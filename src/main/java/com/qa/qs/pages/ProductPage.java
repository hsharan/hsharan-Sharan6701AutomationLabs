package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.util.ElementUtil;

public class ProductPage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators
	By headerProductPage = By.xpath("//h1[text()='Products']");
	By productAddBtn = By.xpath("//button//div[text()=' Add Product ']");

	By addProduct = By.xpath("//label[text()='Product*']/..//input[@type='text']");
	By addDescription = By.xpath("//label[text()='Description*']/..//input[@type='text']");
	By addUM = By.xpath("//label[text()='U/M']/..//input[@type='text']");
	By addHzGroup = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=1]");
	By addBOLClass = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=2]");
	By addTariffCode = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=3]");
	By addCountry = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=4]");
	By addNAFTAPreference = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=5]");
	By addProducer = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=6]");
	By addNetCostMethod = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=7]");
	By addECCN = By.xpath("(//span//input[@role='combobox' and @aria-haspopup='listbox'])[position()=8]");
	By addUnitWeight = By.xpath("//label[text()='Unit Weight']/..//input");
	By addHzMass = By.xpath("//label[text()='Hazmat Mass']/..//input");
	By addFairMktValue = By.xpath("//label[text()='Fair Market Value']/..//input");
	By addOriginProvince = By.xpath("//label[text()='Origin Province']/..//input[@type='text']");

	By addSaveBtn = By.xpath("//*[@type='button']/div[contains(text(),'Save')]");
	By addCancelBtn = By.xpath("//*[@type='button']/div[contains(text(),'Cancel')]");

	// 2. Page constructor
	public ProductPage(WebDriver driver) {

		elementUtil = new ElementUtil(driver);
		this.driver = driver;

	}

	// 3. Page actions
	public String getPorductPageHeader() {
		return elementUtil.doGetText(headerProductPage);
	}

    //prodName	prodDescription	prodUM	prodHZGroup	prodBOLClass	
	//prodUnitWeight	prodHZMass	prodTariffCode	prodCountry	prodNetCostMethod	
	//naftaPreference	prodProducer	prodFairMarketValue	prodECCN	prodOriginProvince

	public void addProductRecord(
			String prodName, 
			String prodDescription, 
			String prodUM, 
			String prodHZGroup,
			String prodBOLClass, 
			String prodUnitWeight, 
			String prodHZMass, 
			String prodTariffCode, 
			String prodCountry,
			String prodNetCostMethod,
			String naftaPreference, 
			String prodProducer, 
			String prodFairMarketValue, 
			String prodECCN,
			String prodOriginProvince) throws InterruptedException {

		elementUtil.clickWhenReady(productAddBtn, 15);

		elementUtil.doSendKeys(this.addProduct, prodName);
		elementUtil.doSendKeys(this.addDescription, prodDescription);
		elementUtil.doSendKeys(this.addUM, prodUM);
		elementUtil.doSendKeys(this.addHzGroup, prodHZGroup);
		elementUtil.doSendKeys(this.addBOLClass, prodBOLClass);
		elementUtil.doSendKeys(this.addUnitWeight, prodUnitWeight);
		elementUtil.doSendKeys(this.addHzMass, prodHZMass);
		elementUtil.doSendKeys(this.addTariffCode, prodTariffCode);
		elementUtil.doSendKeys(this.addCountry, prodCountry);
		elementUtil.doSendKeys(this.addNetCostMethod, prodNetCostMethod);
		elementUtil.doSendKeys(this.addNAFTAPreference, naftaPreference);
		elementUtil.doSendKeys(this.addProducer, prodProducer);
		elementUtil.doSendKeys(this.addFairMktValue, prodFairMarketValue);
		elementUtil.doSendKeys(this.addECCN, prodECCN);
		elementUtil.doSendKeys(this.addOriginProvince, prodOriginProvince);

		elementUtil.clickWhenReady(addSaveBtn, 15);
		Thread.sleep(5000);
		// elementUtil.clickWhenReady(tariffCodeAddBtn, 15);
	}

}
