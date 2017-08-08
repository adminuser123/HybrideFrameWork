package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String cupterScreenShot(WebDriver driver, String ScreenShotName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String des = "./Screenshort/" +ScreenShotName + System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(des));
		} catch (Exception e) {
		
			System.out.println("Fail to take ScreenShort" + e.getMessage());
		}
		
		return des;
		
	}

}
