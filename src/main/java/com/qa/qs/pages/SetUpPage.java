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
	By tariffCodePageLink = By.xpath("//h4[text()=' Tariff Codes']");
	By userProfilePageLink = By.xpath("//h4[text()='Users']");
	By bolClassPageLink = By.xpath("//h4[contains(text(),'BOL Class')]");
	By productPageLink = By.xpath("//h4[contains(text(),'Products')]");
	By hazmatGroupPageLink = By.xpath("//h4[contains(text(),'Hazmat Group')]");
	By containerTypePageLink = By.xpath("//h4[contains(text(),' Container Types')]");

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

	/**
	 * Customer PageLink
	 */
	public CustomerPage goToCustomerPage() {
		clickOnCustomerPageLink();
		return new CustomerPage(driver);
	}

	public void clickOnCustomerPageLink() {
		// elementUtil.waitForElementToBeLocated(customerPageLink, 5);
		elementUtil.doClick(customerPageLink);
	}

	/**
	 * TariffCode PageLink
	 */
	public TariffCodesPage goToTariffCodePage() {
		clickOnTariffCodePageLink();
		return new TariffCodesPage(driver);
	}

	public void clickOnTariffCodePageLink() {
		// elementUtil.waitForElementToBeLocated(customerPageLink, 5);
		elementUtil.doClick(tariffCodePageLink);
	}

	/**
	 * User Profile PageLink
	 */
	public UserProfilePage goToUserProfilePage() {
		clickOnUserProfilePageLink();
		return new UserProfilePage(driver);
	}

	public void clickOnUserProfilePageLink() {
		// elementUtil.waitForElementToBeLocated(customerPageLink, 5);
		elementUtil.doClick(userProfilePageLink);
	}

	/**
	 * BOL Class PageLink
	 */
	public BolClassPage goToBOLClassPage() {
		clickOnBOLClassPageLink();
		return new BolClassPage(driver);
	}

	private void clickOnBOLClassPageLink() {
		elementUtil.doClick(bolClassPageLink);

	}

	
	/**
	 * Product PageLink
	 */
	public ProductPage goToProductPage() {
		clickOnProductPageLink();
		return new ProductPage(driver);
	}

	private void clickOnProductPageLink() {
		elementUtil.doClick(productPageLink);

	}
	
	
	/**
	 * HazMat Group PageLink
	 */
	public HazmatGroupPage goToHazmatGroupPage() {
		clickOnHazmatGroupPageLink();
		return new HazmatGroupPage(driver);
	}

	private void clickOnHazmatGroupPageLink() {
		elementUtil.doClick(hazmatGroupPageLink);

	}
	
	/**
	 * Container Type PageLink
	 */
	public ContainerTypePage goToContainerTypePage() {
		clickOnContainerTypePageLink();
		return new ContainerTypePage(driver);
	}

	private void clickOnContainerTypePageLink() {
		elementUtil.doClick(containerTypePageLink);

	}
	
	
}
