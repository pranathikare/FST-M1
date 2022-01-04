package com.ibm.B16_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_6_1 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/dynamic-controls");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        WebElement toggleBtn = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        
        toggleBtn.click();
        
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
       
        toggleBtn.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
        
        driver.close();    
	}

}
