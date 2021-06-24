package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.cssSelector("h1.ep-title-header");
	By menu = By.xpath("//li[@id='Menu']");
	By home = By.xpath("//li[@id='Home']");
	By account = By.xpath("//li[@id='Account']");
	By help = By.xpath("//li[@id='Help']");
	By AcntName = By.xpath("//div[@class='ep-indicator ng-star-inserted']//span[1]");
	By setUp = By.xpath("//h4[text()='Setup']");

	// 2. Page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// 3. Page actions

	public String getHomePageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.HOME_PAGE_TITLE, 10);

	}

	public String getHomePageHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public boolean isExistMenuIcon() {
		// return driver.findElement(menu).isDisplayed();
		return elementUtil.doIsDisplayed(menu);

	}

	public boolean isExistHomeIcon() {
		// return driver.findElement(home).isDisplayed();
		return elementUtil.doIsDisplayed(home);

	}

	public boolean isExistAccoutIcon() {
		// return driver.findElement(account).isDisplayed();
		return elementUtil.doIsDisplayed(account);

	}

	public boolean isExistHelpIcon() {
		// return driver.findElement(help).isDisplayed();
		return elementUtil.doIsDisplayed(help);

	}

	public String isExistWSnameTest() {
		if (elementUtil.doIsDisplayed(AcntName)) {
			return elementUtil.doGetText(AcntName);
		}
		return null;

	}

	public SetUpPage goToSetUpPage() {
		clickOnSetUp();
		return new SetUpPage(driver);

	}

	private void clickOnSetUp() {
		elementUtil.waitForElementToBeLocated(setUp, 5);
		elementUtil.doClick(setUp);
	}

}
