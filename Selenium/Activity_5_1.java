package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_5_1 {
	
	public static void main(String []args) {
     
		FirefoxDriver driver = new FirefoxDriver();
		 

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
 

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkbox.isDisplayed());
 
        driver.findElement(By.id("toggleCheckbox")).click();
 
        System.out.println("The checkbox Input is displayed: " + checkbox.isDisplayed());
 
        driver.close();    }

}
