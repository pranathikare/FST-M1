package com.ibm.B16_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_7_2 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");
        //(//input[@type = 'password'][1])[2]
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input")).sendKeys("Password");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input")).sendKeys("abc.der@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        
        String msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Success message: " + msg);
        
       
        
        driver.close();    
	}

}
