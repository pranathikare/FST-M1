package projects;

import java.net.MalformedURLException;
import java.net.URL;
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
  public void loginWithvalidCredentials() {
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
	  
	  driver.findElement(
              MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(5).scrollIntoView(textContains(\"Popups\"))"))
              .click();
	  
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@resource-id='username']")));
	  driver.findElementByXPath("//*[@resource-id='username']").sendKeys("admin");
	  driver.findElementByXPath("//*[@resource-id='password']").sendKeys("password");
//	  driver.findElementById("username").sendKeys("admin");
//	  driver.findElementById("password").sendKeys("password");
	 
	  //driver.findElementById("com.android.chrome:id/button_secondary").click();
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='action-confirmation']")));
	  String msg = driver.findElementByXPath("//*[@resource-id='action-confirmation']").getText();
	  System.out.println(msg);
	  
	  Assert.assertEquals(msg, "Welcome Back, admin");
	  
  }
  
  @Test
  public void loginWithInvalidCredentials() {
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
	  
	  driver.findElement(
              MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(5).scrollIntoView(textContains(\"Popups\"))"))
              .click();
	  
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@resource-id='username']")));
	  driver.findElementByXPath("//*[@resource-id='username']").sendKeys("user");
	  driver.findElementByXPath("//*[@resource-id='password']").sendKeys("password");
	  driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='action-confirmation']")));
	  String msg = driver.findElementByXPath("//*[@resource-id='action-confirmation']").getText();
	  System.out.println(msg);
	  
	  Assert.assertEquals(msg, "Invalid Credentials");
	  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "RZ8MA0EMBNV");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement> (appServer, caps);
      wait = new WebDriverWait(driver, 30);
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
      driver.get("https://www.training-support.net/selenium");
      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
