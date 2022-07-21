package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"stepdefinitions"},
		tags="@All",
		plugin = {"json:target/jsonReports/report.json"},
		publish = true
		)
public class TestRunner {
	
}
