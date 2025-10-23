package com.gen.Sauce;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.pom.Sauce.Home;
import com.pom.Sauce.Login;

public class Base {
	public static WebDriver driver;
	public static ChromeOptions options;
	
	@BeforeTest
	public void openBrowser()
	{
		options=new ChromeOptions();
		options.addArguments("--incognito");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException
	{
		ExcelReader reader=new ExcelReader();
		String url=reader.getData("SauceData", 1, 0);
		String un=reader.getData("SauceData", 4, 0);
		String pwd=reader.getData("SauceData", 4, 1);
		driver.get(url);
		Login in=new Login(driver);
		in.getLogin(un,pwd);
		
	}
	
	@AfterMethod
	public void logout()
	{
		Home hpage=new Home(driver);
		hpage.logOut();
		Reporter.log("Logged Out Successfully", true);
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
