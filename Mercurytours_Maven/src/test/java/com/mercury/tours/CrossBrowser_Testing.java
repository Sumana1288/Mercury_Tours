package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Testing extends Application_TestData{
	WebDriver driver;
	
	  @Test(dataProvider = "Login")
	  public void Sign_On(String uname, String upass) {
		  	driver.get("http://newtours.demoaut.com/mercurysignon.php");
			driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();
			driver.findElement(By.linkText("SIGN-OFF")).click();
	  }
@BeforeTest
@Parameters("browser")
public void beforeTest(String browser) {
	
	if(browser.equalsIgnoreCase("Chrome")){
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\chromedriver.exe";
		//String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.out.println(filepath);
		System.setProperty("Webdriver.chrome.driver", filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\SeleniumTraining\\Workspace\\HCL_Mercury_Tours\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("IE")){
		String absolutepath = System.getProperty("user.dir");
		String filepath = absolutepath+"\\chromedriver.exe";
		//String filepath = absolutepath+"\\Drivers"+"\\chromedriver.exe";
		System.out.println(filepath);
		System.setProperty("Webdriver.chrome.driver", filepath);
		//System.setProperty("Webdriver.chrome.driver","C:\\SeleniumTraining\\Workspace\\HCL_Mercury_Tours\\chromedriver.exe");
		driver = new InternetExplorerDriver();
	}
	else{
		System.out.println("No Browser Found");
	}
		driver.manage().window().maximize();
		//driver.get("http://newtours.demoaut.com/mercurysignon.php");
}

@AfterTest
public void afterTest() {
	  driver.quit();
}
}
