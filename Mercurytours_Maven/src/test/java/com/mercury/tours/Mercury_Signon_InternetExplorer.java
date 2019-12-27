package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Signon_InternetExplorer {
	
	WebDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		
  }
  @BeforeTest
  public void Launch_Browser() {
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\IEDriverServer.exe";
		//String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.out.println(filepath);
		System.setProperty("Webdriver.IE.driver", filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\SeleniumTraining\\Workspace\\HCL_Mercury_Tours\\chromedriver.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
