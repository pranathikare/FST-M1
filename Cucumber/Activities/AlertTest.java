package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Alert alert;
	
	@Given("^User is on the page$")
    public void openPage() {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
 
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }
 
    @When("^User clicks the Simple Alert button$")
    public void openSimpleAlert() {
        driver.findElement(By.cssSelector("#simple")).click();
    }
    
    @Then("^Alert opens$")
    public void switchFocus() {
        alert = driver.switchTo().alert();
    }
    
    @And("^Read the text from it and print it$")
    public void readAlert() {
        System.out.println("Alert says: " + alert.getText());
    }
    
    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }
    
    @And("^Close Browser$")
    public void closeBrowser() {
        driver.close();
    }

    @When("^User clicks the Confirm Alert button$")
    public void openConfirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }
 
    @When("^User clicks the Prompt Alert button$")
    public void openPromptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }
 
    @And("^Write a custom message in it$")
    public void writeToPrompt() {
        alert.sendKeys("Custom Message");
    }
 
    @And("^Close the alert with Cancel$")
    public void closeAlertWithCAncel() {
        alert.dismiss();
    }

}
