package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;

import com.beust.jcommander.Parameter;
import com.inetBanking.utilities.ReadConfig;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Base {
	ReadConfig readconfig=new ReadConfig();
	//public String baseUrl="http://demo.guru99.com/V1/index.php";
	public String baseUrl=readconfig.getApplicationUrl();
	public String userName=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) 
	{
		//1 Log 4j2 
				logger = LogManager.getLogger(Base.class.getName());
		// to select browser: We are passing from TestNg XMl file using parameters annotation	
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());  // using readconfig proprtires
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirePath());  // using readconfig proprtires
			driver=new FirefoxDriver();
			}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIePath());  // using readconfig proprtires
			driver=new InternetExplorerDriver();
			}
		
		// to launch URL
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(baseUrl);  // read base url from readconfig 
		
		
		
		
		
	}
	
	@AfterClass
	public void tearup() 
	{
		driver.quit();
	}
	// to take screen shot . We call this method in testcases whenever tests fails
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	// to genearate Random string and random number
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	

}
