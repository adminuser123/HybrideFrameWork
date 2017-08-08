package com.testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.factory.BrowserFactory;
import com.factory.DataProviderFactory;
import com.pages.HomePage;

public class VarifyHomePage {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp(){
		WebDriver driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
	
	@Test
	public void testHomePage(){
		
		HomePage home = PageFactory.initElements(driver,HomePage.class);
		String title = home.getApplicationTitle();
		Assert.assertTrue(title.contains("My Application title is Macy's"));
		System.out.println("My Application title is " + title);
	}
	
	
	@AfterMethod
	public void aftermethod(){
		BrowserFactory.closeBrowser(driver);
	}
	

}
