package com.ibm.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_2 {
//  @Test
//  public void f() {
//	  
//  }
	
	private FirefoxDriver driver;
	
	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void testcase1() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Target Practice");
	}
	
	@Test
    public void testCase2() {
        //Fail
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        //Assert.assertEquals(blackButton.getText(), "black");
        Assert.assertTrue(!blackButton.isEnabled());
    }
    
    @Test(enabled = false)
    public void testCase3() {
        //This test will be skipped and not counted
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    
    @Test
    public void testCase4() {
        //This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case with throw exception");      
    }
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
}
