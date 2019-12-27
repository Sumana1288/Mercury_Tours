package com.mercury.tours;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot_Example {
	
	ChromeDriver driver;
	String screenfilepath = System.getProperty("user.dir");
	
	
  @Test
  public void Sign_On() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("log")).click();
  } 
  
  @AfterMethod
  public void teardown(ITestResult result) throws IOException
  {
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File Browserscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //FileUtils.copyFile(Browserscreenshot, new File("C:\\SeleniumTraining\\Workspace\\Mercurytours_Maven\\Screenshot\\Login.png"));
		  FileUtils.copyFile(Browserscreenshot, new File(screenfilepath+"/"+"Screenshot"+"/"+result.getName()+"_"+System.nanoTime()+".png"));
	  }
	  
  }
  
  
  @BeforeTest
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

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }
}
