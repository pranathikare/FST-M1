package com.ibm.B16_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_9_2 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/selects");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        Select dropdown = new Select(driver.findElement(By.id("single-select")));
        
        WebElement ele = driver.findElement(By.id("single-value"));
        
        dropdown.selectByVisibleText("Option 2");
        System.out.println(ele.getText());
        
        dropdown.selectByIndex(3);
        System.out.println(ele.getText());
        
        dropdown.selectByValue("4");
        System.out.println(ele.getText());
        
        List<WebElement> options = dropdown.getOptions();
        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }
 
        
        driver.close();    
	}

}
