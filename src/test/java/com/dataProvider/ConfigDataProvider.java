package com.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	
	public ConfigDataProvider(){
		
		File src = new File("./Configuration/Config.proparties");
		try {
			FileInputStream fils = new FileInputStream(src);
			 pro = new Properties();
		pro.load(fils);
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("The Exception is" + e.getMessage());
		} catch (Exception e) {
			
			System.out.println("Properties exception" + e.getMessage());
		}
	}
	
	public String getApplicationUrl(){
		String url = pro.getProperty("url");
		return url;
		
	}
	public String getChromePath(){
		String chromePath = pro.getProperty("ChormePath");
		return chromePath;
	}
	public String getIePath(){
		String IEPath = pro.getProperty("IEPath");
		return IEPath;
	}
}
