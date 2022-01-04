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

public class Activity4 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait;
  @Test
  public void f() {
	  driver.findElementById("add_contact_button").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='First name']")));
	  
	  MobileElement fName = driver.findElementByXPath("//android.widget.EditText[@text='First name']");
      MobileElement lName = driver.findElementByXPath("//android.widget.EditText[@text='Last name']");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
	  
      fName.sendKeys("Aaditya");
      lName.sendKeys("Varma");
      phoneNumber.sendKeys("9991284782");
      driver.findElementById("editor_menu_save_button").click();
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
      
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());
      
      String contactName = driver.findElementById("large_title").getText();
      Assert.assertEquals(contactName, "Aaditya Varma");
      
      
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("deviceName", "Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.android.contacts");
      caps.setCapability("appActivity", ".activities.PeopleActivity");
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
