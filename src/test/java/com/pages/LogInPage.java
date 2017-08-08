package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
	WebDriver driver;
	public LogInPage(WebDriver Idriver){
		this.driver = Idriver;
	}
	
@FindBy(xpath=".//*[@id='email']")WebElement userId;
@FindBy(xpath=".//*[@id='password']")WebElement pass;
@FindBy(xpath=".//*[@id='signInBtn']") WebElement signInButton;
@FindBy(xpath="//a[@text()='(Sign Out)']") WebElement signOutButton;


public void getUserIdPass( String user,String password){


	userId.sendKeys(user);
	pass.sendKeys(password);
	signInButton.click();
}
}
