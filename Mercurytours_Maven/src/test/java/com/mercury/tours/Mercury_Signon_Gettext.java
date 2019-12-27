package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Signon_Gettext {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
		//To make script sleep to some time
		Thread.sleep(6000);
		
		//To get any text in page
		WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
		String ActValue = element.getText();
		String ExpValue = "SIGN-OFF";
		System.out.println(ActValue);
		Assert.assertEquals(ExpValue, ActValue);
		
		//To get Current URL
		String ActualValue = driver.getCurrentUrl();
		String ExpectedValue = "http://newtours.demoaut.com/mercuryreservation.php";
		System.out.println(ActualValue);
		Assert.assertEquals(ExpectedValue, ActualValue);
		
		//To get current page title
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Find a Flight: Mercury Tours:";
		System.out.println(ActualTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
		//To click on SIGN-OFF
		element.click();
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
