package examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
  @Test
  public void f() {
	  
	  Boolean ele1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("button_secondary")));
//	  WebElement ele = driver.findElementById("com.android.chrome:id/button_secondary");
	  if (!ele1 )
		  driver.findElementById("com.android.chrome:id/button_secondary").click();
	  
	  String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	  System.out.println("Title on Homepage: " + pageTitle);
	  
	  driver.findElementsByAccessibilityId("Close");
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@resource-id='about-link']")));
	  
	  driver.findElementByXPath("//android.view.View[@resource-id='about-link']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@text='About Us']")));
	  //String newTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").getText();
	  String newTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
	  System.out.println("Another Title :"+newTitle);
	  
	  
	  Assert.assertEquals(newTitle, "About Us");
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement> (appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
      driver.get("https://www.training-support.net/");
      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
