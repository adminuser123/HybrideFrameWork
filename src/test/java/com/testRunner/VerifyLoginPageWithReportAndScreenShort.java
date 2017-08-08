package com.testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.factory.BrowserFactory;
import com.factory.DataProviderFactory;
import com.pages.HomePage;
import com.pages.LogInPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Helper;

public class VerifyLoginPageWithReportAndScreenShort {
	 WebDriver driver;
	 ExtentReports report;
	 ExtentTest logger;

	@BeforeMethod
	public void setUp(){
		
		report = new ExtentReports(".//Reports//LoginPageReport.html",true);
		logger = report.startTest("Verify login");
		this.driver=BrowserFactory.getBrowser("firefox");
		this.driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "The Application is up and running");
	}
	
	@Test
	public void testLogin(){
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.ClickCrossButton();
		logger.log(LogStatus.INFO, "Clicks in cross button");
		
		home.ClickSigninLink();
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		login.getUserIdPass(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.cupterScreenShot(driver," Signin successfull")));
		logger.log(LogStatus.INFO, "Sign in successfull");
	}
	

	
	@AfterMethod
	public void aftermethod(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String path=Helper.cupterScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
