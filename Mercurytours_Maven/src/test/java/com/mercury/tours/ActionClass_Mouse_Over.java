package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ActionClass_Mouse_Over {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	  Thread.sleep(3000);
	  WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Electronic')]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(login).build().perform();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@href='/samsung-mobile-store?otracker=nmenu_sub_Electronics_0_Samsung']")).click();
	  Thread.sleep(3000);
	  
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
		driver.get("https://www.flipkart.com/");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
