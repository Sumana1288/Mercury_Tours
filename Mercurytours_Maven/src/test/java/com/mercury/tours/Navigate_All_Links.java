package com.mercury.tours;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Navigate_All_Links {
	
	ChromeDriver driver;
	
  @Test
  public void Sign_On() throws InterruptedException {
	  
	  List<WebElement> linksize = driver.findElements(By.tagName("a"));
	  int linkscount = linksize.size();
	  System.out.println("Total no of links Available:" + linkscount);
	  String[] links = new String[linkscount];
	  System.out.println("List of links Available:");
	  //print all the links from WebPage
	  for(int i = 0; i < linkscount; i++)
	  {
		  links[i] = linksize.get(i).getAttribute("href");
		  System.out.println(linksize.get(i).getAttribute("href"));
	  }
	  //navigate to each Link on the Web page
	  for(int i = 0; i<linkscount;i++)
	  {
		  driver.navigate().to(links[i]);
		  System.out.println(driver.getTitle());
		  driver.navigate().back();
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
		driver.get("https://www.google.com/");
  }

  @AfterTest
  public void After_Browser() {
	  driver.quit();
  }

}
