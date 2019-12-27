package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Mercury_Signon_Following_Preceding_Sibling {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {

	  //Following Sibling XPATH
	  driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
	  Thread.sleep(3000);
	  
	  //Preceding Sibling XPATH
	  driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
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
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
