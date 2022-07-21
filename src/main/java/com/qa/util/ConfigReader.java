package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties prop = new Properties();
	
	public String getProperty(String key) throws IOException {
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\GlobalConfig.properties");
	prop.load(fis);
	String value = prop.getProperty(key);
	return value;
	}

}
