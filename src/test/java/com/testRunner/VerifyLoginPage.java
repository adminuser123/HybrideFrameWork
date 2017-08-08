package com.testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.factory.BrowserFactory;
import com.factory.DataProviderFactory;
import com.pages.HomePage;
import com.pages.LogInPage;

public class VerifyLoginPage {
	 WebDriver driver;

	@BeforeMethod
	public void setUp(){
		this.driver=BrowserFactory.getBrowser("firefox");
		this.driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testLogin(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.ClickCrossButton();
		
		home.ClickSigninLink();
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		login.getUserIdPass(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
	}
	

	@AfterMethod
	public void aftermethod(){
		BrowserFactory.closeBrowser(driver);
	}
}
