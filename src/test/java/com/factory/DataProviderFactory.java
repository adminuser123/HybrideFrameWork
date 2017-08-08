package com.factory;

import com.dataProvider.ConfigDataProvider;
import com.dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	
	public static ConfigDataProvider getConfig(){
		 ConfigDataProvider configData = new  ConfigDataProvider();
		 return configData;
		
	}
	public static ExcelDataProvider getExcel(){
		ExcelDataProvider configExcel = new  ExcelDataProvider();
		 return configExcel;
		
	}

}
