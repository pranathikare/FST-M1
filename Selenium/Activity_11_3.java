package com.ibm.B16_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_11_3 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
        
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        //Accept alert
        driver.findElement(By.id("prompt")).click();
        
        Alert promAlert = driver.switchTo().alert(); 
        String alertText = promAlert.getText();
        System.out.println("Alert text is: " + alertText);
        
        promAlert.sendKeys("Yes, you are!");
        
        promAlert.accept();
        
        driver.close();    
	}

}
