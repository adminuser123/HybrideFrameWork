package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	 WebDriver driver;
	
	public HomePage(WebDriver Idriver){
		this.driver = Idriver;
	}
	@FindBy(xpath=".//*[@id='lorem']/map/area[2]")WebElement crossButton;
	@FindBy(xpath= ".//*[@id='globalMastheadSignIn']") WebElement signinLink;
	@FindBy(xpath = "//a[text() ='My Account']") WebElement MyAccountLink;
	@FindBy(xpath = "//a[text()='Stores']")WebElement Stores;
	@FindBy(xpath="//a[text()='Customer Service']") WebElement CustomerService;
	
	
	public void ClickCrossButton(){
		crossButton.click();
	}
	public void ClickSigninLink(){
		signinLink.click();
	}
	public void ClickMyAccountLink(){
		MyAccountLink.click();
	}
	public void ClickStoreLink(){
		Stores.click();
	}
	public void ClickCustomerServiceLink(){
		CustomerService.click();
	}
	
public String getApplicationTitle(){
	return driver.getTitle();
}
}
