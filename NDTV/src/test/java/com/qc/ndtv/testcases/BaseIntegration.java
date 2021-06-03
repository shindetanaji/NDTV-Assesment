package com.qc.ndtv.testcases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qc.ndtv.utils.ReadData;

public class BaseIntegration {

	Properties prop;
	WebDriver driver;
	ReadData data = new ReadData();
	
	@BeforeSuite
		public void doSetup() throws IOException{
			prop = data.getCommonData();
			if(prop.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			}else {
				driver = new FirefoxDriver();
			}
			driver.get(prop.getProperty("siteUrl"));
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getMenu() throws IOException{
		
		return data.getMenuData(prop.getProperty("ndtvData"));
	}
}
