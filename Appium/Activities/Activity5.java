package examples;

import java.net.MalformedURLException;
import java.net.URL;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
  @Test
  public void sms() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
      
      driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

      // Enter the number to send message to
      String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";

      // Enter your own phone number
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactBoxLocator)));
      driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9886066897");
      ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
      
      // Wait for message box to load
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));

      // Type in a message
      driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Hello from Appium");

      // Send the message
      //driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
      driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon").click();
      
      // Wait for message to show
      String messageLocator = "resourceId(\"com.google.android.apps.messaging:id/message_text\")";
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));

      // Assertion
      String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
      Assert.assertEquals(sentMessageText, "Hello from Appium");
      
      
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.apps.messaging");
      caps.setCapability("appActivity", ".ui.ConversationListActivity");
      caps.setCapability("noReset", true);
      
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement> (appServer, caps);
      System.out.println("Contacts is open");
      wait = new WebDriverWait(driver, 30);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
