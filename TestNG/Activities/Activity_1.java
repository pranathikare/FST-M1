package com.ibm.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_1 {
//  @Test
//  public void f() {
//	  
//  }
	
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net");
	}
	
	@Test
	public void checkTitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Training Support");
		
		driver.findElement(By.id("about-link")).click();
		String newTitle = driver.getTitle();
		System.out.println("New page title is: " + newTitle);
		
		Assert.assertEquals(newTitle, "About Training Support");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
