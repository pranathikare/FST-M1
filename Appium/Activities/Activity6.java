package examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
  @Test
  public void images() {
	  
	  //MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
	  MobileElement pageTitle = driver.findElementByXPath("//android.view.View[@text='Lazy Loading']");
      wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
      List<MobileElement> list = driver.findElementsByClassName("android.widget.Image");
      System.out.println("No Of Images: "+list.size());
      
      Assert.assertEquals(list.size(), 2);
      //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
      
      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
      
      list = driver.findElementsByClassName("android.widget.Image");
      System.out.println("No Of Images after scrolling: "+list.size());
      
      Assert.assertEquals(list.size(), 19);
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement> (appServer, caps);
      wait = new WebDriverWait(driver, 20);
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
      driver.get("https://www.training-support.net/selenium/lazy-loading");
      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
