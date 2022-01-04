package com.ibm.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity_7 {
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
	
	@Test (dataProvider = "Authentication")
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
	
	@DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] { { "admin", "password" }};
    }
	
}
