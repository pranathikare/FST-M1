package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4_1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		
		String  title = driver.getTitle();
		System.out.println("Title is: " + title);
		
		driver.findElement(By.xpath("//a[@id='about-link']")).click();
		String title1 = driver.getTitle();
		
		System.out.println("Title after clicking About us is: " + title1);
		driver.close();

	}

}
