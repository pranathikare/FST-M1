package com.ibm.B16_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_1 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
        
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        driver.findElement(By.cssSelector("button#simple")).click();
        
        Alert simpleAlert = driver.switchTo().alert(); 
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        
        simpleAlert.accept();
        
        driver.close();    
	}

}
