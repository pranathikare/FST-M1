package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Given("^User is on the Google Home Page$")
	public void userIsOnHomePage() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		driver.get("https://google.com");	
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void userTypesAndHitsEnter() {
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
		
	}
	
	@Then("^Show how many search results are available$")
	public void showResultsNumber() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
		String status = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Number of results found "+ status);
		
	}
	
	@And("^Close the browser$")
	public void closeBrowser() {
		driver.close();
	}
}
