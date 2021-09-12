package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjectClass.LoginPage;

public class TC_Logintest_001 extends Base
{
	//private static Logger log=LogManager.getLogger(Base.class); //already declared on base class
	@Test
	public void loginTest() throws IOException {
		driver.get(baseUrl);
		logger.info("Url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserNmae(userName);
		logger.info("Enter user name");
		lp.setPassword(password);
		logger.info("Enter Password");
		lp.clickSubmit();
		logger.info("Click submit button");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage12"))
		{
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		
		else
		{
			captureScreen(driver,"loginTest"); // We are calling this method to take screenshot.Method is present in Base class
			Assert.assertTrue(false);
		}
		
		
		
	}

}
