package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;
import com.qa.qs.util.Constants;
import com.qa.qs.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. Page locator: By Locator
	By regCode = By.xpath("//label[text()='Registration Code']/..//input");
	By userNamen = By.xpath("//label[text()='User Name']/..//input");
	By password = By.xpath("//label[text()='Password']/..//input");
	By loginBtn = By.xpath("//button[@type='submit']//div");
	By remMe = By.xpath("//span[text()='Remember Me']");
	
	//2. Create the constructor of the page class:
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
		
	}
	
	//3. page actions / page methods
	
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	 
	public boolean isRememberMeExist() {
		return elementUtil.doIsDisplayed(remMe);
	}
	
	public HomePage doLogin(String rc, String un, String pwd) {
		System.out.println("Login with :" + rc + " : " + un + " : " +pwd );
		//driver.findElement(regCode).sendKeys(rc);
		elementUtil.doSendKeys(regCode, rc);
		//driver.findElement(userNamen).sendKeys(un);
		elementUtil.doSendKeys(userNamen, un);
		//driver.findElement(password).sendKeys(pwd);
		elementUtil.doSendKeys(password,pwd);
		//driver.findElement(loginBtn).click();
		elementUtil.doClick(loginBtn);
		return new HomePage(driver);
		
		
		
		
		
	}

	
	
	
	
	
	
	
}
