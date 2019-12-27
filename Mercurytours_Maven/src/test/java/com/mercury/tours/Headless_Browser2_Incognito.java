package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Headless_Browser2_Incognito {
	
	ChromeDriver driver;
	ChromeOptions options = new ChromeOptions();
	
  @Test
  public void Sign_On() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
  }
  @BeforeTest
  public void Launch_Browser() {
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\chromedriver.exe";
		//String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.out.println(filepath);
		System.setProperty("Webdriver.chrome.driver", filepath);
		options.setHeadless(false);
		options.addArguments("incognito"); //incognito mode open browser in private window
		//System.setProperty("Webdriver.chrome.driver","C:\\SeleniumTraining\\Workspace\\HCL_Mercury_Tours\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @AfterTest
  public void Close_Browser() {
	  driver.quit();
  }

}
