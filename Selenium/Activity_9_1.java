package com.ibm.B16_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_9_1 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/selects");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        Select dropdown = new Select(driver.findElement(By.id("multi-select")));
        
        WebElement ele = driver.findElement(By.id("multi-value"));
        
        dropdown.selectByVisibleText("JavaScript");
        System.out.println(ele.getText());
        
        dropdown.selectByValue("node");
        System.out.println(ele.getText());
        
        for(int i=4; i<=6; i++) {
        	dropdown.selectByIndex(i);
        }
        System.out.println(ele.getText());
        
        dropdown.deselectByValue("node");
        System.out.println(ele.getText());
        

        dropdown.deselectByIndex(7);
        System.out.println(ele.getText());
        
        
        List<WebElement> options = dropdown.getAllSelectedOptions();
        for(WebElement option : options) {
            System.out.println("Selected Option: " + option.getText());
        }
        
        dropdown.deselectAll();
        System.out.println(ele.getText());
        
        driver.close();    
	}

}
