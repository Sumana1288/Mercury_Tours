package com.mercury.tours;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Upload_File_Using_RobotClass {
	
	ChromeDriver driver;
	String screenfilepath = System.getProperty("user.dir");
	
	
  @Test
  public void Sign_On() throws InterruptedException{
	  String absolutePath=System.getProperty("user.dir");
	  String filepath=absolutePath+"\\Images\\1st-assesment.PNG";
	  System.out.println(filepath);
	  driver.findElement(By.id("btnChooseFiles")).click();
	  uploadFile(filepath);
	  Thread.sleep(10);
  } 
  
  public static void uploadFile(String fileLocation){
	  
	  try{
	  //Upload file through Robot API
	  StringSelection ss = new StringSelection(fileLocation);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
	  //native key strokes for CTRL, V and ENTER Keys
	  Robot robot = new Robot();
	  robot.delay(1000);
	  
	  // Press CTRL+V
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  
	  //Release CTRL+v
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyRelease(KeyEvent.VK_V);
	  
	  //Press Enter
	  robot.delay(1000);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  robot.delay(1000);
	  }
	  catch(Exception exp)
	  {
		  exp.printStackTrace();
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
		driver.get("https://gofile.io/?t=uploadFiles");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }
}
