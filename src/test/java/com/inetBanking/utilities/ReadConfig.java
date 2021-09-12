package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	//constructor to load  config file
	public ReadConfig() {
		File src=new File("./Configuration\\config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	//Methods to get Values from Config proprties
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
		
	}
	
	public String getUserName() {
		String username=pro.getProperty("userName");
		return username;
		
	}
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
		
	}
	public String getChromePath() {
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
		
	}
	public String getIePath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
		
	}
	public String getFirePath() {
		String firepath=pro.getProperty("firepath");
		return firepath;
		
	}

}
