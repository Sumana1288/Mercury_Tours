package com.mercury.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Properties_File_Example {
	
	ChromeDriver driver;
  	
  	File file = new File("C:\\SeleniumTraining\\Workspace\\Mercurytours_Maven\\mercurytours.properties");
  	Properties prop = new Properties();
  @Test
  public void Sign_On() throws IOException {

	  	FileInputStream fileInput = new FileInputStream(file);
	  	prop.load(fileInput);
	  	
	  	driver.get(prop.getProperty("URL"));
		driver.findElement(By.linkText(prop.getProperty("lsignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Inuserpass"))).sendKeys("testing");
		driver.findElement(By.name("login")).click();
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
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
