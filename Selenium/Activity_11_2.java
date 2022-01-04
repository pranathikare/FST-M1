package com.ibm.B16_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_2 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
        
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        //Accept alert
        driver.findElement(By.id("confirm")).click();
        
        Alert confAlert = driver.switchTo().alert(); 
        String alertText = confAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        
        confAlert.accept();
        
        //dismiss alert
        driver.findElement(By.id("confirm")).click();
        
        Alert dissAlert = driver.switchTo().alert();      
        
        dissAlert.dismiss();
        
        driver.close();    
	}

}
