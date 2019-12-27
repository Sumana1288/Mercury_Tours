package com.mercury.tours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ActionClass_Drag_Drop {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
	  Thread.sleep(5000);
	  Actions act = new Actions(driver);
	  WebElement drag=driver.findElement(By.id("draggable"));
	  WebElement drop=driver.findElement(By.id("droppable"));
	  act.dragAndDrop(drag, drop).build().perform();
	  Thread.sleep(5000);
	  
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
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
