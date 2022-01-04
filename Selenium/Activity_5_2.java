package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity_5_2 {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxDriver driver = new FirefoxDriver();
		 

        driver.get("https://training-support.net/selenium/dynamic-controls");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox is selected: " + checkbox.isSelected());
 
        checkbox.click();
 
        System.out.println("The checkbox Input is selected: " + checkbox.isSelected());
 
        driver.close();  

	}

}
