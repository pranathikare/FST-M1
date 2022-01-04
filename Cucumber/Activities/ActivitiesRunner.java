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
		tags ="@activity1_1",
		monochrome = true,
		plugin = {
				"pretty" , "html:target/cucumber-reports.html"
		}
		)
public class ActivitiesRunner {

}
