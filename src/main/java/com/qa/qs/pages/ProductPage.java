package com.qa.qs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.qs.base.BasePage;

public class ProductPage extends BasePage {
	WebDriver driver;
	By prodId = By.id("prodid");
	public  ProductPage() {
		System.out.println("This is a product page");
		driver = this.driver;
		
	}
public String getTitle() {
	return driver.getTitle();
}
}
