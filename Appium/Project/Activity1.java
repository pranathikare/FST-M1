package projects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
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

public class Activity1 {
	AndroidDriver<MobileElement> driver = null;
	WebDriverWait wait = null;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("deviceName", "Emulator");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("appPackage", "com.google.android.apps.tasks");
	      caps.setCapability("appActivity", ".ui.TaskListsActivity");
	      caps.setCapability("noReset", true);
	      
	      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
	      driver = new AndroidDriver<MobileElement> (appServer, caps);
	      wait = new WebDriverWait(driver, 20);
	      //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
	      
	      //driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	  }

	
  @Test
  public void googleTask() {
	  String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
	  
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
	  
	  for (int i=0;i<tasks.length;i++)
	  {
		  driver.findElementByAccessibilityId("Create new task").click();
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		  driver.findElementById("add_task_title").sendKeys(tasks[i]);
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
		  driver.findElementById("add_task_done").click();
		  
	  }
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
	  List<MobileElement> list =   driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	  
	  for (int j=0;j<tasks.length;j++) {
		  System.out.println("tasks: "+  tasks[j]);
		  for (int i=0;i<list.size();i++) {
			  System.out.println("From app: "+ list.get(i).getText());
			  if (tasks[j].contentEquals(list.get(i).getText())) {
				  Assert.assertEquals(list.get(i).getText(), tasks[j]);
			  	  break;
			  }
				  
		  }
		  
	  }
	  

	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}
