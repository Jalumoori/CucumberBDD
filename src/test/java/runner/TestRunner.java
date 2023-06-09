package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resoures\\features"},
		glue = {"stepDefinitions","hooks"},
//		tags="@Valid",
		plugin = {"pretty","html:target\\cucumberReports\\CucumberReport.html"}
		)
public class TestRunner {

}
