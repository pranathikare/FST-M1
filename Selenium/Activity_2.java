package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		
		String  title = driver.getTitle();
		System.out.println("Title is: " + title);
		
		driver.findElement(By.className("green"));
		driver.findElement(By.linkText("About Us"));
		driver.findElement(By.cssSelector("#about-link"));
		String text =driver.findElement(By.id("about-link")).getText();
		
		System.out.println("Text is: " + text);
		driver.close();

	}

}
