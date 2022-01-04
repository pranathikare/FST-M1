package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_5_3 {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxDriver driver = new FirefoxDriver();
		 

        driver.get("https://training-support.net/selenium/dynamic-controls");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        WebElement textIp = driver.findElement(By.xpath("//input[@type='text']"));
        
        System.out.println("The text Input is Enabled: " + textIp.isEnabled());
 
        driver.findElement(By.id("toggleInput")).click();
        
        System.out.println("The text Input is Enabled: " + textIp.isEnabled());
 
        driver.close();    

	}

}
