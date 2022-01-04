package com.ibm.B16_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_6_2 {

	public static void main(String[] args) {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/ajax");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        WebElement contentBtn = driver.findElement(By.xpath("//button[contains(@class,'violet button')]"));
        
        contentBtn.click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax-content")));
        
        String helloTxt = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(helloTxt);
        
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        
        String lateTxt = driver.findElement(By.id("ajax-content")).getText();
        System.out.println(lateTxt);
       
        driver.close();    
	}

}
