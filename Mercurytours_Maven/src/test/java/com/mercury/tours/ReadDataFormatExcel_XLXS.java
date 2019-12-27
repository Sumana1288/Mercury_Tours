package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadDataFormatExcel_XLXS extends Application_TestData{
	
	ChromeDriver driver;
	
	  @BeforeMethod
	  public void Launch_Browser() {
			String absolutepath = System.getProperty("user.dir");
			String filepath = absolutepath+"\\chromedriver.exe";
			//String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
			System.out.println(filepath);
			System.setProperty("Webdriver.chrome.driver", filepath);
			//System.setProperty("Webdriver.chrome.driver","C:\\SeleniumTraining\\Workspace\\HCL_Mercury_Tours\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  }
	  @Test(dataProvider="LoginDataXLXS")
	  public void Sign_On(String uname,String password) throws Exception {
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();
	  }
	  
	  @AfterTest
	  public void After_Browser() {
		  driver.quit();
	  }
}
