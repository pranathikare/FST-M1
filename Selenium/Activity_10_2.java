package com.ibm.B16_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_10_2 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/input-events");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        WebElement key = driver.findElement(By.id("keyPressed"));
        
        actions.sendKeys("P").build().perform();
        
        String keyText = key.getText();
        System.out.println("Pressed key is: " + keyText);
        
        Action actionSequence2 = actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build();
        actionSequence2.perform();
        keyText = key.getText();
        System.out.println("Pressed key is: " + keyText);
        
        driver.close();    
	}

}
