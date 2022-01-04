package com.ibm.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity_6 {
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
	@Parameters({"username", "password"})
	public void loginTest(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(msg, "Welcome Back, admin");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
