package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		
		String  title = driver.getTitle();
		System.out.println("Title is: " + title);
		
		driver.findElement(By.id("firstName")).sendKeys("Pranathi");
		driver.findElement(By.id("lastName")).sendKeys("Kare");
		driver.findElement(By.id("email")).sendKeys("pranathi@gmail.com");
		driver.findElement(By.id("number")).sendKeys("1234567890");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.close();

	}

}