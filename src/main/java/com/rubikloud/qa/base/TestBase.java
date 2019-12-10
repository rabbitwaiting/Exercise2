package com.rubikloud.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rubikloud.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try{
		// read properties
		prop= new Properties();
		FileInputStream input = new FileInputStream("/Users/owner/workspace/POM_Rubikloud.Test/src/main/java/com/rubikloud/qa/config/config.properties");
		prop.load(input);
		}
		catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException e){e.printStackTrace();}
	}
	
	public static void initializaion()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/owner/Downloads/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/owner/Downloads/chromedriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
