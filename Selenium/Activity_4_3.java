package com.ibm.B16_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity_4_3 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/target-practice");
		
		String  title = driver.getTitle();
		System.out.println("Title is: " + title);
		

		WebElement thrdele = driver.findElement(By.xpath("//h3[@id='third-header']"));
		if (thrdele.isDisplayed()) {
			System.out.println("Third header is Displayed: " + thrdele.getText() );
		}
		
		String fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color");
		System.out.println("Color of the Fifth Header is:" +fifthHeader);
		String hexacolor = Color.fromString(fifthHeader).asHex();
		System.out.println("Color of the Fifth Header is:" +hexacolor);
		
		
		//Find the violet button on the page and print all the class attribute values
		String attrval = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
		System.out.println("Third Violet button class attrivute value is: " + attrval);
		
		//Find the grey button on the page with Absolute Xpath
		
		WebElement ablXp = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/button[2]"));
		if(ablXp.isDisplayed()) {
			System.out.println("The grey colour button Displayed: " + ablXp.getText() );
		}
		driver.close();

	}

}
