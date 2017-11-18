package com.Puma.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBase {
	public WebDriver driver;
	

	@BeforeClass
	public void setUp() throws IOException
	{
		init();
	}
	
	public  void init() throws IOException{
		
		Properties pr=new Properties();
		
		FileReader fr=new FileReader("config.properties");
		 pr.load(fr);
		 
		 selectBrowser( pr.getProperty("browser"));
		 driver.navigate().to(pr.getProperty("url"));
	}
	

	
	public  WebDriver selectBrowser(String browser){
		
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Personal\\chromedriver.exe");
		      driver = new ChromeDriver();
		      driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			  return driver;
			
		
				}
		return null;
		
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}

		

}
