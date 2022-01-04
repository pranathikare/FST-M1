package com.ibm.B16_Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Activity_8_2 {

	public static void main(String[] args) throws InterruptedException {
		
	  
        
        FirefoxDriver driver = new FirefoxDriver();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://training-support.net/selenium/tables");
        
        String title = driver.getTitle();
        System.out.println("Title of the page: "+title);
        
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        
        System.out.println("Number of rows are: " + rows.size());
        System.out.println("Number of columns are: " + cols.size());
        
        WebElement secRow = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Before sorting 2nd column Value: " + secRow.getText());
        
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();
        
        WebElement aftSecRow = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("After sorting, 2nd column Value: " + aftSecRow.getText());
        
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());
       
        
        driver.close();    
	}

}
