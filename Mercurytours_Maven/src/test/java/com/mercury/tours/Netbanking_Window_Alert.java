package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Netbanking_Window_Alert {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
	  // Using frame we try to go inside application
	  driver.switchTo().frame("login_page");
	  
	  //driver.switchTo().frame("#0); //If frame name is not available then we should use Index.
	  
	  //driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1000");
	  driver.findElement(By.xpath("//img[@src='/gif/continue_new1.gif?v=1']")).click();
	  String ActTest = driver.switchTo().alert().getText();
	  System.out.println(ActTest);
	  String ExpTest = "Customer ID  cannot be left blank.";
	  Assert.assertEquals(ActTest, ExpTest);
	  driver.switchTo().alert().accept();
	  
	  //driver.switchTo().defaultContent(); // To go back to default content ie default page
	  //Thread.sleep(3000);
	  //driver.findElement(By.xpath("//input[@name='fldPassword']")).sendKeys("12345");
	  //Thread.sleep(6000);
	  //driver.switchTo().defaultContent();
	  
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
		driver.get("https://netbanking.hdfcbank.com/netbanking");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
