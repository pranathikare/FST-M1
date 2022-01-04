package examples;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class Activity1 {
	AndroidDriver<MobileElement> driver = null;
  @Test
  public void f() {
	  driver.findElementById("digit_5").click();
	  driver.findElementByAccessibilityId("plus").click();
	  driver.findElementById("digit_9").click();
	  String result = driver.findElement(MobileBy.id("result")).getText();
	  System.out.println("Sum as :"+result);
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.calculator2");
      caps.setCapability("appActivity", "com.android.calculator2.Calculator");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement> (appServer, caps);
      System.out.println("Calculator is open");
      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
