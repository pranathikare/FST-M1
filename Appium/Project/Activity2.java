package projects;

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

public class Activity2 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("deviceName", "Emulator");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.google.android.keep");
	      caps.setCapability("appActivity", ".activities.BrowseActivity");
	      caps.setCapability("noReset", true);
	      
	      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
	      driver = new AndroidDriver<MobileElement> (appServer, caps);
	      wait = new WebDriverWait(driver, 20);
	      //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	      
	      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	  }

	
  @Test
  public void googleTask() {
	 	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
	  
	  String note = "Mobile Project note", title ="Mobile Project - Google Keep";
	  
	  
	  driver.findElementByAccessibilityId("New text note").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
	  driver.findElementById("edit_note_text").sendKeys(note);
	  //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_text_description")));
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(title);
	  
	  driver.findElementByAccessibilityId("Navigate up").click();
		  	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));
	  
	  String actTitle = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
	  String actNote = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
	  System.out.println("actTitle: "+actTitle);
	  System.out.println("actNote: "+actNote);
	  Assert.assertEquals(actNote, note);
	  Assert.assertEquals(actTitle, title);
	  }
	  

	  
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
