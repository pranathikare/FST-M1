package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {
				"stepDefinations"
		},
		tags ="@SmokeTest",
		monochrome = true,
		plugin = {
				"pretty" , "html:target/cucumber-reports.html" , "html: target/test-reports.html", "json: target/json-report.json"
		}
		)
public class ActivitiesRunner6 {

}
