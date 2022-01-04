package projects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
  @Test
  public void images() {
	  String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
	  
	  driver.findElement(
              MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(5).scrollIntoView(textContains(\"To-Do List\"))"))
              .click();
	  
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='To-Do List']")));
//	  driver.findElementByXPath("//android.widget.TextView[@text='To-Do List']").click();
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")));
	  String title = driver.findElementByXPath("//android.widget.TextView[@text='To-Do List']").getText();
	  System.out.println("Title:"+ title);
	  //wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@id='taskInput']")));
	  
	  //driver.findElementById("taskInput").sendKeys("abc");
	  driver.findElementByXPath("//*[@resource-id='taskInput']").sendKeys("abc");
	  driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	  driver.findElementByXPath("//*[@resource-id='taskInput']").sendKeys("def");
	  driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	  
	  int count = driver.findElementsByXPath("//*[@resource-id='tasksList']/android.view.View").size();
	  count=count-1;
	  System.out.println("Tasks Count:" + count);
	  //clear
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@resource-id='tasksCard']/android.view.View[3]")));
	  driver.findElementByXPath("//*[@resource-id='tasksCard']/android.view.View[3]").click();
	  
	  
	  
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
