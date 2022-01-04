package com.ibm.TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity_9 {
//  @Test
//  public void f() {
//	  
//  }
	
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		Reporter.log("Page title is " + driver.getTitle());
	}
	
	@BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started");
        driver.switchTo().defaultContent();
    }
	
	@Test
	public void simpleAlertTestCase() {
		
		Reporter.log("simpleAlertTestCase() started");
    
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
 
        
        Alert simpleAlert = driver.switchTo().alert(); 
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText);
        
        Assert.assertEquals("This is a JavaScript Alert!", alertText);
 
        simpleAlert.accept();
        Reporter.log("Alert closed");
 
        Reporter.log("Test case ended");
	}
	
	
	@Test	
	public void confirmAlertTestCase() {
		
		Reporter.log("confirmAlertTestCase() started");       
        driver.findElement(By.id("confirm")).click();
        Reporter.log("Confirm Alert opened |");
 
        Alert confAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        String alertText = confAlert.getText();
        Reporter.log("Alert text is: " + alertText);
        
        Assert.assertEquals("This is a JavaScript Confirmation!", alertText);
 
        confAlert.accept();
        Reporter.log("Alert closed |");
 
        Reporter.log("Test case ended");
	}
	
	@Test
	
	public void promptAlertTestCase() {
		Reporter.log("promptAlertTestCase() started");
 
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened");
 
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert");
 
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText);
 
        promptAlert.sendKeys("Activity_9");
        Reporter.log("Text entered in prompt alert");
        
        Assert.assertEquals("This is a JavaScript Prompt!", alertText);
 
        promptAlert.accept();
        Reporter.log("Alert closed");
 
        Reporter.log("Test case ended");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
