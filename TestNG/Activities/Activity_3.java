package com.ibm.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_3 {
//  @Test
//  public void f() {
//	  
//  }
	
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/login-form");
	}
	
	@Test
	
	public void loginTest() {
		
		driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin", msg);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
